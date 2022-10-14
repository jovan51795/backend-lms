package biz.global.dto;

import java.time.LocalDateTime;

public class GradesDto {

	private Long grade_id;

	 private String session_id;
	 
	 private String grade;
	 
	 private String comment;
	 
	 private LocalDateTime date_modified = LocalDateTime.now();
	 
	 private String remarks;
	 
	 private String status;
	 
	 private SubjectDto subject;
	 
	public SubjectDto getSubject() {
		return subject;
	}
	public void setSubject(SubjectDto subject) {
		this.subject = subject;
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
}
