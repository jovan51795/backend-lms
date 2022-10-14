package biz.global.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import biz.global.model.Attendance;
import biz.global.model.Subject;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
	
	@Query(nativeQuery = true,  value="SELECT DISTINCT stu.student_id, stu.first_name, stu.middle_name, stu.last_name, subject.subject_id, subject.subject_title, subject.subject_code FROM student as stu, student_subject as stusub JOIN (SELECT * FROM subject WHERE subject.subject_code LIKE :subjectCode%) as subject ON stusub.subject_id = stusub.student_id")
	List<Object> getAllStudentsEnrolledSubject(@Param("subjectCode") String subjectCode);
	
	@Query(nativeQuery = true,  value="SELECT DISTINCT stu.student_id, stu.first_name, stu.middle_name, stu.last_name, subject.subject_id, subject.subject_title, subject.subject_code, subject.professor_name \r\n"
			+ "FROM student as stu, student_subject as stusub JOIN \r\n"
			+ "(SELECT sub.subject_id, sub.subject_title, sub.subject_code, prof.professor_name  FROM subject AS sub JOIN (SELECT prof.professor_name, prof.professor_id  FROM professor AS prof where prof.professor_id= :profID) AS prof "
			+ "ON  sub.professor_id = prof.professor_id  WHERE sub.subject_code LIKE :subjectCode%) as subject ON stusub.subject_id = stusub.student_id")
	List<Object> studentList(@Param("subjectCode") String subjectCode, @Param("profID") Long profID);
}
