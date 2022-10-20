package biz.global.model;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data

public class Attendance implements  Serializable{
	private static final long serialVersionUID = 1L;


	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 
	 private Long attendance_id;
	
	 private LocalDate datemodified = LocalDate.now();
	 
	 
	 
	 @ManyToOne(cascade=CascadeType.ALL)
     @JoinColumn(name="student_id", referencedColumnName = "student_id")
     private Student student;
     
     @ManyToOne(cascade=CascadeType.ALL)
     @JoinColumn(name="subject_id", referencedColumnName = "subject_id")
     private Subject subject;
     
     @ManyToOne(cascade=CascadeType.ALL)
     @JoinColumn(name="professor_id", referencedColumnName = "professor_id")
     private Professor prof;
	 
	 private Boolean isPresent;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Long getAttendance_id() {
		return attendance_id;
	}

	public void setAttendance_id(Long attendance_id) {
		this.attendance_id = attendance_id;
	}



	public LocalDate getDatemodified() {
		return datemodified;
	}

	public void setDatemodified(LocalDate datemodified) {
		this.datemodified = datemodified;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Boolean getIsPresent() {
		return isPresent;
	}

	public void setIsPresent(Boolean isPresent) {
		this.isPresent = isPresent;
	}

    public Professor getProf() {
        return prof;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }
	 
	 
	 


		

	
	 


	
}
