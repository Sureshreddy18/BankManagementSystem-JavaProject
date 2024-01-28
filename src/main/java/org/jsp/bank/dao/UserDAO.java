package org.jsp.bank.dao;

import java.sql.Date;
import java.time.LocalDate;

public interface UserDAO {
	
	boolean userLogin(String bankMail,int password);
	
	void debit(int accountNo,int password);
	
	void credit(int accountNo,int password);
	
	void mobileToMobileTransaction(String mobNo);
	
	void checkBalance(int accountNo,int password);
	
	void changepassword(int accountNo,int password);
	
	void checkStatement(int accountNo,Date date);

}
