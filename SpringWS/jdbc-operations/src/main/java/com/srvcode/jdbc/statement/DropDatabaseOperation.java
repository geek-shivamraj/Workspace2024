package com.srvcode.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropDatabaseOperation {
	public static String databaseUrl = "jdbc:mysql://localhost:3307/sampledb?user=root&password=admin";

	public static void main(String[] args) {

		String query = null;
		try (Connection con = DriverManager.getConnection(databaseUrl)) {

			Statement stmt = con.createStatement();
			query = "drop database sampledb";
			int result = stmt.executeUpdate(query);

			System.out.println("Result of the query execution: " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
