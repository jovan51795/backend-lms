package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biz.global.model.Schedule;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Long> {
	
//	Schedule  findByScheduleCode(String schedule_code);
}
