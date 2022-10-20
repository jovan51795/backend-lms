package biz.global.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Grades {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long grade_id;

	 private String session_id;
	 
	 private Double prelimGrade;
	 
	 private Double midtermGrade;
	 
	 private Double finalGrade;
	 
	 private LocalDateTime date_modified = LocalDateTime.now();
	 
	 private String comment;
	 
	 private String remarks;
	 
	 private String status;
	 
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="student_id", referencedColumnName = "student_id")
	 private Student student;
	 
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="subject_id", referencedColumnName = "subject_id")
	 private Subject subject;
	 
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="professor_id", referencedColumnName = "professor_id")
	 private Professor prof;
	 
	 
	 
	 
	 
	
	public Double getPrelimGrade() {
		return prelimGrade;
	}
	public void setPrelimGrade(Double prelimGrade) {
		this.prelimGrade = prelimGrade;
	}
	public Double getMidtermGrade() {
		return midtermGrade;
	}
	public void setMidtermGrade(Double midtermGrade) {
		this.midtermGrade = midtermGrade;
	}
	public Double getFinalGrade() {
		return finalGrade;
	}
	public void setFinalGrade(Double finalGrade) {
		this.finalGrade = finalGrade;
	}
	public void setFinalGrade(Double prelimGrade,Double midtermGrade) {
		this.finalGrade  = (prelimGrade+midtermGrade)/2;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Professor getProf() {
		return prof;
	}
	public void setProf(Professor prof) {
		this.prof = prof;
	}
	public Long getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(Long grade_id) {
		this.grade_id = grade_id;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDateTime getDate_modified() {
		return date_modified;
	}
	public void setDate_modified(LocalDateTime date_modified) {
		this.date_modified = date_modified;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(Double prelimGrade,Double midtermGrade) {
		Double compute = (prelimGrade+midtermGrade)/2;
		if(compute<=3.0) {
			this.status = "Pass";
		}else if(compute > 3.0 && compute <= 3.5){
		    this.status = "Conditional";
		}
		else {
			this.status = "Fail";
		}
	}

	 

}
