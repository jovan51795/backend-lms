package biz.global.dto;

import java.util.List;

public class ProfessorDto {
	private Long professor_id;
	
	private String professorNo;

	private String professor_name;
	
	private String work;
	
	private String gender;
	
	private String status;
	
	private String birthdate;
	
	private String password;
	
	private Boolean active_deactive;
	
	private List<GradesDto> grades;
	
	private List<StudentDto> student;
	
	
	private List<ProfessorLoadDto> professorLoad;
	
	private List<SubjectDetailHistoryDto> subjectDetailHistory;
	
	
	public Long getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(Long professor_id) {
		this.professor_id = professor_id;
	}

	public String getProfessor_no() {
		return professorNo;
	}

	public void setProfessor_no(String professor_no) {
		this.professorNo = professor_no;
	}

	public String getProfessor_name() {
		return professor_name;
	}

	public void setProfessor_name(String professor_name) {
		this.professor_name = professor_name;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive_deactive() {
		return active_deactive;
	}

	public void setActive_deactive(Boolean active_deactive) {
		this.active_deactive = active_deactive;
	}

	public List<GradesDto> getGrades() {
		return grades;
	}

	public void setGrades(List<GradesDto> grades) {
		this.grades = grades;
	}

	public List<StudentDto> getStudent() {
		return student;
	}

	public void setStudent(List<StudentDto> student) {
		this.student = student;
	}

	
}
