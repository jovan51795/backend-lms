package biz.global.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import biz.global.dto.StudentDto;
import biz.global.model.Admin;
import biz.global.model.ResponseModel;
import biz.global.model.Student;
import biz.global.model.Subject;
import biz.global.repo.StudentRepo;
import biz.global.util.JWTUtility;

@RestController
@RequestMapping(value = "api/student/")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	
	@Autowired
	StudentRepo studentRepo;
	
	
	
	@Autowired
	private JWTUtility jwtUtility;
	
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	
	@PostMapping(value = "add")
	public ResponseEntity<ResponseModel> register(@RequestBody Student student) throws IOException {
		Optional<Student> stu = Optional.ofNullable(studentRepo.findByStudentNo(student.getStudentNo()));
		if(!stu.isEmpty()) {
			return ResponseEntity.ok().body(new ResponseModel(0, "student number already exist", null, null));
		}
		String hashedPassword = bcrypt.encode(student.getStudentNo());
		student.setPassword(hashedPassword);
		studentRepo.save(student);

		
		return ResponseEntity.ok().body(new ResponseModel(1, "student successfully added", null, student));
	}
	
	@GetMapping("studentlist")
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}
	
	@PostMapping("student-login")
	public ResponseEntity<ResponseModel> studentLogin(@RequestBody Admin student) throws JsonProcessingException {
		Optional<Student> stu = Optional.ofNullable(studentRepo.findByLastName(student.getUsername()));
		if(stu.isPresent() && stu.get().getLastName().equals(student.getUsername()) && bcrypt.matches(student.getPassword(), stu.get().getPassword()) && stu.get().getActive_deactive()) {
			stu.get().setPassword("");
			ResponseModel responseModel = new ResponseModel(1, "logged in",jwtUtility.generateToken(student.getLastName()), stu.get() );
			return ResponseEntity.ok().body(responseModel);
		}
		else if(!stu.get().getActive_deactive()) {
			return ResponseEntity.ok().body(new ResponseModel(0, "your account has been deactivated", "", null));
		}
		ResponseModel responseModel = new ResponseModel(0, "Invalid lastname or password",null, null );
		return ResponseEntity.ok().body(responseModel);
	}
	
	
	@PatchMapping("update-student-info/{id}")
	public ResponseEntity<ResponseModel> updateStudentInfo( @PathVariable Long id,@RequestBody StudentDto student) throws IllegalArgumentException, JsonProcessingException {
		Optional<Student> stud = studentRepo.findById(id);
		if(stud.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(0, "student does not exist", null, null));
		}
		stud.get().setStudent_id(student.getStudent_id());
		stud.get().setFirstName(student.getFirstName());
		stud.get().setMiddleName(student.getMiddleName());
		stud.get().setLastName(student.getLastName());
		stud.get().setBirthDate(student.getBirthDate());
		stud.get().setAcademicYear(student.getAcademicYear());
		stud.get().setActive_deactive(student.getActive_deactive());
		stud.get().setProgram(student.getProgram());
		stud.get().setSem(student.getSem());
		stud.get().setStatus(student.getStatus());
		stud.get().setSubject(student.getSubject());
		stud.get().setAddress(student.getAddress());
		stud.get().setMobileNumber(student.getMobileNumber());
		stud.get().setEmergencyContactPerson(student.getEmergencyContactPerson());
		stud.get().setEmergencyContactNumber(student.getEmergencyContactNumber());
		studentRepo.save(stud.get());
		return ResponseEntity.ok().body(new ResponseModel(1, "updated successfully", null, student));
	}
	
	@DeleteMapping("delete-student/{id}")
	public ResponseEntity<ResponseModel> deleteStudent(@PathVariable Long id) {
		Optional<Student> student = studentRepo.findById(id);
		if(student.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(0, "student does not exist", null, null));
		}
		studentRepo.deleteById(student.get().getStudent_id());
		return ResponseEntity.ok().body(new ResponseModel(1, "successfully deleted", null, null));
	}
	
	@GetMapping("getbyid/{id}")
	private ResponseEntity<ResponseModel> getStudentById(@PathVariable Long id) {
		Optional<Student> student = studentRepo.findById(id);
		if(student.isPresent()) {
			return ResponseEntity.ok().body(new ResponseModel(1, "student exist", null, student.get()));
		}
		student.get().setPassword("");
		return ResponseEntity.ok().body(new ResponseModel(0, "student does not exist", null, null));
	}
	
	
	
	

}
