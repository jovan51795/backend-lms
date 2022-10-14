package biz.global.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.global.model.Admin;
import biz.global.model.AdminResponse;
import biz.global.service.AuthService;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@PostMapping(value = "register")
	public AdminResponse register(@RequestBody Admin model) throws IOException {
		return authService.saveAdminData(model);
	}
	
	@PostMapping(value = "login") 
	public AdminResponse login(@RequestBody Admin model) throws IOException{
		return authService.login(model);
	}
	
	


}
