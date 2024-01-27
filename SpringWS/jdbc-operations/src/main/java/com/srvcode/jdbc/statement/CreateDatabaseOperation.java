package com.srvcode.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabaseOperation {
	public static String databaseUrl = "jdbc:mysql://localhost:3307?user=root&password=admin";

	public static void main(String[] args) {

		String query = null;
		try (Connection con = DriverManager.getConnection(databaseUrl)) {

			Statement stmt = con.createStatement();
			query = "create database sampledb";
			boolean result = stmt.execute(query);

			System.out.println("Query executed successfully! Result is: " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
