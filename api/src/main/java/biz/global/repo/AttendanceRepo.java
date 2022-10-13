package biz.global.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import biz.global.dto.AttendanceDto;
import biz.global.model.Attendance;
import biz.global.model.Subject;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
	
	@Query(nativeQuery = true,  value="SELECT stu.student_id, stu.first_name, stu.middle_name, stu.last_name, subject.subject_id, subject.subject_title, subject.subject_code FROM student as stu, student_subject as stusub JOIN (SELECT * FROM subject WHERE subject.subject_code LIKE :subjectCode%) as subject ON stusub.subject_id = stusub.student_id")
	List<Object> getAllStudentsEnrolledSubject(@Param("subjectCode") String subjectCode);
	
	
}
