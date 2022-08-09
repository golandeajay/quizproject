package com.quiz.usersignup;

import java.sql.SQLException; 
import java.util.Scanner;

import com.main.MainCall;
import com.quiz.questionbank.GetQuestion;
import com.quiz.result.Result;
import com.quiz.result.StudentInformationImpl;

public class LoginChoice {

	public void getLoginChoice(int uId,String username,String password) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1 : Start Quiz");
		System.out.println("2 : Result");
		System.out.println("3 : Logout");
		System.out.println("Enter the choice__");
		int choice = scanner.nextInt();
	switch(choice) {	
		case 1:
			GetQuestion getQuestion = new GetQuestion();
			getQuestion.getQuizInput(username,password);
			break;
		case 2:
			StudentInformationImpl.getStudentInfo(uId);
			break;
		case 3:
			MainCall mainCall = new MainCall();
			mainCall.getMainCall();
			break;
			default:
				System.out.println("Invalide Option");
	}
			
	}
}
