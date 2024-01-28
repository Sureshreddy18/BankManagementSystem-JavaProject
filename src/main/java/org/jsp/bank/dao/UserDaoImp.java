package org.jsp.bank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class UserDaoImp implements UserDAO {
	
	final private String select="select * from bank_user_details where user_BankEmailId=? and user_Password=?";
	final private String url="jdbc:mysql://localhost:3307/advancejavaprojects?user=root&password=12345";
	
	final private String selectaccandpwd="select *  from bank_user_details where user_AccountNo=? and user_Password=?";
	
	final private String update="update bank_user_details set user_Amount=? where user_Password=?";
	
	final private String insertStatement="insert into statement values(?,?,?,?,?,?,?,?,?)";
	
	final private String selectmobile="select * from bank_user_details where user_MobileNo=?";
	final private String updateBal="update bank_user_details set user_Amount=? where user_MobileNo=?";
	
	final private String updatePassword="update bank_user_details set user_Password=? where user_AccountNo=?";
	
	final private String selectStatement="select * from statement where bank_AccountNo=? and date_OfTransaction>?";
	
	
	Scanner sc=new Scanner(System.in);
	@Override
	public boolean userLogin(String bankMail, int password) {
		
		try {
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(select);
			
			ps.setString(1, bankMail);
			ps.setInt(2, password);
			
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
	public void debit(int accountNo, int password) {
		
	try {
		Connection con=	DriverManager.getConnection(url);
		PreparedStatement ps=con.prepareStatement(selectaccandpwd);
		
		ps.setInt(1, accountNo);
		ps.setInt(2, password);
		
		ResultSet set=ps.executeQuery();
		
		if(set.next())
		{
			System.out.println("Enter Your Amount");
			double amount=sc.nextDouble();
			if(amount>0)
			{
				double databaseAmount=set.getDouble("user_Amount");
				if(amount<=databaseAmount)
				{
					double remainBal=databaseAmount-amount;
					PreparedStatement ps1=con.prepareStatement(update);
					
					ps1.setDouble(1, remainBal);
					ps1.setInt(2, password);
					int result=ps1.executeUpdate();
					if(result!=0)
					{
					PreparedStatement ps2=con.prepareStatement(insertStatement);
					ps2.setString(1, "debit");
					ps2.setDate(2, Date.valueOf(LocalDate.now()));
					ps2.setString(3, "Online");
					
					Random r=new Random();
					int transactionId=r.nextInt(10000000);
					if(transactionId<10000000)
					{
						transactionId+=10000000;
					}
					ps2.setInt(4, transactionId);
					ps2.setString(5, amount+" Dr");
					int id=set.getInt("user_Id");
					ps2.setInt(6, id);
					ps2.setInt(7, accountNo);
					ps2.setTime(8, Time.valueOf(LocalTime.now()));
					ps2.setString(9, "Rs "+remainBal);
					int update2=ps2.executeUpdate();
					if(update2!=0)
					{
						System.out.println("Amount Debited Succesfully");
					}	
						
					}
					else
					{
						System.out.println("Server 404 Error");
					}
					
				}
				else
				{
					System.out.println("Insufficient Amount");
				}
			}
			else
			{
				System.out.println("Invalid Amount");
			}
		}
		else
		{
			System.out.println("Invalid Account Details ");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public void credit(int accountNo, int password) {
		
		try {
			Connection con=	DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(selectaccandpwd);
			
			ps.setInt(1, accountNo);
			ps.setInt(2, password);
			
			ResultSet set=ps.executeQuery();
			
			if(set.next())
			{
				System.out.println("Enter Your Amount");
				double amount=sc.nextDouble();
				if(amount>0)
				{
					double databaseAmount=set.getDouble("user_Amount");
					if(amount<=databaseAmount)
					{
						double remainBal=databaseAmount+amount;
						PreparedStatement ps1=con.prepareStatement(update);
						
						ps1.setDouble(1, remainBal);
						ps1.setInt(2, password);
						int result=ps1.executeUpdate();
						if(result!=0)
						{
						PreparedStatement ps2=con.prepareStatement(insertStatement);
						ps2.setString(1, "credit");
						ps2.setDate(2, Date.valueOf(LocalDate.now()));
						ps2.setString(3, "Online");
						
						Random r=new Random();
						int transactionId=r.nextInt(10000000);
						if(transactionId<10000000)
						{
							transactionId+=10000000;
						}
						ps2.setInt(4, transactionId);
						ps2.setString(5, amount+" Cr");
						int id=set.getInt("user_Id");
						ps2.setInt(6, id);
						ps2.setInt(7, accountNo);
						ps2.setTime(8, Time.valueOf(LocalTime.now()));
						ps2.setString(9, "Rs "+remainBal);
						int update2=ps2.executeUpdate();
						if(update2!=0)
						{
							System.out.println("Amount Credited Succesfully");
						}	
							
						}
						else
						{
							System.out.println("Server 404 Error");
						}
						
					}
					else
					{
						System.out.println("Insufficient Amount");
					}
				}
				else
				{
					System.out.println("Invalid Amount");
				}
			}
			else
			{
				System.out.println("Invalid Account Details ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override                              //Senders Mobile Number
	public void mobileToMobileTransaction(String mobNo) {
		
		try {
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(selectmobile);
			ps.setString(1, mobNo);
			ResultSet set=ps.executeQuery();
			if(set.next())
			{
				System.out.println("Enter Receivers Mobile Number ");
				String rMob=sc.next();
				PreparedStatement psr=con.prepareStatement(selectmobile);
				psr.setString(1, rMob);
				ResultSet rset=psr.executeQuery();
				if (rset.next()) 
				{
					System.out.println("Enter Your Amount ");
					double am=sc.nextDouble();
					if (am>0) {
						double senAmount=set.getDouble("user_Amount");
						if(am<=senAmount)
						{
							double remainBal=senAmount-am;
							PreparedStatement ps1=con.prepareStatement(updateBal);
							
							ps1.setDouble(1, remainBal);
							ps1.setString(2, mobNo);
							int result=ps1.executeUpdate();
							if(result!=0)
							{
								PreparedStatement ps2=con.prepareStatement(insertStatement);
								ps2.setString(1, "debit");
								ps2.setDate(2, Date.valueOf(LocalDate.now()));
								ps2.setString(3, "mobileToMobile");
								
								Random r=new Random();
								int transactionId=r.nextInt(10000000);
								if(transactionId<10000000)
								{
									transactionId+=10000000;
								}
								ps2.setInt(4, transactionId);
								ps2.setString(5, am+" Dr");
								int id=set.getInt("user_Id");
								ps2.setInt(6, id);
								ps2.setInt(7, set.getInt("user_AccountNo"));
								ps2.setTime(8, Time.valueOf(LocalTime.now()));
								ps2.setString(9, "Rs "+remainBal);
								int update2=ps2.executeUpdate();
								if(update2!=0)
								{
									double rBal=rset.getDouble("user_Amount")+am;
									PreparedStatement ps3=con.prepareStatement(updateBal);
									
									ps3.setDouble(1, rBal);
									ps3.setString(2, rMob);
									int result1=ps3.executeUpdate();
									if(result1>0)
									{
										PreparedStatement ps4=con.prepareStatement(insertStatement);
										ps4.setString(1, "credit");
										ps4.setDate(2, Date.valueOf(LocalDate.now()));
										ps4.setString(3, "mobileToMobile");
										
										Random r1=new Random();
										int transactionId1=r1.nextInt(10000000);
										if(transactionId1<10000000)
										{
											transactionId1+=10000000;
										}
										ps4.setInt(4, transactionId1);
										ps4.setString(5, am+" Cr");
										int id1=rset.getInt("user_Id");
										ps4.setInt(6, id1);
										ps4.setInt(7, rset.getInt("user_AccountNo"));
										ps4.setTime(8, Time.valueOf(LocalTime.now()));
										ps4.setString(9,"Rs "+rBal);
										int update3=ps4.executeUpdate();
										if(update3>0)
										{
											System.out.println("Transaction Succesful");
										}
										else
										{
											System.out.println("Transaction Error");
										}
									}
									
								}
							}
							else
							{
								System.out.println("Server 404 Error");
							}
						}
						else
						{
							System.out.println("Insufficient balance");
						}
						
					} else {
						System.out.println("Invalid Balance");
					}
					
					
				} else {
					System.out.println("Invalid Receiver Mobile Number");

				}
			}
			else
			{
				System.out.println("Invalid Senders Mobile Number");
			}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void checkBalance(int accountNo, int password) {
		
		try {
			Connection con=	DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(selectaccandpwd);
			
			ps.setInt(1, accountNo);
			ps.setInt(2, password);
			
			ResultSet set=ps.executeQuery();
			if(set.next())
			{
				System.out.println(set.getDouble("user_Amount"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void changepassword(int accountNo, int password) {
		
		try {
			Connection con=DriverManager.getConnection(url);
//			System.out.println("Connection Done");
			
			PreparedStatement ps=con.prepareStatement(updatePassword);
				ps.setInt(1, password);
				ps.setInt(2, accountNo);
				int res=ps.executeUpdate();
				if(res>0)
				{
					System.out.println("Updated Succesfully");
				}
				else
				{
					System.out.println("Invalid data");
				}
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void checkStatement(int accountNo,Date date) {
		try {
		 Connection con=DriverManager.getConnection(url);
		 PreparedStatement ps=con.prepareStatement(selectStatement);
		 ps.setInt(1, accountNo);
		 ps.setDate(2, date);
		 ResultSet set=ps.executeQuery();
		 System.out.println("Your Last Five Transactions are");
		 for(int i=0;i<5;i++)
		 {
			 if(set.next())
			 {
				 //status, date_OfTransaction, type_OfPayment, transactionId, amount, userId, bank_accountNo, transaction_Time, remaining_Balance
				
				 System.out.println("[ "+set.getString("status")+", "+set.getDate("date_OfTransaction")+", "+set.getString("type_OfPayment")+
						 ", "+set.getInt("transactionId")+", "+set.getString("amount")+", "+
						 set.getTime("transaction_Time")+", "+set.getString("remaining_Balance")+" ]");
				 System.out.println("------------------------");
			 }
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
