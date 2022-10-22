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
	
	
	@Query(nativeQuery = true, value="  SELECT DISTINCT grades.subject_title, grades.subject_code,grades.units, grades.final_grade, grades.comment, grades.status, grades.remarks, grades.academic_year, grades.sem FROM student AS stu\r\n"
	        + "            JOIN (SELECT * from grades AS grade\r\n"
	        + "            JOIN (SELECT sub.subject_code, sub.subject_title,sub.units, sub.subject_id, history.academic_year, history.sem FROM subject AS sub\r\n"
	        + "            JOIN (SELECT history.academic_year, history.sem, history.subject_id from subject_detail_history AS history) as history ON history.subject_id = sub.subject_id) AS sub \r\n"
	        + "            ON grade.subject_id = sub.subject_id where student_id = ?1) AS grades \r\n"
	        + "            ON grades.student_id = stu.student_id")
	List<Object> getGradesofStudent(Long id);
	
	
	
	@Query(nativeQuery = true, value="SELECT stu.student_id,sub.schedule,sub.start_date, sub.subject_id, sub.subject_title, sub.subject_code from student AS stu, student_subject AS stusub\r\n"
	        + "JOIN (SELECT DISTINCT subdetail.schedule,subdetail.start_date, subdetail.professor_id, subdetail.subject_id, sub.subject_code, sub.subject_title  from subject_detail_history AS subdetail\r\n"
	        + "JOIN (SELECT sub.subject_id, sub.subject_code, sub.subject_title FROM subject as sub) AS sub ON sub.subject_id = subdetail.subject_id) AS sub ON sub.subject_id = stusub.subject_id\r\n"
	        + "WHERE stu.student_id = ?1 AND stusub.student_id = stu.student_id")
	List<Object> getSchedule(Long id);
	
	
	@Query(nativeQuery = true, value="SELECT DISTINCT attendance.is_present, attendance.datemodified FROM student AS stu\r\n"
	        + "        JOIN (select * from attendance AS attendance\r\n"
	        + "        JOIN (SELECT sub.subject_code, sub.subject_title,sub.units, sub.subject_id FROM subject AS sub) AS sub\r\n"
	        + "        ON attendance.subject_id = sub.subject_id WHERE student_id = ?1) AS attendance\r\n"
	        + "        ON attendance.student_id = stu.student_id")
	List<Object> getAttendanceofStudent(Long id);
	
	
	@Query(nativeQuery = true, value="SELECT COUNT(student.student_id) FROM STUDENT")
	String getTotalStudents();
	
	@Query(nativeQuery = true, value="SELECT COUNT(student_id) FROM student WHERE data_modified >= (NOW() - INTERVAL '20 days')")
    String getNewStudents();
	
	@Query(nativeQuery = true, value="SELECT * FROM subject  WHERE course_fk = ?1 AND sem= ?2 AND year_level = ?3  ORDER BY year_level")
	List<Object> getCourseEvalution(Long id, String sem, String yrlvl);
	
}


















