package biz.global.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import biz.global.model.ResponseModel;
import biz.global.model.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {
	
	@Query( nativeQuery = true ,value = "select *from subject where subject_grade is null and professor_id is null and load_id is null and student_subject is null;")
	List<Subject> getAllSubject();
	
	Subject findBySubjectCode(String subjectCode);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true ,value = "delete from student_subject where subject_id = :subject_id")
	public void deleteStudentSubject(@Param("subject_id") Long subject_id);
}
