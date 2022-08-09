package com.authentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.ConnectionImpl;

public class UsernameValidation {
	public boolean getUsernameValidate(String username) throws SQLException {
		ConnectionImpl connectionImpl = new ConnectionImpl();
		Connection con = connectionImpl.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("select username from userinfo");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String user = rs.getString(1);
				if(username.equals(user)) {
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			con.close();
			ps.close();
		}
		return true;
	}
}
