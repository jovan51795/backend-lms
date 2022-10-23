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
	
	@Query(nativeQuery = true, value="SELECT COUNT(professor_id) FROM professor")
    String getTotalFacultyMembers(); 
    
	@Query(nativeQuery = true, value="SELECT COUNT(course_id) from course")
    String getTotalCourses(); 
	
	@Query(nativeQuery = true, value="SELECT DISTINCT sub.subject_id, sub.subject_title, sub.subject_code, grades.prelim_grade, grades.midterm_grade, grades.final_grade, grades.remarks, grades.status FROM grades AS grades\r\n"
	        + "    JOIN (SELECT  sub.subject_title, sub.subject_code,sub.subject_id,  sub.professor_id, prof.first_name\r\n"
	        + "    FROM  subject AS sub JOIN (SELECT first_name, professor_id \r\n"
	        + "    FROM professor where professor_id = ?1) as prof ON sub.professor_id = prof.professor_id) as sub ON grades.subject_id = sub.subject_id")
	List<Object> getAllGradesbySubject(Long id);
	
	@Query(nativeQuery = true, value="SELECT DISTINCT details.student_id,details.first_name, details.last_name, details.subject_id, g.prelim_grade, g.midterm_grade, g.final_grade, g.comment, g.status FROM grades AS g\r\n"
	        + "JOIN (SELECT DISTINCT stu.student_id, stu.first_name, stu.last_name, sub.subject_id FROM student AS stu, student_subject AS stusub\r\n"
	        + "    JOIN (SELECT sub.subject_id, sub.subject_code, sub.subject_title FROM subject sub\r\n"
	        + "    JOIN (SELECT prof.professor_id FROM professor AS prof WHERE prof.professor_id = :profID) AS prof ON prof.professor_id = sub.professor_id WHERE sub.subject_id= :subID) AS sub\r\n"
	        + "    ON sub.subject_id = stusub.subject_id WHERE stu.student_id = stusub.student_id ) AS details\r\n"
	        + "    ON (details.student_id = g.student_id AND details.subject_id = g.subject_id)")
    List<Object> getAllGradesbySubjectbyStudents(@Param("profID")long profid, @Param("subID")long subID);
	

}
