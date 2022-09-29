package biz.global.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Program {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long program_id;
	 @NotBlank(message="Program code must not be empty")
	private String program_code;
	 @NotBlank(message="Program Title must not be empty")
	private String program_title;
	 @NotBlank(message="Major must not be empty")
	private String major;
//	 @ManyToMany
//	private ProfessorLoad professorLoad;
//	public ProfessorLoad getProfessorLoad() {
//		return professorLoad;
//	}
//	public void setProfessorLoad(ProfessorLoad professorLoad) {
//		this.professorLoad = professorLoad;
//	}
	public Long getProgram_id() {
		return program_id;
	}
	public void setProgram_id(Long program_id) {
		this.program_id = program_id;
	}
	public String getProgram_code() {
		return program_code;
	}
	public void setProgram_code(String program_code) {
		this.program_code = program_code;
	}
	public String getProgram_title() {
		return program_title;
	}
	public void setProgram_title(String program_title) {
		this.program_title = program_title;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

}
