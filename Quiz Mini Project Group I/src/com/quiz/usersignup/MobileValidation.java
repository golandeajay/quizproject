package com.quiz.usersignup;

public class MobileValidation {
	public void  getMobileNoValidation (String mobileNo) {
		{
			
			if (mobileNo.matches("[0-9]{3}[0-9]{3}[0-9]{4}")){

		
				
			}else {
				System.err.println("Mobile Number is Invalid Please Provide 10 Digit Mobile Number");}
		
	
		}
		
	}
}

