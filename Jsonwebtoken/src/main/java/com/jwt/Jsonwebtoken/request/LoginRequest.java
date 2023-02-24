package com.jwt.Jsonwebtoken.request;

public class LoginRequest {

	private String emailId;
	public String getEmailId() {
		return emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
}
