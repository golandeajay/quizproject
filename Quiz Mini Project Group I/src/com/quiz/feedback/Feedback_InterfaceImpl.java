package com.quiz.feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.connection.ConnectionImpl;

public class Feedback_InterfaceImpl implements Feedback {

	@Override
	public void UpdateFeedback(int userid, String feedback, String rate) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		List<InsertFeedback> list = new ArrayList<InsertFeedback>();
		list.add(new InsertFeedback(userid, feedback, rate));

		try {
			ConnectionImpl conn = new ConnectionImpl();
			connection = conn.getConnection();
			preparedStatement = connection.prepareStatement("insert into feedback(userid,feedback,rate)values(?,?,?)");
			for (int j = 0; j < list.size(); j++) {
				preparedStatement.setInt(1, list.get(j).getUserid());
				preparedStatement.setString(2, list.get(j).getFeedback());
				preparedStatement.setString(3, list.get(j).getRate());
			}
			int insert = preparedStatement.executeUpdate();
			System.out.println("Done.FeedBack has been succesfully updated " + insert);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
		}
	}

	public void getUserFeedback(int uId) throws SQLException {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Please give us your valuable feedback :");
		String feedback = scanner.nextLine();

		System.out.print("Rate us out of 5:");
		String rate = scanner.nextLine();

		Feedback_InterfaceImpl feedback_InterfaceImpl = new Feedback_InterfaceImpl();
		feedback_InterfaceImpl.UpdateFeedback(uId, feedback, rate);
	}
}
