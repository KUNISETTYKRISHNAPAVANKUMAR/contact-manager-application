package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String usernameString="root";
	private static String passwordString="Abcdeabcd@2000";
	private static String urlString="jdbc:mysql://localhost:3306/contact_manager";
	
	public static Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(urlString,usernameString,passwordString);
			
		} catch (SQLException e) {
			System.out.println("Sql execption occurred at DBConnection");
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class not found execption occurred at DBConnection");
			e.printStackTrace();
		}
		return null;
	}
}