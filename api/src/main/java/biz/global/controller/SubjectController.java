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
import biz.global.wrapper.SubjectSubjectDetailHistoryWrapper;


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
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////  GET MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


	
    @GetMapping(value= "all")
    List<Subject> getSubjects() {
        return subjectRepo.findAll();
    }

    
    @GetMapping(value = "getbyid/{id}")
    private ResponseEntity<ResponseModel> getSubjectByID(@PathVariable Long id) {
        Optional<Subject> sub = subjectRepo.findById(id);
        if(sub.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(0, "subject does not exist", null, null));
        }
        
        return ResponseEntity.ok().body(new ResponseModel(1, "subject exist", null, sub.get()));
        
    }
    
	
	
    
    
    
	//////////////////////////////////////////////////////////////////////////////////  POST MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	    
    
	@PostMapping(value="add")
	
    public ResponseEntity<ResponseModel> createSubject( 
            @RequestBody SubjectSubjectDetailHistoryWrapper wrapper) {

        Optional<Subject> subj = Optional.ofNullable(subjectRepo.findBySubjectCode(wrapper.getSubject().getSubjectCode()));
        
        SubjectDetailHistory subhistory = wrapper.getSubjectDetailHistory();
        if(subj.isPresent()) {
            return ResponseEntity.ok().body(new ResponseModel(0, "Subject code already exist", "", ""));
        }
        else {
            Subject sub = subjectRepo.save(wrapper.getSubject());
            SubjectDetailHistory history1 = new SubjectDetailHistory(subhistory.getAcademicYear(), subhistory.getSem(), subhistory.getSchedule(),"A", subhistory.getYearLevel(), sub);
            SubjectDetailHistory history2 = new SubjectDetailHistory(subhistory.getAcademicYear(), subhistory.getSem(), subhistory.getSchedule(),"B", subhistory.getYearLevel(), sub);
            subjectDetailHistoryRepo.save(history1);
            subjectDetailHistoryRepo.save(history2);
            return ResponseEntity.ok().body(new ResponseModel(1, "Subject added", "", sub));
        }
    }
	
	

    @PostMapping("/{subjectID}/professor/{profID}")
    ResponseEntity<ResponseModel> addProfessorToSubject(
            @PathVariable Long subjectID,
            @PathVariable Long profID,
            @RequestBody SubjectDetailHistory subhistory) {
        Optional<Subject> subjectData= subjectRepo.findById(subjectID);
        Optional<Professor> profData =professorRepo.findById(profID);
        Optional<SubjectDetailHistory> findDetail =Optional.ofNullable(subjectDetailHistoryRepo.findHistory(subjectID, profID));
        Optional<ProfessorLoad> findLoad =Optional.ofNullable(professorLoadRepo.findProfessorLoad(subjectID, profID));
        
        if (findDetail.isPresent()) {
            findDetail.get().setAcademicYear(subhistory.getAcademicYear());
            findDetail.get().setSem(subhistory.getSem());
            findDetail.get().setSchedule(subhistory.getSchedule());
            findDetail.get().setSection(subhistory.getSection());
            findDetail.get().setYearLevel(subhistory.getYearLevel());
            findDetail.get().setStatus(subhistory.getStatus());
            findDetail.get().setStartDate(subhistory.getStartDate());
            findLoad.get().setSubjectTitle(subjectData.get().getSubjectTitle());
            findLoad.get().setSection(subhistory.getSection());
            findLoad.get().setYearLevel(subhistory.getYearLevel());

            subjectData.get().setProfessor(profData.get()); 
            subjectRepo.save(subjectData.get());
            subjectDetailHistoryRepo.save(findDetail.get());
            return ResponseEntity.ok().body(new ResponseModel(1, "Record has been modified", null, findDetail));
        }else {
            SubjectDetailHistory history = new SubjectDetailHistory(subhistory.getAcademicYear(), subhistory.getSem(), subhistory.getSchedule(),subhistory.getSection(), subhistory.getYearLevel(),subhistory.getStatus(), subhistory.getStartDate(), subjectData.get(), profData.get());
            ProfessorLoad profLoad = new ProfessorLoad(subjectData.get().getSubjectTitle(), subhistory.getSection(), subhistory.getYearLevel(),profData.get(), subjectData.get());
            subjectData.get().setProfessor(profData.get()); 
            subjectRepo.save(subjectData.get());
            subjectDetailHistoryRepo.save(history);
            professorLoadRepo.save(profLoad);
            return ResponseEntity.ok().body(new ResponseModel(1, "Record successfully added", null, history));
        }
        
        
    }
	
	
	    
	    
	//////////////////////////////////////////////////////////////////////////////////  DELETE MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
	    
    
	@DeleteMapping("delete")
    public ResponseEntity<ResponseModel> deleteSubject(@RequestBody String subject_code) {
        Optional<Subject> sub = Optional.ofNullable(subjectRepo.findBySubjectCode(subject_code));
        if(sub.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(0, "subject does not exist", null, null));
        }
        
        subjectRepo.deleteById(sub.get().getSubject_id());
        return ResponseEntity.ok().body(new ResponseModel(1, "subject deleted successfully", null, null));
    }
	    
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////  PATCH MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
	
	
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
	
	
	
	
	
	
	
	
	

}
