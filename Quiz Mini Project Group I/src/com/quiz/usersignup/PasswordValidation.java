package com.quiz.usersignup;

public class PasswordValidation {
	public void getvalidatePassword(String password) {
		final int NUM_UPPER_LETTERS = 1;
		final int NUM_LOWER_LETTERS = 1;
		final int NUM_DIGITS = 1;
		int upperCount = 0;
		int lowerCount = 0;
		int digitCount = 0;
		int letterCount = 0;
		int passwordLen = password.length();
		
		for (int i = 0; i < passwordLen; i++) {
			char ch = password.charAt(i);
			if (Character.isUpperCase(ch))
				upperCount++;
			else if (Character.isLowerCase(ch))
				lowerCount++;
			else if (Character.isDigit(ch))
				digitCount++;
		}

		if (upperCount >= NUM_UPPER_LETTERS && lowerCount >= NUM_LOWER_LETTERS && digitCount >= NUM_DIGITS) {
			
		}

		else {
			System.out.println("The Password did not have enough of the following");
			if (upperCount < NUM_UPPER_LETTERS) {
				System.out.println("UPPERCASE LETTERS MISSING");
			}
			if (lowerCount < NUM_LOWER_LETTERS) {
				System.out.println("LOWERCASE LETTER MISSING");
			}
			if (digitCount < NUM_DIGITS) {
				System.out.println("DIGITS MISSING");
			}
		}

	}
}

