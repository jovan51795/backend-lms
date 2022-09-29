package biz.global.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
@Entity
public class SubjectDetailHistory {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long session_id;
//	 @ManyToOne
//	private Professor professor;
//	 @ManyToOne
//	private Subject subject;
	 @NotBlank(message="Academic Year must not be empty")
	private String academicYear;
	private String sem;
	private String schedule;
	private String section;
	private String yearLevel;
	private String status;
	private Boolean active_deactive;
	public Long getSession_id() {
		return session_id;
	}
	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}
//	public Professor getProfessor() {
//		return professor;
//	}
//	public void setProfessor(Professor professor) {
//		this.professor = professor;
//	}
//	public Subject getSubject() {
//		return subject;
//	}
//	public void setSubject(Subject subject) {
//		this.subject = subject;
//	}
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getYearLevel() {
		return yearLevel;
	}
	public void setYearLevel(String yearLevel) {
		this.yearLevel = yearLevel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Boolean getActive_deactive() {
		return active_deactive;
	}
	public void setActive_deactive(Boolean active_deactive) {
		this.active_deactive = active_deactive;
	}
	 

}
