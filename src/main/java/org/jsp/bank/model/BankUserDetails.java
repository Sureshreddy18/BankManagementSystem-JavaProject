package org.jsp.bank.model;

import java.time.LocalDate;

public class BankUserDetails {
	
	private int userId;
	private String userName;
	private String userBankEmailId;
	private String emailId;
	private int userPassword;
	private String userGender;
	private String address;
	private LocalDate userDob;
	private int userAccountNo;
	private double userAmount;
	private String userMobileNo;
	private String ifscCode;
	
	public BankUserDetails() {
		
	}

	public BankUserDetails(int userId, String userName, String userBankEmailId, String emailId, int userPassword,
			String userGender, String address, LocalDate userDob, int userAccountNo, double userAmount,
			String userMobileNo, String ifscCode) {
		this.userId = userId;
		this.userName = userName;
		this.userBankEmailId = userBankEmailId;
		this.emailId = emailId;
		this.userPassword = userPassword;
		this.userGender = userGender;
		this.address = address;
		this.userDob = userDob;
		this.userAccountNo = userAccountNo;
		this.userAmount = userAmount;
		this.userMobileNo = userMobileNo;
		this.ifscCode = ifscCode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserBankEmailId() {
		return userBankEmailId;
	}

	public void setUserBankEmailId(String userBankEmailId) {
		this.userBankEmailId = userBankEmailId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(int userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getUserDob() {
		return userDob;
	}

	public void setUserDob(LocalDate userDob) {
		this.userDob = userDob;
	}

	public int getUserAccountNo() {
		return userAccountNo;
	}

	public void setUserAccountNo(int userAccountNo) {
		this.userAccountNo = userAccountNo;
	}

	public double getUserAmount() {
		return userAmount;
	}

	public void setUserAmount(double userAmount) {
		this.userAmount = userAmount;
	}

	public String getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	@Override
	public String toString() {
		return "BankUserDetails [ userId=" + userId + ", userName=" + userName + ", userBankEmailId=" + userBankEmailId
				+ ", emailId=" + emailId + ", userPassword=" + userPassword + ", userGender=" + userGender
				+ ", address=" + address + ", userDob=" + userDob + ", userAccountNo=" + userAccountNo + ", userAmount="
				+ userAmount + ", userMobileNo=" + userMobileNo + ", ifscCode=" + ifscCode + "]";
	}
	
	
	

}
