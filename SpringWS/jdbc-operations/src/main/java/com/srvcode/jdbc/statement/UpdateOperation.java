package com.srvcode.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateOperation {

	public static String databaseUrl = "jdbc:mysql://localhost:3307/sampledb?user=root&password=admin";

	public static void main(String[] args) {

		String query = null;
		try (Connection con = DriverManager.getConnection(databaseUrl)) {

			Statement stmt = con.createStatement();

			query = "update users set phone_number = '555-923-5271' where last_name = 'Harken'";

			int result = stmt.executeUpdate(query);

			System.out.println("Query executed Successfully..! Returned value is : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
