package biz.global.dto;


public class ProfessorLoadDto {
	 private Long load_id;
	 
	 private String courseTitle;
	 
	 private String section;
	 
	 private String yearLevel;

	public Long getLoad_id() {
		return load_id;
	}

	public void setLoad_id(Long load_id) {
		this.load_id = load_id;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getYearLevel() {
		return yearLevel;
	}

	public void setYearLevel(String yearLevel) {
		this.yearLevel = yearLevel;
	}
}
