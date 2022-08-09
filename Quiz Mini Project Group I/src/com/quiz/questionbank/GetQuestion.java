package com.quiz.questionbank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import com.authentication.IdSecurity;
import com.authentication.IdVerify;
import com.connection.ConnectionImpl;
import com.quiz.feedback.Feedback_InterfaceImpl;
import com.quiz.usersignup.LoginChoice;

public class GetQuestion implements ScoreUpdateInterface {
	String grade = "";
	static int count = 3;

	public void getQuizInput(String username, String password) throws SQLException {
		GetQuestion getQuestion = new GetQuestion();
		Scanner scanner3 = new Scanner(System.in);
		IdSecurity idSecurity = new IdSecurity();
		int uId = idSecurity.verifyId(username, password);
		IdVerify idVerify = new IdVerify();
		boolean b = idVerify.idVerify(uId);
		if (b == true) {
			System.err.println("Quiz is already submitted.");
			LoginChoice loginChoice = new LoginChoice();
			loginChoice.getLoginChoice(uId,username, password);
		} else {
			UserIDData userIDData = new UserIDData();
			boolean bRet = userIDData.getUserID(uId);
			if (bRet != true) {
				System.err.println("Id not found");
			} else {
				int count_correctans = 0;
				int wrong_ans = 0;
				Scanner scannerq = new Scanner(System.in);
				HashSet<QuestionData> hsh = getQuestion.getQuestion();
				int quesinx = 1;

				for (QuestionData qdata : hsh) {
					System.out.println("Q." + quesinx++ + ")" + qdata.getQuestionName());
					System.out.println("A." + qdata.getOptionA());
					System.out.println("B." + qdata.getOptionB());
					System.out.println("C." + qdata.getOptionC());
					System.out.println("D." + qdata.getOptionD());

					String CorrectAns = qdata.getCorrectAnswer();

					System.out.println("Enter Your Choice :__________");
					String userchoice = scannerq.next();

					if (CorrectAns.equalsIgnoreCase(userchoice)) {
						count_correctans++;
					} else {
						wrong_ans++;
					}
				}
				insert(uId, count_correctans, wrong_ans, count_correctans);
				System.out.println("Thank You !!!");

				if (this.grade.equals("A")) {
					System.out.println("Congratulations ! You are pass...\r Your Score is :" + count_correctans
							+ " out of 10 [Excellent !!!]");
				} else if (this.grade.equals("B")) {
					System.out.println("Congratulations ! You are pass...\r Your Score is :" + count_correctans
							+ " out of 10 [satisfactory...]");
				} else if (this.grade.equals("C")) {
					System.out.println("Congratulations ! You are pass...\r Your Score is :" + count_correctans
							+ " out of 10 [Needs Improvement...]");

				} else {
					System.out.println("Opps ! You are Fail...\r Your Score is :" + count_correctans
							+ " out of 10 [Needs To Much Study...]");
				}
				Feedback_InterfaceImpl feed = new Feedback_InterfaceImpl();
				feed.getUserFeedback(uId);
			}
		}
	}

	public HashSet<QuestionData> getQuestion() throws SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashSet<QuestionData> hashset = new HashSet<QuestionData>();
		try {
			QuestionData questiondata = null;
			ConnectionImpl ci = new ConnectionImpl();
			connection = ci.getConnection();
			pstmt = connection.prepareStatement("select * from questions order by rand() limit 10");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int quesID = rs.getInt("Qid");

				String question = rs.getString("QuestionName");

				String opa = rs.getString("OptionA");
				String opb = rs.getString("OptionB");
				String opc = rs.getString("OptionC");
				String opd = rs.getString("OptionD");
				String correctans = rs.getString("correctAnswer");

				hashset.add(new QuestionData(quesID, question, opa, opb, opc, opd, correctans));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			connection.close();
			pstmt.close();
			rs.close();
		}

		return hashset;
	}

	public static String getGrade(int score) {
		String grade = "";

		if (score > 8 & score <= 10) {
			grade = "A";
		} else if (score >= 6 & score < 8) {
			grade = "B";
		} else if (score == 5) {
			grade = "C";
		} else if (score < 5) {
			grade = "D";
		}

		return grade;
	}

	@Override
	public void insert(int userid, int correctans_C, int wrongans_c, int score) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		this.grade = getGrade(score);
		List<UserData> list = new ArrayList<UserData>();

		list.add(new UserData(userid, Integer.toString(correctans_C), Integer.toString(wrongans_c),
				Integer.toString(score), grade));
		try {
			ConnectionImpl ci = new ConnectionImpl();
			connection = ci.getConnection();

			preparedStatement = connection.prepareStatement(
					"INSERT INTO userdata(userid,  correctanswer, wronganswer, score, grade) VALUES (?,?,?,?,?) ");
			for (int i = 0; i < list.size(); i++) {
				preparedStatement.setInt(1, list.get(i).getUserid());
				preparedStatement.setString(2, list.get(i).getCorrectanswer());
				preparedStatement.setString(3, list.get(i).getWronganswer());
				preparedStatement.setString(4, list.get(i).getScore());
				preparedStatement.setString(5, list.get(i).getGrade());
			}

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			connection.close();
			preparedStatement.close();
		}

	}
}
