package com.main;

import java.sql.SQLException;

public class DriverMain {
	public static void main(String[] args) throws SQLException {
		MainCall mainCall = new MainCall();
		mainCall.getMainCall();
	}
}