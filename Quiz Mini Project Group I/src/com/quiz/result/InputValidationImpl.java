package com.quiz.result;

import java.util.Scanner;

public class InputValidationImpl implements InputValidation{
		
	public void validateInput(String option) {
		Scanner scanner = new Scanner(System.in);
		switch (option) {
		case "1":
			System.out.println("Enter your ID ");
			int userid = scanner.nextInt();
			UserIdValidationImpl userIdValidation = new UserIdValidationImpl();
			userIdValidation.validateId(userid);
			break;
			
		case "2":
			int uId = 0;
			System.out.println("Please enter admin username");
			String admin_username = scanner.next();
			System.out.println("Please enter admin password");
			String admin_password = scanner.next();
			AdminValidationImpl adminValidationImpl = new AdminValidationImpl();
			adminValidationImpl.validateAdmin(admin_username, admin_password);
			break;
	
		default:
			throw new MyException("Please provide valid input. Choose 1 or 2 only");
			}	
		}
		

}
