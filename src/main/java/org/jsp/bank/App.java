package org.jsp.bank;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import org.jsp.bank.dao.AdminDAO;
import org.jsp.bank.dao.AdminHelperClass;
import org.jsp.bank.dao.UserDAO;
import org.jsp.bank.dao.UserHelperClass;
import org.jsp.bank.model.BankUserDetails;

/**
 * Hello world!
 * adminteca53@gmail.com
 * teca53
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Scanner sc=new Scanner(System.in);	
       AdminDAO adao= AdminHelperClass.adminHelperMethod();
       UserDAO udao=UserHelperClass.userHelperMethod();
       
       boolean welcomestatus=true;
       while(welcomestatus)
       {
	       System.out.println("Enter \n 1.For Admin Login \n 2.For User Login");
	       int welcome=sc.nextInt();
	       switch(welcome)
	       {
		       case 1: 
		    	   boolean adminLoginStatus=true;
		    	   int count=0;
		    	   while(adminLoginStatus)
		    	   {
		    		   System.out.println("Enter your EmailId");
			    	   String mail=sc.next();
			    	   System.out.println("Enter your password");
			    	   String pwd=sc.next();
			    	   if(adao.adminLogin(mail,pwd))
			    	   {
			    		   adminLoginStatus=false;
			    		   
			    		   System.out.println(" Enter \n 1.For User Registration \n 2.For All User Details \n "
			    		   		+ "3.Update Details \n 4.For Deleting User ");
			    		   int adminChoice=sc.nextInt();
			    		   switch(adminChoice)
			    		   {
			    		   case 1:
			    			   	BankUserDetails userDetails=new BankUserDetails();
		        				System.out.println("Enter your name");
		        				String name=sc.next();
		        				userDetails.setUserName(name);
		        				System.out.println("Enter your email id");
		        				String userEmailId=sc.next();
		        				userDetails.setEmailId(userEmailId);
		        				System.out.println("Enter your gender");
		        				String gender=sc.next();
		        				userDetails.setUserGender(gender);
		        				System.out.println("Enter your address");
		        				String address=sc.next();
		        				userDetails.setAddress(address);
		        				System.out.println("Enter your date of birth");
		        				String dateOfBirth=sc.next();
		        				userDetails.setUserDob(LocalDate.parse(dateOfBirth));
		        				System.out.println("Enter your amount");
		        				double amount=sc.nextDouble(); 
		        				userDetails.setUserAmount(amount);
		        				System.out.println("Enter your mobile number");
		        				String mobileNumber=sc.next(); 
		        				userDetails.setUserMobileNo(mobileNumber);
		        				  
		        				adao.userRegistration(userDetails);
		        			    break;
			    		   case 2:
		        				adao.selectAllUserDetails();
		        				break;
			    		   case 3:
			    			    System.out.println("Enter \n 1.For User Name \n 2.For Email Id \n 3.For Mobile Number");
			    			    int key=sc.nextInt();
			    			    switch(key)
			    			    {
			    			    case 1:
			    			    	System.out.println("Enter Your Account Number");
			    			    	int acc=sc.nextInt();
			    			    	System.out.println("Enter Your New User Name");
			    			    	String user=sc.next();
			    			    	adao.updateUser(acc,user);
			    			    	break;
			    			    case 2:
			    			    	System.out.println("Enter Your Account Number");
			    			    	int acc1=sc.nextInt();
			    			    	System.out.println("Enter Your New Mail Id");
			    			    	String email=sc.next();
			    			    	adao.updateEmail(acc1,email);
			    			    	break;
			    			    case 3:
			    			    	System.out.println("Enter Your Account Number");
			    			    	int acc2=sc.nextInt();
			    			    	System.out.println("Enter Your New Mobile Number");
			    			    	String mob=sc.next();
			    			    	adao.updateMobileNo(acc2,mob);
			    			    	break;
			    			    default:
			    			    	System.out.println("Invalid Choice");
			    			    	
			    			    }
		        				break;
			    		   case 4:
		        				System.out.println("Enter the Account Number");
		        				int accNum=sc.nextInt();
		        				adao.deleteUserDetails(accNum);
		        				break;
		        
			    		   default:
		        				System.out.println("you have entered invalid details ");
		        			  }
		        			  
			    		   }
			    	   else
			    	   {
		        			  System.out.println("Invalid details");
		        			 
		        			  count++;
		        			  System.out.println("*");

			    	   }
			    	   if(count==3)
		        	      {
		        		   adminLoginStatus=false;  
		        	      }
		        	   
		        		  welcomestatus=false;

		    	   }
		    	   
		       break;
		       case 2: 
		    	   System.out.println("Enter your EmailId");
		    	   String email=sc.next();
		    	   System.out.println("Enter your password");
		    	   int pswd=sc.nextInt();
	        	   
	        		  if( udao.userLogin(email,pswd))
	        		  {
	        			  System.out.println("Enter"+"\n 1.For Balance Enquiry"+"\n 2.For Withdraw"+
	        		  "\n 3.For Credit"+"\n 4.For Change Password"+"\n 5.For Check Statement"
	        					  +"\n 6.For Mobile To Mobile Transition");
	        			  int choice=sc.nextInt(); 
	        			  switch(choice)
	        			  {
		        			  case 1:
		        			  {
		        				  System.out.println("Enter Your Account Number ");
		        				  int accNo=sc.nextInt();
		        				  System.out.println("Enter your Password ");
		        				  int password=sc.nextInt();
		        				  System.out.println("The Remaining Balance is : Rs.");
		        				  udao.checkBalance(accNo, password);  
		        			  }
		        			  break;
		        			  case 2:
		        			  {
		        				  System.out.println("Enter Your Account Number ");
		        				  int accNo=sc.nextInt();
		        				  System.out.println("Enter your Password ");
		        				  int password=sc.nextInt();
		        				  udao.debit(accNo, password);
		        			  }
		        			  break;
		        			  case 3:
		        			  {
		        				  System.out.println("Enter Your Account Number ");
		        				  int accNo=sc.nextInt();
		        				  System.out.println("Enter your Password ");
		        				  int password=sc.nextInt();
		        				  udao.credit(accNo, password);
		        				  
		        			  }
		        			  break;
		        			  case 4:
		        			  {
		        				  System.out.println("Enter Your Account Number");
		        				  int acc=sc.nextInt();
		        				  System.out.println("Enter your New Password");
		        				  int pass=sc.nextInt();
		        				  udao.changepassword(acc, pass);  
		        			  }
		        			  break;
		        			  case 5:
		        			  {
		        				 System.out.println("Enter Your Account Number");
		        				 int accNo=sc.nextInt();
		        				 System.out.println("Enter the date that you need statement upto");
		        				 String s=sc.next();
		        				 Date d=Date.valueOf(s);
		        				 udao.checkStatement(accNo,d);
		        			  }
		        			  break;
		        			  case 6:
		        			  {
		        				  System.out.println("Enter your Mobile Number ");
		        				  String mob=sc.next();
		        				  udao.mobileToMobileTransaction(mob);
		        			  }
		        			  break;
		        			  default:
		        			  {
		        				  System.out.println("Invalid Input");
		        			  }	  
	        			  }
	        			  
	        		  }
	        		  else
	        		  {
	        			  System.out.println("invalid details");
	        		  }
	        		  
	        		  welcomestatus=false;

		       break;
		       
		       default: System.out.println("Enter Valid Choice");
	       }
	       
	       System.out.println("Do you want to Continue? \n Yes \n No");
	       String choice=sc.next();
	       if(choice.equalsIgnoreCase("no"))
	       {
	    	   welcomestatus=false;
	    	   System.out.println("Thank You Visit Again...");
	       }
	       else
	       {
	    	   welcomestatus=true;
	       }
       }
    }
}
