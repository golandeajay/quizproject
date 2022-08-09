package com.quiz.userlogin;

import java.sql.SQLException;
import java.util.Scanner;

import com.authentication.IdSecurity;
import com.authentication.LoginSecurity;
import com.main.MainCall;
import com.quiz.result.AdminValidationImpl;
import com.quiz.usersignup.LoginChoice;

public class UserAdmin {

	public void getUserAdmin() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1 : Student login");
		System.out.println("2 : Admin login");
		System.out.println("\nEnter the choice:");
		String choice = scanner.next();
		int uId = 0;
		switch(choice) {
		case "1" : 
			System.out.print("Enter username:");
			String username = scanner.next();
			System.out.print("Enter password:");
			String password = scanner.next();
			IdSecurity idSecurity = new IdSecurity();
			uId = idSecurity.verifyId(username, password);
			LoginSecurity loginSecurity = new LoginSecurity();
			boolean bRet = loginSecurity.getLogin(username, password);
			if (bRet == true) {
			} else if (bRet == false) {
				System.err.println("Invalide username or password");
				System.err.println("try again...");
				MainCall mainCall = new MainCall();
				mainCall.getMainCall();
			}
			LoginChoice loginChoice = new LoginChoice();
			loginChoice.getLoginChoice(uId,username, password);
			break;
		case "2" : 
			System.out.println("Please enter admin username");
			String admin_username = scanner.next();
			System.out.println("Please enter admin password");
			String admin_password = scanner.next();
			AdminValidationImpl adminValidationImpl = new AdminValidationImpl();
			adminValidationImpl.validateAdmin(admin_username, admin_password);
			break ;
			default:
				System.err.println("Invalid option");
				
		}
		
	}
}

