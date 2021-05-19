package com.vns.groupin.java.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vns.groupin.java.Entity.UserRegistration;
import com.vns.groupin.java.Repository.UserRegRepository;

@Service
public class UserRegService {

	@Autowired
	private UserRegRepository userRegRepo;

	public List<UserRegistration> getAllUsers() {
		List<UserRegistration> userReg = new ArrayList<>();
		userRegRepo.findAll().forEach(userReg::add);
		return userReg;
	}

	public UserRegistration findByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return userRegRepo.findByMobileNumber(mobileNumber);
	}

	public UserRegistration saveUser(UserRegistration user) {
		// TODO Auto-generated method stub
		return userRegRepo.save(user);
	}
}
