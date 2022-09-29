package biz.global.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class ProfessorLoad {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long load_id;
//	 @ManyToOne()
//	private Professor professor;
//	 @ManyToMany
//	private Program program_title;
	private String section;
	private String yearLevel;
	public Long getLoad_id() {
		return load_id;
	}
	public void setLoad_id(Long load_id) {
		this.load_id = load_id;
	}
//	public Professor getProfessor() {
//		return professor;
//	}
//	public void setProfessor(Professor professor) {
//		this.professor = professor;
//	}
//	public Program getProgram_title() {
//		return program_title;
//	}
//	public void setProgram_title(Program program_title) {
//		this.program_title = program_title;
//	}
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
