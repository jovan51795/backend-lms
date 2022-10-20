package biz.global.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ProfessorLoad {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)	
	 private Long load_id;
	 
	 private String subjectTitle;
	 
	 private String section;
	 
	 private String yearLevel;
	 
	 
	 
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="professor_id", referencedColumnName = "professor_id")
	 private Professor prof;
	 
	 
	 @ManyToOne(cascade=CascadeType.ALL)
     @JoinColumn(name="subject_id", referencedColumnName = "subject_id")
     private Subject subject;
	 

	public ProfessorLoad() {
		super();
	}






    public ProfessorLoad(String subjectTitle, String section, String yearLevel, Professor prof, Subject subject) {
        super();
        this.subjectTitle = subjectTitle;
        this.section = section;
        this.yearLevel = yearLevel;
        this.prof = prof;
        this.subject = subject;
    }






    public String getSubjectTitle() {
        return subjectTitle;
    }






    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }






    public Long getLoad_id() {
		return load_id;
	}

	public void setLoad_id(Long load_id) {
		this.load_id = load_id;
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
	 
	 
	 
	 
	 
}
