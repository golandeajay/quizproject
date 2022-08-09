package com.quiz.result;

public class MyException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	String message;
	
	public MyException(String message) {
		super(message);
	}

}
