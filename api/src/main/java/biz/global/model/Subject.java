package biz.global.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subject_id;

	private String subjectCode;

	private String subjectTitle;

	private Integer units;

	private String prerequisites;

	private Boolean activeDeactive = true;
	
	private String sem;
	
    private String yearLevel;

	@OneToMany(targetEntity = Grades.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "student_grades", referencedColumnName = "subject_id")
	private List<Grades> grades;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "load_id", referencedColumnName = "load_id")
	private ProfessorLoad professorLoad;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_id", referencedColumnName = "professor_id")
	private Professor professor;


	@ManyToOne
	@JoinColumn(name = "course_fk", nullable = true)
	private Course course;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Student> student = new ArrayList<>();

	@OneToMany()
	private List<Attendance> attendance = new ArrayList<>();
	
	@OneToMany()
    private List<SubjectDetailHistory> subject_detail_history = new ArrayList<>();
	
	private Long department_id;
	
	private String departmentName;

	/**
	 * @return the department_id
	 */
	public Long getDepartment_id() {
		return department_id;
	}

	/**
	 * @param department_id the department_id to set
	 */
	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
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

	public Subject() {
		super();
	}

	public List<SubjectDetailHistory> getSubject_detail_history() {
        return subject_detail_history;
    }

    public void setSubject_detail_history(List<SubjectDetailHistory> subject_detail_history) {
        this.subject_detail_history = subject_detail_history;
    }

    public List<Grades> getGrades() {
		return grades;
	}

	public void setGrades(List<Grades> grades) {
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

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
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
