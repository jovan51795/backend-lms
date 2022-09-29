package biz.global.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@ Entity
public class Subject {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long subject_id;
	 @NotBlank(message="Subject code must not be empty")
	private String subject_code;
	 @NotBlank(message="Subject title must not be empty")
	private String subject_title;
	 @NotBlank(message="Units must not be empty")
	private Integer units;
	 @NotBlank(message="Subject title must not be empty")
	private String prerequisites;
    private Boolean active_deactive;
//	 @NotBlank(message="Subject must not be empty")
//	 @OneToMany(mappedBy="student")
//	private Grades grades;
	 
	 
	
}
