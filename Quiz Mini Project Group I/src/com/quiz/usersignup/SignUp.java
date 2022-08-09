
package com.quiz.usersignup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.authentication.UsernameValidation;
import com.connection.ConnectionImpl;

public class SignUp implements SignUpInter {
	@Override
	public void insertStudentData(String firstname, String lastname, String username, String password, String emailId,
			String mobileNo) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		try {

			ConnectionImpl con = new ConnectionImpl();
			connection = con.getConnection();

			ps = connection.prepareStatement(
					"insert into userinfo(firstname,lastname,username,password,emailId,mobileNo)values(?,?,?,?,?,?)");
			ps.setString(1, firstname);

			ps.setString(2, lastname);
			ps.setString(3, username);
			ps.setString(4, password);
			PasswordValidation vldp = new PasswordValidation();
			vldp.getvalidatePassword(password);
			ps.setString(5, emailId);
			ps.setString(6, mobileNo);
			MobileValidation mbl = new MobileValidation();
			mbl.getMobileNoValidation(mobileNo);
			int i = ps.executeUpdate();
			LastId lastId = new LastId();
			int lid = lastId.getLastId();
			System.out.println("Congratulations You Have Registerd Successfully with id >>" + lid);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} finally {
			connection.close();
			ps.close();
		}
	}

	public void getuserSingUp() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter User Name : ");
		String username = sc.nextLine();
		UsernameValidation usernameValidation = new UsernameValidation();
		boolean bRet = usernameValidation.getUsernameValidate(username);
		if (bRet == false) {
			System.err.println(username + " username already exist... try another...");
			SignUp signUp = new SignUp();
			signUp.getuserSingUp();
		} else {
			System.out.print("Enter First Name : ");
			String firstname = sc.nextLine();
			System.out.print("Enter Last Name : ");
			String lastname = sc.nextLine();
			System.out.print("password contain at least one Uppercase,Lowercase and Digit");
			System.out.print("Enter Password : ");
			String password = sc.nextLine();
			System.out.print("Enter EmailId : ");
			String emailId = sc.nextLine();
			System.out.print("Enter Mobile Number : ");
			String mobileNo = sc.nextLine();
			SignUp insertTest = new SignUp();
			insertTest.insertStudentData(firstname, lastname, username, password, emailId, mobileNo);
			sc.close();
		}
	}

}
