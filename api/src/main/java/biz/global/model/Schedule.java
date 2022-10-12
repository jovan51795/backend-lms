package biz.global.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long schedule_id;
	
	private String schedule_code;
	


	private String schedule_subject;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id",referencedColumnName = "student_id")
	private Student student;
	
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="professor_id", referencedColumnName = "professor_id")
	private Professor professor;

	public Long getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(Long schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getSchedule_subject() {
		return schedule_subject;
	}

	public void setSchedule_subject(String schedule_subject) {
		this.schedule_subject = schedule_subject;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
    
    
	public String getSchedule_code() {
		return schedule_code;
	}

	public void setSchedule_code(String schedule_code) {
		this.schedule_code = schedule_code;
	}
    
}
