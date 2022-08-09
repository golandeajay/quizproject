package com.quiz.usersignup;

import java.sql.SQLException;

public interface SignUpInter {
	public void insertStudentData(String firstname,String lastname,String username,String password,String emailId,String mobileNo) throws SQLException;
}
