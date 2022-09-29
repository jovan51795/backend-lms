package biz.global.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import biz.global.util.Generator;
@Entity
public class Grades {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long grade_id;
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	 @GenericGenerator(
	            name = "grade_seq",
	            strategy = "biz.global.util.Generator",
	            parameters = {
	                    @Parameter(name = Generator.INCREMENT_PARAM, value = "1"),
	                    @Parameter(name = Generator.VALUE_PREFIX_PARAMETER, value = "SESSION_ID"),
	                    @Parameter(name = Generator.NUMBER_FORMAT_PARAMETER, value = "%05d")
	            })
	private String session_id;
	 @NotBlank(message="Grade must not be empty")
	 private String grade;
	 private String comment;
	 private LocalDateTime date_modified = LocalDateTime.now();
	 private String remarks;
	 private String status;
//	 @ManyToOne()
//	 private Professor professor;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
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
	public void setStatus(String status) {
		this.status = status;
	}
//	public Professor getProfessor() {
//		return professor;
//	}
//	public void setProfessor(Professor professor) {
//		this.professor = professor;
//	}
	 

}
