package biz.global.model;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long professor_id;
	
	private String professorNo;

	private String firstName;
	
	private String lastName;
	
	private String work;
	
	private String gender;
	
	private String status;
	
	private String birthdate;
	
	private String password;
	
	private Boolean activeDeactive = true;
	
	private String type= "faculty";
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@JsonIgnore
	@OneToMany(targetEntity = Grades.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "encode", referencedColumnName = "professor_id" )
	private List<Grades> grades;
	
	
	@OneToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "evaluate", referencedColumnName = "professor_id" )
	private List<Student> student;
	
	@JsonIgnore
	@OneToMany(targetEntity = ProfessorLoad.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_id", referencedColumnName = "professor_id" )
	private List<ProfessorLoad> professorLoad;
	
	@JsonIgnore
	@OneToMany(targetEntity = SubjectDetailHistory.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_id", referencedColumnName = "professor_id" )
	private List<SubjectDetailHistory> subjectDetailHistory;
	
	 @JsonIgnore
	  @OneToMany(mappedBy = "professor")
	  private List<Subject> subjects;
	 
	
	public Professor() {
		super();
	}

	public Professor(
			Long professor_id, 
			String professorNo, 
			String firstName,  
			String lastName,
			String work, 
			String gender,
			String status, 
			String birthdate, 
			String password, 
			Boolean activeDeactive, 
			String type) {
		super();
		this.professor_id = professor_id;
		this.professorNo = professorNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.work = work;
		this.gender = gender;
		this.status = status;
		this.birthdate = birthdate;
		this.password = password;
		this.activeDeactive = activeDeactive;
		this.type = type;
	}

	public Long getProfessor_id() {
		return professor_id;
	}

	public String getProfessorNo() {
		return professorNo;
	}

	public void setProfessorNo(Long professor_id) {
		this.professorNo = "SUBJ-"  +  String.format("%03d",professor_id);;
	}

	

	public void setProfessorNo(String professorNo) {
		this.professorNo = professorNo;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public void setProfessor_id(Long professor_id) {
		this.professor_id = professor_id;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActiveDeactive() {
		return activeDeactive;
	}

	public void setActiveDeactive(Boolean activeDeactive) {
		this.activeDeactive = activeDeactive;
	}

	public List<ProfessorLoad> getProfessorLoad() {
		return professorLoad;
	}

	public void setProfessorLoad(List<ProfessorLoad> professorLoad) {
		this.professorLoad = professorLoad;
	}

	public List<SubjectDetailHistory> getSubjectDetailHistory() {
		return subjectDetailHistory;
	}

	public void setSubjectDetailHistory(List<SubjectDetailHistory> subjectDetailHistory) {
		this.subjectDetailHistory = subjectDetailHistory;
	}

	public List<Grades> getGrades() {
		return grades;
	}

	public void setGrades(List<Grades> grades) {
		this.grades = grades;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	
}
