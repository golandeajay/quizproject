package com.authentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.ConnectionImpl;
import com.main.MainCall;
import com.quiz.usersignup.LoginChoice;

public class LoginSecurity {
	public boolean getLogin(String username,String password) throws SQLException {
		ConnectionImpl connectionImpl = new ConnectionImpl();
		Connection con = connectionImpl.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("select username,password from userinfo");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String user = rs.getString(1);
				String pass = rs.getString(2);
				if(username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
					return true;
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			con.close();
			ps.close();
		}
		return false;
	}
}
