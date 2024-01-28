package org.jsp.bank.dao;

public class AdminHelperClass {
	
	public static AdminDAO adminHelperMethod() {
	
		AdminDAO userdao=new AdminDaoImp();
		return userdao;
		
	}

}
