package org.jsp.bank.dao;

public class UserHelperClass {
	
	public static UserDAO userHelperMethod() {
		
		UserDAO userdao=new UserDaoImp();
		
		return userdao;
	}
	

}
