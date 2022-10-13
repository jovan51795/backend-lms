package biz.global.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import biz.global.model.Professor;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor, Long> {
	Professor findByProfessorNo(String professorNo);
	
	
}
