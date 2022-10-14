package biz.global.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import biz.global.util.Generator;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long professor_id;
	
	private String professorNo;

	private String professorName;
	
	private String work;
	
	private String gender;
	
	private String status;
	
	private String birthdate;
	
	private String password;
	
	private Boolean activeDeactive;
	
	@OneToMany(targetEntity = Grades.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "encode", referencedColumnName = "professor_id" )
	private List<Grades> grades;
	
	@OneToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "evaluate", referencedColumnName = "professor_id" )
	private List<Student> student;
	
	
	@OneToMany(targetEntity = ProfessorLoad.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_id", referencedColumnName = "professor_id" )
	private List<ProfessorLoad> professorLoad;
	
	@OneToMany(targetEntity = SubjectDetailHistory.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_id", referencedColumnName = "professor_id" )
	private List<SubjectDetailHistory> subjectDetailHistory;
	
	 @JsonIgnore
	  @OneToMany(mappedBy = "professor")
	  private List<Subject> subjects;
	 
	
	public Long getProfessor_id() {
		return professor_id;
	}

	public String getProfessorNo() {
		return professorNo;
	}

	public void setProfessorNo(Long professor_id) {
		this.professorNo = "SUBJ-"  +  String.format("%03d",professor_id);;
	}

	

	public void setProfessorNo(String professorNo) {
		this.professorNo = professorNo;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public void setProfessor_id(Long professor_id) {
		this.professor_id = professor_id;
	}


	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
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

	public Boolean getActiveDeactive() {
		return activeDeactive;
	}

	public void setActiveDeactive(Boolean activeDeactive) {
		this.activeDeactive = activeDeactive;
	}

	public List<ProfessorLoad> getProfessorLoad() {
		return professorLoad;
	}

	public void setProfessorLoad(List<ProfessorLoad> professorLoad) {
		this.professorLoad = professorLoad;
	}

	public List<SubjectDetailHistory> getSubjectDetailHistory() {
		return subjectDetailHistory;
	}

	public void setSubjectDetailHistory(List<SubjectDetailHistory> subjectDetailHistory) {
		this.subjectDetailHistory = subjectDetailHistory;
	}

	public List<Grades> getGrades() {
		return grades;
	}

	public void setGrades(List<Grades> grades) {
		this.grades = grades;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	
}
