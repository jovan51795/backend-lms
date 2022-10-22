package biz.global.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class SubjectDetailHistory {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long session_id;

	private String academicYear;
	
	
	
	private String schedule;
	
	private String section;
	
	
	private String status;
	
	private String startDate;
	
	private Boolean active_deactive = true;
	
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="subject_id", referencedColumnName = "subject_id")
	 private Subject subject;
	 
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="professor_id", referencedColumnName = "professor_id")
	 private Professor prof;
	 
	 
	
	public SubjectDetailHistory() {
		
	}
	public SubjectDetailHistory(String academicYear, String schedule, String section, String status, String startDate, Subject subject, Professor prof) {
		this.academicYear = academicYear;
		
		this.schedule = schedule;
		this.section = section;
		
		this.status = status;
		this.startDate = startDate;
		this.subject = subject;
		this.prof = prof;
	}
	
	public SubjectDetailHistory(String academicYear,  String schedule, String section, Subject subject) {
        this.academicYear = academicYear;
        
        this.schedule = schedule;
        this.section = section;
        
        this.subject = subject;
       
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
	public Long getSession_id() {
		return session_id;
	}
	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}

	public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
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
