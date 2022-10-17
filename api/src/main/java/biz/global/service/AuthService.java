package biz.global.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import biz.global.Table.Tables;
import biz.global.Table.tables.records.AdminRecord;
import biz.global.Table.tables.records.ProfessorRecord;
import biz.global.Table.tables.records.StudentRecord;
import biz.global.Table.tables.records.StudentSubjectRecord;
import biz.global.model.Admin;
import biz.global.model.AdminResponse;
import biz.global.model.Course;
import biz.global.model.Department;
import biz.global.model.Professor;
import biz.global.model.Program;
import biz.global.model.ResponseModel;
import biz.global.model.Student;
import biz.global.model.Subject;
import biz.global.util.JWTUtility;

@Service
public class AuthService {
	
	@Autowired
	private DSLContext context;
	
	@Autowired
	private JWTUtility jwtUtility;
	
	Admin adminModel = new Admin();
	Student studentModel = new Student();
	Professor professorModel = new Professor();
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	
	AdminResponse adminResponse = new AdminResponse();
	
	public AdminResponse saveAdminData(Admin model) throws IOException {
		if(findByUserName(model.getUsername())) {
			return new AdminResponse(0, "", "Username already exist!");
		}
		model.setPassword(bcrypt.encode(model.getPassword()));
		context.insertInto(Tables.ADMIN, Tables.ADMIN.FIRST_NAME, Tables.ADMIN.LAST_NAME, Tables.ADMIN.PASSWORD, Tables.ADMIN.TYPE, Tables.ADMIN.USERNAME)
		.values(model.getFirstName(), model.getLastName(), model.getPassword(), model.getType(), model.getUsername())
		.execute();
		model.setPassword("");
		
		return new AdminResponse(1, jwtUtility.generateToken(model.getUsername()), "Registered Successfully", model);
	}
	
	public  Boolean findByUserName(String username) throws IOException{
		AdminRecord result = context.fetchOne(Tables.ADMIN, Tables.ADMIN.USERNAME.eq(username));
		Optional<AdminRecord> data = Optional.ofNullable(result);
		if(data.isPresent()) {
			
			adminModel =	new Admin(result.getAdminId(), result.getFirstName(), result.getLastName(), result.getUsername(), result.getType(), result.getPassword());
		}
		
		return data.isPresent();
	}
	
	public AdminResponse login(Admin model) throws IOException {
		
		if(findByUserName(model.getUsername()) && bcrypt.matches(model.getPassword(), adminModel.getPassword())) {
			model.setPassword("");
			return new AdminResponse(1, jwtUtility.generateToken(model.getUsername()), "", adminModel);
			//return ResponseEntity.ok().body(new AdminResponse(1, jwtUtility.generateToken(model), "", adminModel));
		}
		return new AdminResponse(0, "", "Invalid username or password");
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AdminResponse(0, "", "Invalid username or password"));
	}
	
	
	
	
	
	public  Boolean findByStudentno(String username) throws IOException{
		StudentRecord result = context.fetchOne(Tables.STUDENT, Tables.STUDENT.LAST_NAME.eq(username));
//		Result<StudentSubjectRecord> resultstusub = context.fetch(Tables.STUDENT_SUBJECT, Tables.STUDENT_SUBJECT.STUDENT_ID.eq(result.getStudentId()));
		Optional<StudentRecord> data = Optional.ofNullable(result);
		if(data.isPresent()) {
			
			studentModel =	new Student(
					result.getStudentId(), 
					result.getPassword(),
					result.getStudentNo(), 
					result.getFirstName(),
					result.getMiddleName(),
					result.getLastName(),
					result.getBirthDate(), 
					result.getStatus(),
					result.getSem(),
					result.getAcademicYear(), 
					result.getAddress(), 
					result.getMobileNumber(), 
					result.getEmergencyContactPerson(), 
					result.getEmergencyContactNumber(), 
					result.getActiveDeactive(),
					result.getDataModified(), 
					result.getType()
					);
			return data.isPresent();
		}else if(data.isEmpty()) {
			data.isEmpty();
		}
		return data.isPresent();
		
		
	}
	
	
	public ResponseEntity<ResponseModel> loginStudent(Admin model) throws IOException {
		
		if(findByStudentno(model.getUsername()) && bcrypt.matches(model.getPassword(), studentModel.getPassword()) && studentModel.getActive_deactive()) {
			model.setPassword("");
			ResponseModel responseModel = new ResponseModel(1, "Login Successfully!",jwtUtility.generateToken(model.getUsername()),  studentModel);
			return ResponseEntity.ok().body(responseModel);
		}else if(!findByStudentno(model.getUsername())) {
    		return ResponseEntity.ok().body(new ResponseModel(0, "Cannot find Username", "", null));
    	}else if(!studentModel.getActive_deactive()) {
    		return ResponseEntity.ok().body(new ResponseModel(0, "Your account has been deactivated", "", null));
    	}
		return ResponseEntity.ok().body(new ResponseModel(0, "Username and Password is invalid", "", null));
	}
	
	
	public  Boolean findByProfessorno(String username) throws IOException{
		ProfessorRecord result = context.fetchOne(Tables.PROFESSOR, Tables.PROFESSOR.PROFESSOR_NO.eq(username));
		Optional<ProfessorRecord> data = Optional.ofNullable(result);
		if(data.isPresent()) {
			
			professorModel =	new Professor(
					result.getProfessorId(),
					result.getProfessorNo(),
					result.getFirstName(),
					result.getLastName(),
					result.getWork(),
					result.getGender(),
					result.getStatus(),
					result.getBirthdate(),
					result.getPassword(),
					result.getActiveDeactive(),
					result.getType());
			return data.isPresent();
		}else if(data.isEmpty()) {
			data.isEmpty();
		}
		return data.isPresent();
		
		
	}
	
	
	public ResponseEntity<ResponseModel> loginProfessor(Admin model) throws IOException {
		
		if(findByProfessorno(model.getUsername()) && bcrypt.matches(model.getPassword(), professorModel.getPassword()) && professorModel.getActiveDeactive()) {
			model.setPassword("");
			ResponseModel responseModel = new ResponseModel(1, "Login Successfully!",jwtUtility.generateToken(model.getUsername()),  professorModel);
			return ResponseEntity.ok().body(responseModel);
		}else if(!findByStudentno(model.getUsername())) {
    		return ResponseEntity.ok().body(new ResponseModel(0, "Cannot find Username", "", null));
    	}else if(!studentModel.getActive_deactive()) {
    		return ResponseEntity.ok().body(new ResponseModel(0, "Your account has been deactivated", "", null));
    	}
		return ResponseEntity.ok().body(new ResponseModel(0, "Username and Password is invalid", "", null));
	}
	
}
