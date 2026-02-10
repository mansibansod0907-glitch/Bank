package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDb {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/bankdb";
		
		String user ="root";
		String pass = "Mansi@123";

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded Succesfully");
		
		Connection con = DriverManager.getConnection(url, user, pass);
		System.out.println("connection established Sucessfully");
		
		
	}

	public static Connection getConnection() {
		
		return null;
	}

}
