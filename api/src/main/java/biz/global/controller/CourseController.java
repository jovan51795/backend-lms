package biz.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import biz.global.model.Course;
import biz.global.model.Student;
import biz.global.repo.CourseRepo;

@RestController
@RequestMapping("api/courses/")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {
	
	@Autowired
	private CourseRepo courseRepo;
	
	@GetMapping(value = "all")
	public List<Course> getAllCourse() throws JsonProcessingException {
		
		List<Course> course = courseRepo.findAll();
		return course;
	}

}
