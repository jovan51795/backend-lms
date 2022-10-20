package biz.global.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.global.model.Professor;
import biz.global.model.ProfessorLoad;
import biz.global.model.ResponseModel;
import biz.global.model.Subject;
import biz.global.model.SubjectDetailHistory;
import biz.global.repo.ProfessorLoadRepo;
import biz.global.repo.ProfessorRepo;
import biz.global.repo.SubjectDetailHistoryRepo;
import biz.global.repo.SubjectRepo;


@RestController
@RequestMapping("api/subject/")
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {
	
	@Autowired
	private SubjectRepo subjectRepo;
	
	@Autowired
	private ProfessorRepo professorRepo;
	
	@Autowired
	private SubjectDetailHistoryRepo subjectDetailHistoryRepo;
	
	@Autowired
	private ProfessorLoadRepo professorLoadRepo;
	
	@GetMapping(value= "all")
    List<Subject> getSubjects() {
        return subjectRepo.findAll();
    }

    @PostMapping(value="add")
    public ResponseEntity<ResponseModel> createSubject(@RequestBody Subject subject) {
    	
    	Optional<Subject> subj = Optional.ofNullable(subjectRepo.findBySubjectCode(subject.getSubjectCode()));
    	if(subj.isPresent()) {
    		return ResponseEntity.ok().body(new ResponseModel(0, "Subject Code already exist", "", null));
    	}

    	Subject sub = subjectRepo.save(subject);
        return ResponseEntity.ok().body(new ResponseModel(1, "subject successfully added", "", sub));
    }
    
    @PatchMapping("update/{id}")
    public ResponseEntity<ResponseModel> updateSubject(@PathVariable Long id,@RequestBody Subject subject) {
    	Optional<Subject> sub = subjectRepo.findById(id);
    	if(sub.isEmpty()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(0, "subject does not exist", null, null));
    	}
    	subject.setSubject_id(sub.get().getSubject_id());
    	subjectRepo.save(subject);
    	return ResponseEntity.ok().body(new ResponseModel(1, "updated successfully", null, subject));
    }
    
    @DeleteMapping("delete")
    public ResponseEntity<ResponseModel> deleteSubject(@RequestBody String subject_code) {
    	Optional<Subject> sub = Optional.ofNullable(subjectRepo.findBySubjectCode(subject_code));
    	if(sub.isEmpty()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(0, "subject does not exist", null, null));
    	}
    	
    	subjectRepo.deleteById(sub.get().getSubject_id());
    	return ResponseEntity.ok().body(new ResponseModel(1, "subject deleted successfully", null, null));
    }

    @PutMapping("/{subjectId}/professor/{professorId}")ResponseEntity<ResponseModel> addProfessorToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long professorId,
            @RequestBody SubjectDetailHistory subhistory
    ) {
        Subject subject = subjectRepo.findById(subjectId).get();
        Professor professor = professorRepo.findById(professorId).get();
        
        SubjectDetailHistory history = new SubjectDetailHistory(subhistory.getAcademicYear(), subhistory.getSem(), subhistory.getSchedule(),subhistory.getSection(), 
        		subhistory.getYearLevel(),subhistory.getStatus(),  subject, professor);
        
        ProfessorLoad profLoad = new ProfessorLoad(subject.getSubjectTitle(), subhistory.getSection(), subhistory.getYearLevel(),professor);
        subject.setProfessor(professor);	
        subjectRepo.save(subject);
        subjectDetailHistoryRepo.save(history);
        professorLoadRepo.save(profLoad);
        return ResponseEntity.ok().body(new ResponseModel(1, "Added successfully", null, null));
    }
    
    @GetMapping(value = "getbyid/{id}")
    private ResponseEntity<ResponseModel> getSubjectByID(@PathVariable Long id) {
    	Optional<Subject> sub = subjectRepo.findById(id);
    	if(sub.isEmpty()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(0, "subject does not exist", null, null));
    	}
    	
    	return ResponseEntity.ok().body(new ResponseModel(1, "subject exist", null, sub.get()));
    	
    }
    
}
