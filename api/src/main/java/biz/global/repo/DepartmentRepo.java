package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biz.global.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
	
}
