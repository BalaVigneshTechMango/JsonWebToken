package com.jwt.Jsonwebtoken.request;

public class SignUpRequest {

	private String gender;
	private String fullName;
	private String phoneNumber;
	private String emailId;
	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public String getFullName() {
		return fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
