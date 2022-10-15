package biz.global.model;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data

public class Student  implements  Serializable{
	private static final long serialVersionUID = 1L;


	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long student_id;
	
	 private String studentNo;

	 private String firstName;
	 
	 private String middleName;
	 
	 private String lastName;
	 
	 private String password;
	 
	 private String birthDate;
	 
	 public String status;
	 
	 private String sem;

	 private String academicYear;
	 
	 private Boolean active_deactive = false;
	
	@OneToMany(targetEntity = Program.class, cascade = CascadeType.ALL)
	 @JoinColumn(referencedColumnName = "student_id", name = "student_program")
	 private List<Program> program;
	 
	 public List<Subject> getSubject() {
		return subject;
	}


	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}



	@ManyToMany(targetEntity = Subject.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name ="student_subject",
	joinColumns = @JoinColumn(name = "student_id"),
	inverseJoinColumns =  @JoinColumn(name = "subject_id")
			)
	 private List<Subject> subject = new ArrayList<>();
	 
	 @OneToMany(targetEntity = Grades.class, cascade = CascadeType.ALL)
	 @JoinColumn(name = "student_grades", referencedColumnName = "student_id" )
	 private List<Grades> grades;
	 
	 private String type = "student";
	 
	 
	 
	 public Student() {
		 super();
	 }
	
	public Student(Long student_id, String firstName, String middleName,
			String lastName, List<Program> program,
			List<Subject> subjects, String sem, String academicYear, Boolean active_deactive) {
		super();
	
		this.student_id = student_id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.program = program;
		this.subject = subjects;
		this.sem = sem;
		this.academicYear = academicYear;
		this.active_deactive = active_deactive;
	}

	 
	 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinColumn(name="department_fk", updatable = true, insertable = true)
	 private Department department;
	 
	 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinColumn(name="course_fk")
	 private Course course;
	 
	
	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public List<Grades> getGrades() {
		return grades;
	}


	public void setGrades(List<Grades> grades) {
		this.grades = grades;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getBirthDate() {
		return birthDate;
	}
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	

	public List<Program> getProgram() {
		return program;
	}
	

	public void setProgram(List<Program> program) {
		this.program = program;
	}
	
	public Student(Long student_id, String student_no, String firstName, String middleName,
			String lastName, List<Program> program,
			List<Subject> subjects, String sem, String academicYear, Boolean active_deactive) {
		super();
		this.student_id = student_id;
		this.studentNo = student_no;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.program = program;
		this.subject = subjects;
		this.sem = sem;
		this.academicYear = academicYear;
		this.active_deactive = active_deactive;
	}




	public Long getStudent_id() {
		return student_id;
	}
	
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	
	
	
	public String getStudentNo() {
		return studentNo;
	}
	
	public void setStudent_no(Long student_id) {
		this.studentNo  = "SN-" + Integer.toString(LocalDate.now().getYear()) + "-" +String.format("%04d",student_id);
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


	public String getAcademicYear() {
		return academicYear;
	}
	
	public void setAcademicYear(String academic_year) {
		this.academicYear = academic_year;
	}

	public Boolean getActive_deactive() {
		return active_deactive;
	}
	
	public void setActive_deactive(Boolean active_deactive) {
		this.active_deactive = active_deactive;
	}
	
}
