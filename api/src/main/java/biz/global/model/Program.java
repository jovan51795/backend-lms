package biz.global.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Program {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long program_id;
	 
	 private String program_code;
	 
	 private String program_title;
	 
	 private String major;
	 
	public Long getProgram_id() {
		return program_id;
	}
	
	public void setProgram_id(Long program_id) {
		this.program_id = program_id;
	}
	
	public String getProgram_code() {
		return program_code;
	}
	
	public void setProgram_code(String program_id) {
		this.program_code = "PROGRAM-"  +  String.format("%03d",program_id);
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
