package biz.global.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import biz.global.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
	
	Student findByStudentNo(String student_no);
	
	Student  findByLastName(String lastName);
	
	
}
