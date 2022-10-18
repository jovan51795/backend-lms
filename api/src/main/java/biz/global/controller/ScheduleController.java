package biz.global.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.global.model.Department;
import biz.global.model.ResponseModel;
import biz.global.model.Schedule;
import biz.global.repo.ScheduleRepo;

@RestController
@RequestMapping("api/schedule")
@CrossOrigin(origins = "http://localhost:3000")
public class ScheduleController {

	@Autowired
	private ScheduleRepo scheduleRepo;

	@GetMapping(value = "all")
	List<Schedule> getschedules() {
		return scheduleRepo.findAll();
	}

	@PostMapping(value = "add")
	private ResponseEntity<ResponseModel> addSchedule(@RequestBody Schedule sched){
		try {
			scheduleRepo.save(sched);
			return ResponseEntity.ok().body(new ResponseModel(1,"schedule successfully added","",sched));
		}
		catch (DataIntegrityViolationException e) {
			return ResponseEntity.ok().body(new ResponseModel(0, "schedule code already exist", "", null));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseModel(-1, "", null, null));
		}
	}
	
	@GetMapping(value = "/findbyid/{id}")
	private ResponseEntity<ResponseModel> getDepartmentByID(@PathVariable Long id) {
		Optional<Schedule> schedule = scheduleRepo.findById(id);
		if(schedule.isPresent()) {
			return ResponseEntity.ok().body(new ResponseModel(1, "schedule exist", "", schedule));
		}
		return ResponseEntity.ok().body(new ResponseModel(0, "schedule does not exist", "", schedule));
	}
	
	
	
}