package org.jsp.bank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
//import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import org.jsp.bank.model.BankUserDetails;

public class AdminDaoImp implements AdminDAO {
	final private String select="select * from bank_admin where admin_EmailId=? and admin_Password=?";
	final private String url="jdbc:mysql://localhost:3307/advancejavaprojects?user=root&password=12345";
	
	final private String insert="insert into bank_user_details(user_Name, user_BankEmailId, user_EmailId, user_Password, user_Gender, user_Address, user_Dob, user_AccountNo, user_Amount, user_MobileNo, IFSC_Code)"
			+ "values(?,?,?,?,?,?,?,?,?,?,?)";
	
	final private String selectall="select * from bank_user_details";
	final private String delete="delete from bank_user_details where user_AccountNo=?";
	
	final private String updateuser="update bank_user_details set user_Name=? where user_AccountNo=?";
	final private String updatemail="update bank_user_details set user_EmailId=? where user_AccountNo=?";
	final private String updateMob="update bank_user_details set user_MobileNo=? where user_AccountNo=?";
	
	

	@Override
	public boolean adminLogin(String emailId, String password) {
		Scanner sc=new Scanner(System.in);
		try {
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(select);
			
			ps.setString(1, emailId);
			ps.setString(2, password);
			
			ResultSet set =ps.executeQuery();
			
			if (set.next()) {
				
				return true;
				
			} else {
				
				return false;

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	@Override
	public void userRegistration(BankUserDetails userDetails) {
		try
		{
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(insert);
			ps.setString(1,userDetails.getUserName());
			
			Random random=new Random(); 
			int emailid=random.nextInt(100);
			if(emailid<10)
			{
				emailid+=10;
			}
			String bankEmailId=userDetails.getUserName()+emailid+"@teca53.com";
			ps.setString(2, bankEmailId);
			
			ps.setString(3, userDetails.getEmailId());
			
			int password=random.nextInt(10000);
			if(password<1000)
			{
				password+=1000;
			}
			ps.setInt(4,password);
		
			ps.setString(5,userDetails.getUserGender());
			ps.setString(6,userDetails.getAddress());
			

			LocalDate userDateOfBirth=userDetails.getUserDob();
			ps.setDate(7, Date.valueOf(userDateOfBirth));
			
			int accountNumber=random.nextInt(10000000);
			if(accountNumber<1000000)
			{
				accountNumber+=1000000;
			}
			ps.setInt(8, accountNumber);   
			
			ps.setDouble(9,userDetails.getUserAmount());
			ps.setString(10,userDetails.getUserMobileNo());
			ps.setString(11,"IFSCTECA53");
			
			int result=ps.executeUpdate();    
			if(result!=0)
			{
				System.out.println("Registration successful........!");
			}
			else
			{
				System.out.println("Enter valid details");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	



		
	}

	@Override
	public void selectAllUserDetails() {
		
		try
		{
			Connection connection=DriverManager.getConnection(url);
			Statement st=connection.createStatement();
			ResultSet set=st.executeQuery(selectall);
			if(set.isBeforeFirst())
			{
				while(set.next())
				{
					System.out.println("Name of the user :"+set.getString("user_Name"));
					System.out.println("Bank email id of the user :"+set.getString("user_BankEmailId"));
//					System.out.println("Password of the user :"+set.getString("User_Password"));
					
					int pwd=set.getInt("user_Password");
					int count=0;
					while(pwd>0)
					{
						count++;
						pwd/=10;
					}
					String pd=" ";
					for (int i = 0; i <count; i++) {
						pd=pd+"*";
					}
					System.out.println("Password of the user :"+pd);
					System.out.println("Mobile number of the user :"+set.getString("user_MobileNo").substring(0,3)+"****"+set.getString("user_MobileNo").substring(7));
					System.out.println("Gender of the user :"+set.getString("user_Gender"));
					System.out.println("Amount of the user :"+set.getDouble("user_Amount"));
				}
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void deleteUserDetails(int useraccountnumber) {

		try {
			Connection c=DriverManager.getConnection(url);
		    PreparedStatement p= c.prepareStatement(delete);
		    p.setInt(1, useraccountnumber);
		    int res= p.executeUpdate();
			  if(res!=0)
			  {
				  System.out.println("User Account Deleted ");
			  }
			  else
			  {
				  System.out.println("No Data FOund");
			  }
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(int acc,String user) {

		try {
			Connection con=	DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(updateuser);
			
			ps.setString(1, user);
			ps.setInt(2, acc);
			
			int set=ps.executeUpdate();
			if(set>0)
			{
				System.out.println("User Name Updated Succesfully");
			}
			else
			{
				System.out.println("Invalid User Name");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		

	@Override
	public void updateEmail(int acc,String mail) {
		// TODO Auto-generated method stub

		try {
			Connection con=	DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(updateuser);
			
			ps.setString(1, mail);
			ps.setInt(2, acc);
			
			int set=ps.executeUpdate();
			if(set>0)
			{
				System.out.println("Email Id Updated Succesfully");
			}
			else
			{
				System.out.println("Invalid Mail Id");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateMobileNo(int acc,String mob) {
		// TODO Auto-generated method stub

		try {
			Connection con=	DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(updateuser);
			
			ps.setString(1, mob);
			ps.setInt(2, acc);
			
			int set=ps.executeUpdate();
			if(set>0)
			{
				System.out.println("Mobile Number Updated Succesfully");
			}
			else
			{
				System.out.println("Invalid Mobile Number");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
