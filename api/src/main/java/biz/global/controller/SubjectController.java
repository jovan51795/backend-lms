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

import biz.global.model.ResponseModel;
import biz.global.model.Subject;
import biz.global.repo.SubjectRepo;


@RestController
@RequestMapping("api/subject/")
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {
	
	@Autowired
	private SubjectRepo subjectRepo;

	
	@GetMapping(value= "all")
    List<Subject> getSubjects() {
        return subjectRepo.getAllSubject();
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
    
    @PatchMapping("update")
    public ResponseEntity<ResponseModel> updateSubject(@RequestBody Subject subject) {
    	Optional<Subject> sub = Optional.ofNullable(subjectRepo.findBySubjectCode(subject.getSubjectCode()));
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

	
}
