package biz.global.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import biz.global.model.Grades;
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

}
