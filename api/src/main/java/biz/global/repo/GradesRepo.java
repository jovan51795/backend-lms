package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import biz.global.model.Grades;

public interface GradesRepo extends JpaRepository<Grades, Long> {
	@Query(nativeQuery = true, value="select * from attendance WHERE student_id = ?1 AND subject_id = ?2 AND  professor_id =?3  LIMIT 1")
	Grades findGrade( Long stuid, Long subid, Long profid);
}
