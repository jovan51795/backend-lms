package biz.global.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.global.model.Department;
import biz.global.model.ResponseModel;
import biz.global.model.Subject;
import biz.global.repo.DepartmentRepo;
import biz.global.repo.SubjectRepo;

@RestController
@RequestMapping("api/departments")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Autowired
	private SubjectRepo subjectRepo;
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////  GET MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
    
	@GetMapping(value = "/all")
    private ResponseEntity<ResponseModel> all() {
        List<Department> dep = departmentRepo.findAll();
        return ResponseEntity.ok().body(new ResponseModel(1, "get all departments", "", dep, null));
    }
    
    @GetMapping(value = "/alldepwithsub")
    private ResponseEntity<ResponseModel> allDepartmentWithSubject() {
        List<Department> dep = departmentRepo.findAll();
        List<Subject> subjects = subjectRepo.findAll();
        return ResponseEntity.ok().body(new ResponseModel(1, "get all departments", "", dep, subjects));
    }
    
    @GetMapping(value = "/findbyid/{id}")
    private ResponseEntity<ResponseModel> getDepartmentByID(@PathVariable Long id) {
        Optional<Department> department = departmentRepo.findById(id);
        if(department.isPresent()) {
            return ResponseEntity.ok().body(new ResponseModel(1, "department exist", "", department));
        }
        return ResponseEntity.ok().body(new ResponseModel(0, "department does not exist", "", department));
    }
    
    
    
    
	//////////////////////////////////////////////////////////////////////////////////  POST MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
	    
	@PostMapping(value = "/add")
    private ResponseEntity<ResponseModel>  addDepartment(@RequestBody Department dep) {
        try {
            departmentRepo.save(dep);
             return ResponseEntity.ok().body(new ResponseModel(1, "department successfully added", "", dep));
        }
        catch (DataIntegrityViolationException e) {
            return ResponseEntity.ok().body(new ResponseModel(0, "course code already exist", "", null));
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseModel(-1, "", null, null));
        }
    }
	    
	
	
	
	
	
	    
	//////////////////////////////////////////////////////////////////////////////////  DELETE MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
	
	    
	@DeleteMapping(value = "/delete/{id}")
    private ResponseEntity<ResponseModel> deleteDepartment(@PathVariable Long id) {
        try {
            Optional<Department> department = departmentRepo.findById(id);
            if(department.isPresent()) {
                
                departmentRepo.deleteById(id);
                return ResponseEntity.ok().body(new ResponseModel(1, "department successfully deleted", "", null));
            }
            
            return ResponseEntity.ok().body(new ResponseModel(0, "An unexpected error occurred", "", null));
        }catch (Exception e) {
            return ResponseEntity.ok().body(new ResponseModel(0, "Unable to delete", "", null));
        }
    }
	
	
	
	
	
	
	
	    
	//////////////////////////////////////////////////////////////////////////////////  PATCH MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
	
	
	@PatchMapping(value = "/update/{id}")
	private ResponseEntity<ResponseModel> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
		Optional<Department> dep = departmentRepo.findById(id);
		if(dep.isPresent()) {
			departmentRepo.save(department);
			return ResponseEntity.ok().body(new ResponseModel(1, "department updated successfully", "", department));
		}
		return ResponseEntity.ok().body(new ResponseModel(0, "An unexpected error occurred", "", null));
	}
	
	

}
