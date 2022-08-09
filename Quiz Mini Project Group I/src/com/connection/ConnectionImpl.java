package com.connection;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionImpl implements FinalConnection {
	@Override
	public String getURL() {
		// Here We use Properties File concept
		String URL = "";
		try {
			FileReader fileReade = new FileReader(
					"C:\\.property file mi nimproject\\Connectionurl.properties");

			Properties properties = new Properties();
			properties.load(fileReade);
			URL = properties.getProperty("url");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return URL;
	}

	@Override
	public Connection getConnection() {
		Connection connection = null;
		try {
			String url = getURL();
			// step1:load Driver
//		Properties p = new Properties();
			Class.forName("com.mysql.cj.jdbc.Driver");
//	    String admin_username = p.getProperty("databaseusername");
//		String admin_password = p.getProperty("databasepassword");
			// Step 2: Establish The Connection
			connection = DriverManager.getConnection(url, "root","Ajay@1234");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
}

