package com.authentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.ConnectionImpl;

public class IdVerify {
	public boolean idVerify(int id) throws SQLException {
		ConnectionImpl connectionImpl = new ConnectionImpl();
		Connection con = connectionImpl.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("select userid from userdata where userid=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int userid = rs.getInt(1);
				if(id == userid) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
			ps.close();
		}
		return false;
	}
}
