package com.vns.groupin.java.Response;

import com.vns.groupin.java.Entity.UserRegistration;

public class UserRegResponse {
	
	Boolean status;
	UserRegistration userReg;
	String message;
	
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public UserRegistration getUserReg() {
		return userReg;
	}
	public void setUserReg(UserRegistration userReg) {
		this.userReg = userReg;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
