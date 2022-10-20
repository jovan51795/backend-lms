package biz.global.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import biz.global.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
	
	Student findByStudentNo(String student_no);
	
	Student  findByLastName(String lastName);
	
	
	@Query(nativeQuery = true, value="SELECT DISTINCT grades.subject_title, grades.subject_code,grades.units, grades.final_grade, grades.comment, grades.status, grades.remarks FROM student AS stu \r\n"
			+ "JOIN (select grade.final_grade, grade.comment, grade.status, grade.remarks, grade.student_id, sub.subject_code, sub.subject_title, sub.subject_id,sub.units from grades AS grade \r\n"
			+ " JOIN (SELECT sub.subject_code, sub.subject_title,sub.units, sub.subject_id FROM subject AS sub) AS sub \r\n"
			+ " ON grade.subject_id = sub.subject_id where student_id = ?1) AS grades \r\n"
			+ " ON grades.student_id = stu.student_id")
	List<Object> getGradesofStudent(Long id);
	
	
	
	@Query(nativeQuery = true, value="SELECT stu.student_id,sub.schedule,sub.start_date, sub.subject_id, sub.subject_title, sub.subject_code from student AS stu, student_subject AS stusub\r\n"
	        + "JOIN (SELECT DISTINCT subdetail.schedule,subdetail.start_date, subdetail.professor_id, subdetail.subject_id, sub.subject_code, sub.subject_title  from subject_detail_history AS subdetail\r\n"
	        + "JOIN (SELECT sub.subject_id, sub.subject_code, sub.subject_title FROM subject as sub) AS sub ON sub.subject_id = subdetail.subject_id) AS sub ON sub.subject_id = stusub.subject_id\r\n"
	        + "WHERE stu.student_id = ?1 AND stusub.student_id = stu.student_id")
	List<Object> getSchedule(Long id);
	
	
	
}
