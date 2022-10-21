package biz.global.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.global.model.Admin;
import biz.global.model.AdminResponse;
import biz.global.model.ResponseModel;
import biz.global.repo.AdminRepo;
import biz.global.service.AuthService;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthService authService;
    

    @Autowired
    private AdminRepo adminRepo;
    
    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    
    
//////////////////////////////////////////////////////////////////////////////////  GET MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
    
    
    
    
    
//////////////////////////////////////////////////////////////////////////////////  POST MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    

    
    @PostMapping(value = "register")
    public AdminResponse register(@RequestBody Admin model) throws IOException {
        return authService.saveAdminData(model);
    }
    
    @PostMapping(value = "login") 
    public AdminResponse login(@RequestBody Admin model) throws IOException{
        return authService.login(model);
    }
    
    
    
    
//////////////////////////////////////////////////////////////////////////////////  DELETE MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
    
    
    
    
    
    
//////////////////////////////////////////////////////////////////////////////////  PATCH MAPPING  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
    
    @PatchMapping(value = "updateadmin/{id}")
    public ResponseEntity<ResponseModel> updateAdmin(@PathVariable Long id,@RequestBody Admin admin) {
        Optional<Admin> model = adminRepo.findById(id);
        if(model.isEmpty()) {
            return ResponseEntity.ok().body(new ResponseModel(0, "admin does not exist", "", null));
        }
        
        if((admin.getPassword() != null)) {
            String hasspassword = bcrypt.encode(admin.getPassword());
            model.get().setPassword(hasspassword);
        }
        model.get().setFirstName(admin.getFirstName());
        model.get().setLastName(admin.getLastName());
        model.get().setUsername(admin.getUsername());
        
        adminRepo.save(model.get());
        return ResponseEntity.ok().body(new ResponseModel(1, "Admin details successfully updated", "", model.get()));
    }
    
    

}
