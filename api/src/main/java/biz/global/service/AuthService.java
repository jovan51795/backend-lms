package biz.global.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import biz.global.Table.Tables;
import biz.global.Table.tables.records.AdminRecord;
import biz.global.model.Admin;
import biz.global.model.AdminResponse;
import biz.global.util.JWTUtility;

@Service
public class AuthService {
	
	@Autowired
	private DSLContext context;
	
	@Autowired
	private JWTUtility jwtUtility;
	
	Admin adminModel = new Admin();
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	
	AdminResponse adminResponse = new AdminResponse();
	
	public AdminResponse saveAdminData(Admin model) throws IOException {
		if(findByUserName(model.getUsername())) {
			return new AdminResponse(0, "", "Username already exist!");
		}
		model.setPassword(bcrypt.encode(model.getPassword()));
		context.insertInto(Tables.ADMIN, Tables.ADMIN.FIRST_NAME, Tables.ADMIN.LAST_NAME, Tables.ADMIN.PASSWORD, Tables.ADMIN.TYPE, Tables.ADMIN.USERNAME)
		.values(model.getFirstName(), model.getLastName(), model.getPassword(), model.getType(), model.getUsername())
		.execute();
		model.setPassword("");
		
		return new AdminResponse(1, jwtUtility.generateToken(model.getUsername()), "Registered Successfully", model);
	}
	
	public  Boolean findByUserName(String username) throws IOException{
		AdminRecord result = context.fetchOne(Tables.ADMIN, Tables.ADMIN.USERNAME.eq(username));
		Optional<AdminRecord> data = Optional.ofNullable(result);
		if(data.isPresent()) {
			
			adminModel =	new Admin(result.getAdminId(), result.getFirstName(), result.getLastName(), result.getUsername(), result.getType(), result.getPassword());
		}
		
		return data.isPresent();
	}
	
	public AdminResponse login(Admin model) throws IOException {
		
		if(findByUserName(model.getUsername()) && bcrypt.matches(model.getPassword(), adminModel.getPassword())) {
			model.setPassword("");
			return new AdminResponse(1, jwtUtility.generateToken(model.getUsername()), "", adminModel);
			//return ResponseEntity.ok().body(new AdminResponse(1, jwtUtility.generateToken(model), "", adminModel));
		}
		return new AdminResponse(0, "", "Invalid username or password");
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AdminResponse(0, "", "Invalid username or password"));
	}

}
