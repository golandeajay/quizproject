package com.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.authentication.LoginSecurity;
import com.quiz.feedback.Feedback_InterfaceImpl;
import com.quiz.result.Result;
import com.quiz.userlogin.Login;
import com.quiz.userlogin.UserAdmin;
import com.quiz.usersignup.LoginChoice;
import com.quiz.usersignup.SignUp;

public class MainCall {
	public void getMainCall() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------------");
		System.out.println("Java Quiz  ");
		System.out.println("------------");
		System.out.println("1 : Login");
		System.out.println("2 : SignUp");
		System.out.println("0 : Exit");
		System.out.print("Choose option : ");
		int i = scanner.nextInt();
		System.out.println("------------");

		switch (i) {
		case 1:
			
			UserAdmin userAdmin = new UserAdmin();
			userAdmin.getUserAdmin();
			break;
		case 2:
			SignUp signUp = new SignUp();
			signUp.getuserSingUp();
			break;
		case 0:
			System.out.println("Thank you");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option");
		}
	}
}
