package biz.global.model;
import biz.global.util.Generator;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
public class Student {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long student_id;
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	 @GenericGenerator(
	            name = "student_seq",
	            strategy = "biz.global.util.Generator",
	            parameters = {
	                    @Parameter(name = Generator.INCREMENT_PARAM, value = "1"),
	                    @Parameter(name = Generator.VALUE_PREFIX_PARAMETER, value = "SN_"),
	                    @Parameter(name = Generator.NUMBER_FORMAT_PARAMETER, value = "%05d")
	            })
	private String student_no;
	 @NotBlank(message="First Name must not be empty")
	private String firstName;
	 @NotBlank(message="Middle Name must not be empty")
	private String middleName;
	 @NotBlank(message="Last Name must not be empty")
	private String lastName;
//	 @NotBlank(message="Program must not be empty")
//	 @OneToMany(mappedBy="student")
//	private Program program;
//	 @NotBlank(message="Subject must not be empty")
//	 @OneToMany(mappedBy="student")
//	private Subject subject;
//	 @ManyToOne()
//	 private Professor professor;
	 @NotBlank(message="Birthdate must not be empty")
	private String sem;
//	 @NotBlank(message="Year level must not be empty")
//	private Yearlevel yearLevel;
	 @NotBlank(message="Academic Year must not be empty")
	 private String academicYear;
//	 @NotBlank(message="Status must not be empty")
//	private Status status;
	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	public String getStudent_no() {
		return student_no;
	}
	public void setStudent_no(String student_no) {
		this.student_no = student_no;
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
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
//	public Yearlevel getYearLevel() {
//		return yearLevel;
//	}
//	public void setYearLevel(Yearlevel yearLevel) {
//		this.yearLevel = yearLevel;
//	}
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
//	public Status getStatus() {
//		return status;
//	}
//	public void setStatus(Status status) {
//		this.status = status;
//	}
	public Boolean getActive_deactive() {
		return active_deactive;
	}
	public void setActive_deactive(Boolean active_deactive) {
		this.active_deactive = active_deactive;
	}
	private Boolean active_deactive;


}
