package com.authentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.connection.ConnectionImpl;

public class IdSecurity {

	public int verifyId(String username, String password) throws SQLException {
		ConnectionImpl connectionImpl = new ConnectionImpl();
		Connection con = connectionImpl.getConnection();
		PreparedStatement ps = null;
		int id = 0;
		try {
			ps = con.prepareStatement("select id from userinfo where username=? && password=?");
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			con.close();
			ps.close();
		}
		return id;
	}

}

