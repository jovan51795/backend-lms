package biz.global.dto;

import java.util.ArrayList;
import java.util.List;

import biz.global.model.Course;
import biz.global.model.Department;
import biz.global.model.Grades;
import biz.global.model.Program;
import biz.global.model.Subject;

public class StudentDto{

	 private Long student_id;

	 private String studentNo;

	 private String firstName;
	 
	 private String middleName;
	 
	 private String lastName;
	 
	 private String password;
	 
	 private String birthDate;
	 
	 public String status;
	 
	 private String sem;

	 private String academicYear;
	 
	 private Boolean active_deactive=true;
	 
	 private String address;
	 
	 private String mobileNumber;
	 
	 private String emergencyContactPerson;
	 
	 private String emergencyContactNumber;
	
	
	 private List<Program> program;
	 
	 public List<Subject> getSubject() {
		return subject;
	}


	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	 private List<Subject> subject = new ArrayList<>();
	 
	 private String type = "student";
	 
	 private Department department;
	 
	 private Course course;

	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getBirthDate() {
		return birthDate;
	}
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	

	public List<Program> getProgram() {
		return program;
	}
	

	public void setProgram(List<Program> program) {
		this.program = program;
	}

	public Long getStudent_id() {
		return student_id;
	}
	
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	
	
	
	public String getStudentNo() {
		return studentNo;
	}


	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}


	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSem() {
		return sem;
	}
	
	public void setSem(String sem) {
		this.sem = sem;
	}


	public String getAcademicYear() {
		return academicYear;
	}
	
	public void setAcademicYear(String academic_year) {
		this.academicYear = academic_year;
	}

	public Boolean getActive_deactive() {
		return active_deactive;
	}
	
	public void setActive_deactive(Boolean active_deactive) {
		this.active_deactive = active_deactive;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmergencyContactPerson() {
		return emergencyContactPerson;
	}


	public void setEmergencyContactPerson(String emergencyContactPerson) {
		this.emergencyContactPerson = emergencyContactPerson;
	}


	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}


	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}
	
	
}
