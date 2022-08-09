package com.quiz.userlogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.connection.ConnectionImpl;

public class Login implements LoginInter {
	@Override
		  public void getLogin () throws SQLException {
		    PreparedStatement ps= null;
		    Connection con = null;
		    ResultSet rs= null; 
			try {
			ConnectionImpl conn = new ConnectionImpl();
			con = conn.getConnection();
			System.out.println("Enter user name : ");
			Scanner sc = new Scanner(System.in);
			String username=sc.nextLine();
			System.out.println("Enter password : ");
			String password=sc.nextLine();
			
				ps = con.prepareStatement("Select username,password from userinfo where username=?");
				ps.setString(1, username);
				rs=ps.executeQuery();
				if (rs.next()) {
				if  ((password.equals(rs.getString(2) )))
				{  
					System.out.println("You are succefully logged in");
				}	else {
					System.out.println("Please Enter correct password");}
		} else {
			  System.err.println("This user is not registered. Please register first ");
		  }
		}
			catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.close();
				ps.close();
				rs.close();	
			}
		  }
}


