package biz.global.controller;


import java.io.IOException;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.global.model.ResponseModel;
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
    
    
  //////////////////////////////////////////////////////////////////////////////////  GET MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
    
    
    public String getTotalStudents() {
        return studentRepo.getTotalStudents();
    }
    
    
    public String getNewStudents() {
        return studentRepo.getNewStudents();
    }
    
    
    public String getFacultyMembers() {
        return profRepo.getTotalFacultyMembers();
    }
    
    public String getTotalCourses() {
        return profRepo.getTotalCourses();
    }
    
    @GetMapping(value="dashboardreports")
    public ResponseEntity<ResponseModel> addProfessor() throws IOException {
        ArrayList<Object> dashboardReports = new ArrayList<>();
        dashboardReports.add(getTotalStudents());
        dashboardReports.add(getNewStudents());
        dashboardReports.add(getFacultyMembers());
        dashboardReports.add(getTotalCourses());

        return ResponseEntity.ok().body(new ResponseModel(1, "professor added successfully", null, dashboardReports));
    }
    
  //////////////////////////////////////////////////////////////////////////////////  POST MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
      

      
      
  //////////////////////////////////////////////////////////////////////////////////  DELETE MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
    
      
      
      
  //////////////////////////////////////////////////////////////////////////////////  PATCH MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
    
    
  
    

}
