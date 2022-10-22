package biz.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import biz.global.model.Course;
import biz.global.model.ResponseModel;
import biz.global.repo.CourseRepo;
import biz.global.repo.SubjectRepo;

@RestController
@RequestMapping("api/courses/")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private SubjectRepo subjectRepo;
	
	public ResponseEntity<ResponseModel> checker(List<Object> get){
    	if(get.isEmpty()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(0, "No data exist", null, null));
    	}
    	 return ResponseEntity.ok().body(new ResponseModel(1, "Success", null, get));
    }
	
	//////////////////////////////////////////////////////////////////////////////////  GET MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
    @GetMapping(value = "all")
    public List<Course> getAllCourse() throws JsonProcessingException {
        
        List<Course> course = courseRepo.findAll();
        return course;
    }
    
    @GetMapping(value="getSubjectByCourse")
    public ResponseEntity<ResponseModel> getAllSubjectbyCourse(@RequestParam Long id){
    	List<Object> get = subjectRepo.getAllSubjectbyCourse(id);
    	return checker(get);
    }
    
	//////////////////////////////////////////////////////////////////////////////////  POST MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
	    

	    
	    
	//////////////////////////////////////////////////////////////////////////////////  DELETE MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
    
	    
	    
	    
	//////////////////////////////////////////////////////////////////////////////////  PATCH MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
    
	

}
