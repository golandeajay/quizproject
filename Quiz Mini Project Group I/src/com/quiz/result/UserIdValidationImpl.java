
package com.quiz.result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.ConnectionImpl;

public class UserIdValidationImpl implements UserIdValidation{
	
	public void validateId(int userId){
		
		ConnectionImpl connectionImpl = new ConnectionImpl();
		Connection connection = connectionImpl.getConnection();
		
			try {
				PreparedStatement ps = connection.prepareStatement("Select * from userinfo where id=?");
				ps.setInt(1, userId);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()){
					if(userId == rs.getInt(1)) {
						StudentInformationImpl.getStudentInfo(userId);
						}
				}else {
					System.err.println("ID does not exist!! Please enter valid ID. ");
				}
	
			}catch (SQLException e) {
				throw new MyException("Please provide valid information.");
			}
	}

}
