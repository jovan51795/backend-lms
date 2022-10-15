package biz.global.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Subject  {
	
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long subject_id;
	 
	private String subjectCode;
	 
	private String subjectTitle;
	 
	private Integer units;
	 
	private String prerequisites;
	
    private Boolean activeDeactive = true;

	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="load_id", referencedColumnName = "load_id")
	private ProfessorLoad professorLoad;
    
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="professor_id", referencedColumnName = "professor_id")
	private Professor professor;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_grade")
    private Grades grades;
    
//    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH, CascadeType.ALL}, optional = true)
    @ManyToOne
    @JoinColumn(name="course_fk", nullable = true)
	private Course course;

    

    @ManyToMany(cascade =  CascadeType.ALL)
    private List<Student> student = new ArrayList<>();
    
    @OneToMany()
    private List<Attendance> attendance = new ArrayList<>();
    


	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Grades getGrades() {
		return grades;
	}
	public void setGrades(Grades grades) {
		this.grades = grades;
	}
	public Subject() {
		super();
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

	public void setSubject_code(Long subject_id) {
		this.subjectCode = "SUBJ-"  +  String.format("%03d",subject_id);
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
	public ProfessorLoad getProfessorLoad() {
		return professorLoad;
	}



	public void setProfessorLoad(ProfessorLoad professorLoad) {
		this.professorLoad = professorLoad;
	}



	public Professor getProfessor() {
		return professor;
	}



	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	 
	
}
