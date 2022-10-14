package biz.global.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import biz.global.model.Professor;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor, Long> {
	
	@Query(value = "select *from professor where professor_no = ?1", nativeQuery = true)
	Professor findByProfessorNo(String professorNo);
	
	@Query(value ="select * from professor where active_deactive = true", nativeQuery = true)
	List<Professor> getAllProfessor();
}
