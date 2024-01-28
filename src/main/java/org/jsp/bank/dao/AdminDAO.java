package org.jsp.bank.dao;

import org.jsp.bank.model.BankUserDetails;

public interface AdminDAO {

	boolean adminLogin(String emailId,String password);
	
	void selectAllUserDetails();
	
	void userRegistration(BankUserDetails userDetails);
	
	void deleteUserDetails(int useraccountnumber);
	
	void updateUser(int acc,String userName);
	
	void updateEmail(int acc,String mail);
	
	void updateMobileNo(int acc,String mob);
	

}
