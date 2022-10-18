package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.global.model.Grades;

public interface GradesRepo extends JpaRepository<Grades, Long> {

}
