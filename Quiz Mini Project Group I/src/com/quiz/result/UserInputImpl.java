package com.quiz.result;
import java.util.Scanner;
public class UserInputImpl extends StudentInformationImpl implements UserInput {
	
		@Override
		public void getInput() {
			System.out.println("Welcome!! View Result");
			System.out.println(" 1. Single Student Record");
			System.out.println(" 2. All Student Record");
			System.out.println("Choose your option ___");
			Scanner scanner = new Scanner(System.in);		
			String option = scanner.next();
			try {
				InputValidationImpl inputValidation = new InputValidationImpl();
				inputValidation.validateInput(option);
			} catch (Exception e) {
				throw new MyException("Please provide valid input.");
			}		
	}

}

