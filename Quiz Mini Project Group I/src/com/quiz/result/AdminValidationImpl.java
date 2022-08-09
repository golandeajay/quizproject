package com.quiz.result;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

public class AdminValidationImpl implements AdminValidation{

	@Override
	public void validateAdmin(String username, String password) {	
			try {
				
				FileInputStream fis = new FileInputStream("C:\\.property file mi nimproject\\result.properties");
				Properties p= new Properties();
				p.load(fis);
				
				String admin_username = p.getProperty("adminusername");
				String admin_password = p.getProperty("adminpassword");
				
				if(admin_username.equals(username) && admin_password.equals(password)) {
					StudentInformationImpl studentInformationImpl = new StudentInformationImpl();
					System.out.println("1 : Single student record");
					System.out.println("2 : Multiple student record");
					Scanner scanner = new Scanner(System.in);
					int option = scanner.nextInt();
					switch(option) {
					case 1:
						System.out.println("Enter student id :");
						int id = scanner.nextInt();
						studentInformationImpl.getStudentInfo(id);	
						break;
					case 2:
						studentInformationImpl.getStudentInfo();
						break;
						default:
							System.out.println("Invalid option");
							AdminValidationImpl adminValidation = new AdminValidationImpl();
							adminValidation.validateAdmin(username, password);
				}
					
				}else if(admin_username.equals(username) && admin_password != password) {
					System.err.println("Please enter valid password.");
				
				}
				else {
					System.err.println("Please enter valid admin username and password.");
	
				}	
			}catch (Exception e) {
				e.getMessage();
			}
	}
	
}



