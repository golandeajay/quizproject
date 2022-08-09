package com.quiz.result;

import java.util.List;

import com.connection.ConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class StudentInformationImpl implements StudentInformation {
	Connection connection = null;
	PreparedStatement ps = null;
	public void getStudentInfo() {
		ConnectionImpl connectionImpl = new ConnectionImpl();
		Connection connection = connectionImpl.getConnection();
		ArrayList<Student> arrayList = new ArrayList<Student>();

		try {
			PreparedStatement ps = connection.prepareStatement("Select userinfo.id,firstname,lastname, "
					+ "userdata.score,grade from userinfo " + "INNER JOIN userdata on userinfo.id = userdata.userid;");

			ResultSet rs = ps.executeQuery();

			System.out.println("-------------------------------------------------------");
			System.out.printf("%10s %10s %10s %7s %10s", "STUDENT ID", "FIRSTNAME", "LASTNAME ", "SCORE", "GRADE");
			System.out.println();
			System.out.println("-------------------------------------------------------");

			while (rs.next()) {
				arrayList.add(
						new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}

			Collections.sort(arrayList);

			for (Student student : arrayList) {
				{
					System.out.format("%-13s %-10s %-10s %3s %7s", student.getId(), student.getFirstname(),
							student.getLastname(), student.getScore(), student.getGrade());
					System.out.println();
				}
			}
		} catch (Exception e) {
			throw new MyException("Please provide valid input.");
		}
	}

	public static void getStudentInfo(int userId) {
		try {
			ConnectionImpl ci = new ConnectionImpl();
			Connection connection = ci.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("Select userinfo.id,firstname,lastname, " + "userdata.score,grade from userinfo "
							+ "INNER JOIN userdata on userinfo.id = userdata.userid" + " where userdata.userid = ?");
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			System.out.println("-------------------------------------------------------");
			System.out.printf("%10s %10s %10s %7s %10s", "STUDENT ID", "FIRSTNAME", "LASTNAME ", "SCORE", "GRADE");
			System.out.println();
			System.out.println("-------------------------------------------------------");

			while (rs.next()) {
				List<Student> arrayList = new ArrayList<Student>();

				arrayList.add(
						new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));

				for (Student student : arrayList) {
					{
						System.out.format("%-13s %-10s %-10s %3s %7s", student.getId(), student.getFirstname(),
								student.getLastname(), student.getScore(), student.getGrade());
						System.out.println();
					}
				}
			}
		} catch (Exception e) {
			throw new MyException("Invalid Id. Please Enter Valid Id. ");
		}
	}
}
