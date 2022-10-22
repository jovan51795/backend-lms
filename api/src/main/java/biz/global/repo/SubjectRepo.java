package biz.global.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import biz.global.model.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {
	
	@Query( nativeQuery = true ,value = "select *from subject where subject_grade is null and professor_id is null and load_id is null and student_subject is null;")
	List<Subject> getAllSubject();
	
	Subject findBySubjectCode(String subjectCode);
	
	@Query( nativeQuery=true, value= "SELECT * FROM subject WHERE course_fk=?1")
	List<Object> getAllSubjectbyCourse(Long id);
}
