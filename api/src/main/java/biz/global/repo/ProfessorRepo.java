package biz.global.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import biz.global.model.Professor;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor, Long> {
	Professor findByProfessorNo(String professorNo);

	@Query(nativeQuery = true, value="SELECT * FROM profesor WHERE professor_no LIKE :profNumber%")
	Professor findProfessor(String profNumber);
	
	@Query(nativeQuery = true, value="SELECT COUNT(grade.status) FROM grades AS grade where professor_id = ?1 AND grade.status ='Pass'")
	String getPass(Long id);
	
	@Query(nativeQuery = true, value="SELECT COUNT(grade.status) FROM grades AS grade where professor_id = ?1 AND grade.status ='Fail'")
	String getFail(Long id);
	
	@Query(nativeQuery = true, value="SELECT COUNT(grade.status) FROM grades AS grade where professor_id = ?1 AND grade.status ='Conditional'")
	String getConditional(Long id);
	
	@Query(nativeQuery = true, value="SELECT DISTINCT prof.professor_id, subdetail.schedule,subdetail.start_date, subdetail.subject_id, subdetail.subject_code, subdetail.subject_title\r\n"
	        + "FROM  professor AS prof JOIN (SELECT DISTINCT subdetail.schedule,subdetail.start_date, subdetail.professor_id, subdetail.subject_id, sub.subject_code, sub.subject_title  from subject_detail_history AS subdetail\r\n"
	        + "JOIN (SELECT sub.subject_id, sub.subject_code, sub.subject_title FROM subject as sub) AS sub ON sub.subject_id = subdetail.subject_id\r\n"
	        + "      WHERE subdetail.professor_id = ?1) as subdetail ON subdetail.professor_id = prof.professor_id\r\n")
	List<Object> listOfSchedule(Long id);
}
