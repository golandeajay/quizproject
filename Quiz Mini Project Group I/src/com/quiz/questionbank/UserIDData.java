package com.quiz.questionbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionImpl;

public class UserIDData {

	int value;

	public boolean getUserID(int userid) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			ConnectionImpl ci = new ConnectionImpl();
			connection = ci.getConnection();
			preparedstatement = connection
					.prepareStatement("select ifnull((select id from userinfo where id=? limit 1),'0')");
			preparedstatement.setInt(1, userid);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				this.value = resultset.getInt(1);
			}
			UserIDData userIDData = new UserIDData();
			List<Integer> userlist = userIDData.getlist(this.value);
			if (userid == this.value) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedstatement.close();
			resultset.close();
		}
		return false;
	}

	public List<Integer> getlist(int id) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(id);
		return list;
	}

}
