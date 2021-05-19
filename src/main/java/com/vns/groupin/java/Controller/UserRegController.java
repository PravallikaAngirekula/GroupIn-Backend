package com.vns.groupin.java.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vns.groupin.java.Entity.UserRegistration;
import com.vns.groupin.java.Response.UserRegResponse;
import com.vns.groupin.java.Service.UserRegService;

@RestController
@RequestMapping("/api-groupin.app/GroupIn")
public class UserRegController {
	
	@Autowired
	private UserRegService userRegService;
	
	
	@GetMapping("/all")
	public List<UserRegistration> getAllUsers() {
	return userRegService.getAllUsers();
	}
	
	
	@PostMapping("/register/1.0")
	public ResponseEntity<UserRegResponse> saveUserReg(@RequestBody UserRegistration user, HttpServletRequest httprequest){
		UserRegResponse response = new UserRegResponse();
		try {
			UserRegistration userExists =  userRegService.findByMobileNumber(user.getMobileNumber());
			
			if(userExists != null) {
				response.setMessage("user Already Exists");
			}else {
				UserRegistration result = new UserRegistration();
				
				result = userRegService.saveUser(user);
				
				response.setUserReg(result);
				response.setStatus(true);
				response.setMessage("Otp Sent to Given Mobile Number");
				
			}
		}catch(Exception e) {
			response.setMessage(e.getMessage());
		}
		return new ResponseEntity<UserRegResponse>(response, HttpStatus.CREATED);
	}

}
