package biz.global.dto;

import java.util.ArrayList;
import java.util.List;

public class SubjectDto  {
	
	
	private Long subject_id;
	 
	private String subjectCode;
	 
	private String subjectTitle;
	 
	private Integer units;
	 
	private String prerequisites;
	
    private Boolean activeDeactive = true;

	private ProfessorLoadDto professorLoad;
    
    
	private ProfessorDto professor;
    
    
    private GradesDto grades;
    

	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public GradesDto getGrades() {
		return grades;
	}
	public void setGrades(GradesDto grades) {
		this.grades = grades;
	}
	
	public Long getSubject_id() {
		return subject_id;
	}


	public void setSubject_id(Long subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public Integer getUnits() {
		return units;
	}


	public void setUnits(Integer units) {
		this.units = units;
	}


	public String getPrerequisites() {
		return prerequisites;
	}


	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}


	public Boolean getActiveDeactive() {
		return activeDeactive;
	}
	public void setActiveDeactive(Boolean activeDeactive) {
		this.activeDeactive = activeDeactive;
	}
	public ProfessorLoadDto getProfessorLoad() {
		return professorLoad;
	}



	public void setProfessorLoad(ProfessorLoadDto professorLoad) {
		this.professorLoad = professorLoad;
	}



	public ProfessorDto getProfessor() {
		return professor;
	}



	public void setProfessor(ProfessorDto professor) {
		this.professor = professor;
	}
	 
	
}
