package com.jwt.Jsonwebtoken.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class UserEntity {

	@Override
	public String toString() {
		return "UserEntity [userid=" + userid + ", gender=" + gender + ", fullName=" + fullName + ", phoneNumber="
				+ phoneNumber + ", emailId=" + emailId + ", password=" + password + ", loginCount=" + loginCount
				+ ", userType=" + userType + ", isActive=" + isActive + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	private String gender;
	private String fullName;
	private String phoneNumber;
	private String emailId;
	private String password;
	private int loginCount=0;
	private String userType;
//	private DateTime createdAt;
//	private DateTime updateAt;
	private Boolean isActive = true;

	public int getUserid() {
		return userid;
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

	public String getPassword() {
		return password;
	}


	public String getUserType() {
		return userType;
	}

//	public DateTime getCreatedAt() {
//		return createdAt;
//	}
//
//	public DateTime getUpdateAt() {
//		return updateAt;
//	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public void setPassword(String password) {
		this.password = password;
	}



	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

//	public void setCreatedAt(DateTime createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public void setUpdateAt(DateTime updateAt) {
//		this.updateAt = updateAt;
//	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

//	@PrePersist
//	public void onSave() {
//		// create at and update at
//		DateTime currentDateTime = new DateTime();
//
//		this.createdAt = currentDateTime;
//		this.updateAt = currentDateTime;
//	}
//
//	@PostPersist
//	public void onUpdate() {
//		// update at
//		DateTime currentDateTime = new DateTime();
//		this.updateAt = currentDateTime;
//	}
}
