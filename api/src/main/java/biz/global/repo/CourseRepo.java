package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.global.model.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {
	Course  findByCourseCode(String courseCode);
}
