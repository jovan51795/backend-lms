package biz.global.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import biz.global.dto.AttendanceDto;
import biz.global.exception.ResourceNotFoundException;
import biz.global.model.Admin;
import biz.global.model.Attendance;
import biz.global.model.Grades;
import biz.global.model.Professor;
import biz.global.model.ResponseModel;
import biz.global.model.Student;
import biz.global.model.Subject;
import biz.global.repo.AttendanceRepo;
import biz.global.repo.GradesRepo;
import biz.global.repo.ProfessorRepo;
import biz.global.repo.StudentRepo;
import biz.global.repo.SubjectRepo;
import biz.global.service.AuthService;
import biz.global.util.JWTUtility;

@RestController
@RequestMapping("api/professor/")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfessorController {
	@Autowired
	private ProfessorRepo professorRepo;

	@Autowired
	private SubjectRepo subjectRepo;

	@Autowired 
	private AttendanceRepo attendanceRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private GradesRepo gradesRepo;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private JWTUtility jwtUtility;
	
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	
	
	@GetMapping(value= "all")
    List<Professor> getprofessors() {
        return professorRepo.findAll();
    }
	
	
	
	
	 public ResponseEntity<ResponseModel> checker(List<Object> get){
	    	if(get.isEmpty()) {
	    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(0, "No data exist", null, null));
	    	}
	    	 return ResponseEntity.ok().body(new ResponseModel(1, "Success", null, get));
	    }

    @PostMapping(value="add")
    public ResponseEntity<ResponseModel> addProfessor(@RequestBody Professor professor) throws IOException {
    	Optional<Professor> prof = Optional.ofNullable(professorRepo.findByProfessorNo(professor.getProfessorNo()));
    	if(prof.isPresent()) {
    		return ResponseEntity.ok().body(new ResponseModel(0, "professor code already exist", null, null));
    	}
		
    	String hashedPassword = bcrypt.encode(professor.getProfessorNo());
    	professor.setPassword(hashedPassword);
    	professorRepo.save(professor);

        return ResponseEntity.ok().body(new ResponseModel(1, "professor added successfully", null, professor));
    }
    
  
    																						
    @PostMapping(value = "login") 
	public ResponseEntity<ResponseModel> login(@RequestBody Admin model) throws IOException{
		return authService.loginProfessor(model);
	}
 
    @GetMapping("{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id){
    	Professor professor = professorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(professor);
    }
    
    @PatchMapping(value="/update/{id}")
	private ResponseEntity<ResponseModel> updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
		Optional<Professor> prof = professorRepo.findById(id);
		if(prof.isPresent()) {
			professorRepo.save(professor);
			return ResponseEntity.ok().body(new ResponseModel(1, "professor updated successfully", "", professor));
		}
		return ResponseEntity.ok().body(new ResponseModel(0, "An unexpected error occurred", "", null));
	}
    
    @DeleteMapping("{id}")
    public ResponseEntity<ResponseModel> deleteProfessor(@PathVariable Long id){
    	Optional<Professor> professor = professorRepo.findById(id);
    	if(professor.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(0, "professor does not exist", null, null));
		}
    	
		professorRepo.deleteById(professor.get().getProfessor_id());
		
		return ResponseEntity.ok().body(new ResponseModel(1, "successfully deleted", null, null));

    }
    
    @GetMapping(value="attendance")
    public ResponseEntity<ResponseModel> getstudentInSubjectByStudentID(@RequestParam Long subID,@RequestParam Long profID, @RequestParam Long studID){
    	List<Object> get =attendanceRepo.getstudentInSubjectByStudentID(subID, profID,studID);
    	return checker(get);
    }
    
    
    @GetMapping(value="grades")
    public ResponseEntity<ResponseModel> getAllStudentsEnrolledSubject(@RequestParam Long subID,@RequestParam Long profID, @RequestParam Long studID){
    	List<Object> get = attendanceRepo.getstudentInSubjectByStudentID(subID, profID,studID);
    	return checker(get);
    }
    
    @GetMapping(value="studentlist")
    public ResponseEntity<ResponseModel> studentList(@RequestParam Long subID,@RequestParam Long profID){ 	
    	List<Object> get = attendanceRepo.studentListbySubject(subID, profID);
    	return checker(get);	
    }
    
    
    @GetMapping(value="getSubjectByProfessor")
    public ResponseEntity<ResponseModel> getSubjectByProfessor(@RequestParam Long id){
    	List<Object> get = attendanceRepo.getSubjectByProfessor(id);
    	return checker(get);
    }
    
    
    @PostMapping(value="/setgradesto/{studentID}/subject/{subjectID}/prof/{profID}")
    public ResponseEntity<ResponseModel> setGrades( @PathVariable Long studentID, @PathVariable Long subjectID,@PathVariable Long profID, @RequestBody Grades model) {
    	Subject subject = subjectRepo.findById(subjectID).get();
    	Student student = studentRepo.findById(subjectID).get();
    	Professor prof = professorRepo.findById(profID).get();
    	model.setSubject(subject);
    	model.setStudent(student);
    	model.setProf(prof);
    	model.setFinalGrade(model.getPrelimGrade(), model.getMidtermGrade());
    	model.setStatus(model.getPrelimGrade(), model.getMidtermGrade());
    	Grades save = gradesRepo.save(model);
    	return ResponseEntity.ok().body(new ResponseModel(1, "Recorded successfully", null, save));
    }
    
    @PostMapping(value="attendancesheet")
    public ResponseEntity<ResponseModel> attendanceChecking( @RequestBody Attendance model) {
    	Attendance save = attendanceRepo.save(model);
    	return ResponseEntity.ok().body(new ResponseModel(1, "Recorded successfully", null, save));
    }
    @GetMapping(value = "details/{id}")
    public ResponseEntity<ResponseModel> details(@PathVariable Long id) {
    	Optional<Professor> prof = professorRepo.findById(id);
    	if(prof.isEmpty()) {
    		return ResponseEntity.ok().body(new ResponseModel(0, "professor does not exist", "", null));
    	}
    	return ResponseEntity.ok().body(new ResponseModel(1, "professor details", "", prof.get()));
    }
}
