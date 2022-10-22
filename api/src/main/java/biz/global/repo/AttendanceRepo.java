package biz.global.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import biz.global.model.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
	

	
	@Query(nativeQuery = true,  value="SELECT DISTINCT stu.student_id, stu.first_name, stu.middle_name, stu.last_name, subject.subject_id, subject.subject_title, subject.subject_code FROM student as stu, student_subject as stusub JOIN \r\n"
			+ "(SELECT  sub.subject_title, sub.subject_code,sub.subject_id,  sub.professor_id, prof.first_name\r\n"
			+ "FROM  subject AS sub JOIN (SELECT first_name, professor_id \r\n"
			+ "FROM professor WHERE professor_id = ?2) as prof ON sub.professor_id = prof.professor_id WHERE sub.subject_id = ?1) as subject \r\n"
			+ "ON stusub.subject_id = subject.subject_id WHERE stusub.student_id = stu.student_id")
	List<Object> studentListbySubject( Long subjectID,  Long profID);
	
	@Query(nativeQuery = true,  value="SELECT DISTINCT stu.student_id, stu.first_name, stu.middle_name, stu.last_name, subject.subject_id, subject.subject_title, subject.subject_code FROM student as stu, student_subject as stusub JOIN \r\n"
			+ "(SELECT  sub.subject_title, sub.subject_code,sub.subject_id,  sub.professor_id, prof.first_name\r\n"
			+ "FROM  subject AS sub JOIN (SELECT first_name, professor_id \r\n"
			+ "FROM professor WHERE professor_id = :profID) as prof ON sub.professor_id = prof.professor_id WHERE sub.subject_id = :subjectID) as subject \r\n"
			+ "ON stusub.subject_id = subject.subject_id WHERE stu.student_id = :studentID")
	List<Object> getstudentInSubjectByStudentID(@Param("subjectID") Long subjectID, @Param("profID") Long profID, @Param("studentID") Long studentID);
	
	@Query(nativeQuery = true,  value="SELECT DISTINCT sub.subject_title, sub.subject_code,sub.subject_id,  sub.professor_id, prof.first_name\r\n"
			+ "FROM  subject AS sub JOIN (SELECT first_name, professor_id \r\n"
			+ "FROM professor where professor_id = :profID) as prof ON sub.professor_id = prof.professor_id\r\n")
	List<Object> getSubjectByProfessor(@Param("profID") Long profID);
	
	@Query(nativeQuery = true, value="select * from attendance WHERE student_id = ?1 AND subject_id = ?2 AND  professor_id =?3  LIMIT 1")
    Attendance findAttendace(Long studentID, Long subjectID, Long profID);
}
