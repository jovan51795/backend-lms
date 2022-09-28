package biz.global.model;
import biz.global.util.Generator;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Student {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long student_id;
	 @Id
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
	 @NotBlank(message="Program must not be empty")
	 @OneToMany(mappedBy="student")
	private Program program;
	 @NotBlank(message="Birthdate must not be empty")
	private Date birthdate;
	 @NotBlank(message="Semester must not be empty")
	private String sem;
	 @NotBlank(message="Year level must not be empty")
	private Yearlevel yearLevel;
	 @NotBlank(message="Year level must not be empty")
	 private String academicYear;
	 @NotBlank(message="Year level must not be empty")
	private Status status;
	 @NotBlank(message="Year level must not be empty")
	private Boolean active_deactive;
	 @NotBlank( message="Course must not be empty")
	private String course;


}
