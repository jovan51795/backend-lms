package biz.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.global.model.Student;
import biz.global.repo.ProfessorRepo;
import biz.global.repo.StudentRepo;

@RestController
@RequestMapping("api/dashboard/")
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {
    
    

    @Autowired
    StudentRepo studentRepo;
    
    @Autowired
    ProfessorRepo profRepo;
    
    @GetMapping("totalstudents")
    public String getTotalStudents() {
        return studentRepo.getTotalStudents();
    }
    
    @GetMapping("newstudents")
    public String getNewStudents() {
        return studentRepo.getNewStudents();
    }
    
    @GetMapping("facultymembers")
    public String getFacultyMembers() {
        return profRepo.getTotalFacultyMembers();
    }
    

}
