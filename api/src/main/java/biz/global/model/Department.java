package biz.global.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	
	private String departmentName;
	
	private String logo;
	private String altlogo;
	private String link;
	
	@OneToMany(targetEntity = Course.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "department", referencedColumnName = "departmentId", nullable = true , updatable = true)
	@ElementCollection
	private List<Course> course = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy="department", orphanRemoval = true)
	private List<Student> student = new ArrayList<>();

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAltlogo() {
        return altlogo;
    }

    public void setAltlogo(String altlogo) {
        this.altlogo = altlogo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
	public int hashCode() {
		return Objects.hash(course, departmentId, departmentName, student);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Department)) {
			return false;
		}
		Department other = (Department) obj;
		return Objects.equals(course, other.course) && Objects.equals(departmentId, other.departmentId)
				&& Objects.equals(departmentName, other.departmentName) && Objects.equals(student, other.student);
	}
	
	
	

}
