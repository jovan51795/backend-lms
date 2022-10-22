package biz.global.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.global.model.Admin;
import biz.global.model.Parent;
import biz.global.model.ResponseModel;

import biz.global.repo.ParentRepo;

import biz.global.util.JWTUtility;



@RestController
@RequestMapping(value = "api/parent/")
@CrossOrigin(origins = "http://localhost:3000")
public class ParentController {
    @Autowired
    ParentRepo parentRepo;
    @Autowired
    private JWTUtility jwtUtility;
    
    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    
    @PostMapping(value = "login")
    public ResponseEntity<ResponseModel> login(@RequestBody Admin admin) {  
        Optional<Parent> parent = Optional.ofNullable(parentRepo.findByLastName(admin.getUsername()));
        
        try {
            if(parent.isPresent() && parent.get().getLastName().equals(admin.getUsername()) && bcrypt.matches(admin.getPassword(), parent.get().getPassword()) && parent.get().getActive_deactive()) {
                ResponseModel responseModel = new ResponseModel(1, "Login successful",jwtUtility.generateToken(parent.get().getStudentNo()) ,parent.get());
                return ResponseEntity.ok().body(responseModel);
            }else if(!parent.get().getActive_deactive()) {
                return ResponseEntity.ok().body(new ResponseModel(0, "Your account has been deactivated", "", null));
            }
            return ResponseEntity.ok().body(new ResponseModel(0, "Username and password is incorrect", "", null));
        }catch (NoSuchElementException e) {
            return ResponseEntity.ok().body(new ResponseModel(0, "Username and password is incorrect", "", null));
        }   
    }
    

}
