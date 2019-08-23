package com.greatdigitallab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/mysql_student_db?useSSL=false";
		String user = "mysqluser";
		String password = "mysqluser";
		
		try {
			
			System.out.println("Connecting to database... " + jdbcUrl);
			
			Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
			
			if(connection != null) {
				System.out.println("Connection Successful..!!");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
