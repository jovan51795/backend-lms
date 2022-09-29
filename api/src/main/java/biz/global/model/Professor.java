package biz.global.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import biz.global.util.Generator;

@Entity
public class Professor {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long professor_id;
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professor_seq")
	 @GenericGenerator(
	            name = "professor_seq",
	            strategy = "biz.global.util.Generator",
	            parameters = {
	                    @Parameter(name = Generator.INCREMENT_PARAM, value = "1"),
	                    @Parameter(name = Generator.VALUE_PREFIX_PARAMETER, value = "PROF_"),
	                    @Parameter(name = Generator.NUMBER_FORMAT_PARAMETER, value = "%05d")
	            })
	 private String professor_no;
	 @NotBlank(message="Professor name must not be blank")
	private String professor_name;
	 @NotBlank(message="Work must not be blank")
	private String work;
	 @NotBlank(message="Gender must not be blank")
	private String gender;
	 @NotBlank(message="Status must not be empty")
	private String status;
	 @NotBlank(message="Birthdate must not be empty")
	private Date birthdate;
	private String password;
	private Boolean active_deactive;
//	 @OneToMany(mappedBy="professor")
//	private Grades grade;
//	 @OneToMany(mappedBy="professor")
//	private Student student;
//	 @OneToMany(mappedBy="professor")
//	private ProfessorLoad professor_load;
//	 @OneToMany(mappedBy="professor")
//	private SubjectDetailHistory subjectDetailHistory;
	 public Long getProfessor_id() {
		return professor_id;
	}
	public void setProfessor_id(Long professor_id) {
		this.professor_id = professor_id;
	}
	public String getProfessor_no() {
		return professor_no;
	}
	public void setProfessor_no(String professor_no) {
		this.professor_no = professor_no;
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
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
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
//	public Grades getGrade() {
//		return grade;
//	}
//	public void setGrade(Grades grade) {
//		this.grade = grade;
//	}
//	public Student getStudent() {
//		return student;
//	}
//	public void setStudent(Student student) {
//		this.student = student;
//	}
//	public ProfessorLoad getProfessor_load() {
//		return professor_load;
//	}
//	public void setProfessor_load(ProfessorLoad professor_load) {
//		this.professor_load = professor_load;
//	}
//	public SubjectDetailHistory getSubjectDetailHistory() {
//		return subjectDetailHistory;
//	}
//	public void setSubjectDetailHistory(SubjectDetailHistory subjectDetailHistory) {
//		this.subjectDetailHistory = subjectDetailHistory;
//	}
	
	
	 
}
