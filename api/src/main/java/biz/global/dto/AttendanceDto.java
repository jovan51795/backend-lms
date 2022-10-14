package biz.global.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDto {
	
	private Long student_id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private Long subject_id;
	
	private String subject_title;
	
	private String subject_code;


	public AttendanceDto() {
		
	}


	public AttendanceDto(Object[] columns) {
		
		this.student_id = (columns[0] != null)?((BigDecimal)columns[0]).longValue():0;
		this.firstName = (String) columns[1];
		this.middleName = (String) columns[2];
		this.lastName = (String) columns[3];
		this.subject_id = (columns[4] != null)?((BigDecimal)columns[4]).longValue():4;
		this.subject_title = (String) columns[5];
		this.subject_code = (String) columns[6];
	}


	public String getSubject_code() {
		return subject_code;
	}


	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}


	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Long subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubject_title() {
		return subject_title;
	}

	public void setSubject_title(String subject_title) {
		this.subject_title = subject_title;
	}
	
	
	

}
