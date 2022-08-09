package com.quiz.usersignup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.ConnectionImpl;

public class LastId {
	public int getLastId() throws SQLException {
		ConnectionImpl connectionImpl = new ConnectionImpl();
		Connection con = connectionImpl.getConnection();
		PreparedStatement ps = null;
		int lastId = 0;
		try { 
			ps = con.prepareStatement("SELECT id FROM userinfo ORDER BY id DESC LIMIT 1;");
			ResultSet rsid = ps.executeQuery();
			while(rsid.next()) {
			lastId = rsid.getInt(1);
			 } 
		 }catch(Exception e) {
			 System.out.println(e);
		 }finally {
			 ps.close();
			 con.close();
		 }
		 return lastId;
	 }
}

