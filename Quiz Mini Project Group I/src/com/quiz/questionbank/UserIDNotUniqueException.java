package com.quiz.questionbank;

public class UserIDNotUniqueException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserIDNotUniqueException(String msg)
	{
		super(msg);
	}

}
