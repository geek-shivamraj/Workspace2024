package com.srvcode.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertOperation {

	public static String databaseUrl = "jdbc:mysql://localhost:3307/sampledb?user=root&password=admin";

	public static void main(String[] args) {

		String query = null;
		try (Connection con = DriverManager.getConnection(databaseUrl)) {

			Statement stmt = con.createStatement();

			// query = "insert into users values('Naomi', 'Miller',
			// 'naomi_miller@hotmail.com', '555-991-8021');";

			query = "insert into users (first_name, last_name, email) "
					+ "values('Julio', 'Chavez', 'chavezj317@gmail.com'),"
					+ " ('Zack', 'Harken', 'Zack_harken@hotmail.com')";

			int result = stmt.executeUpdate(query);

			System.out.println("Query executed Successfully..! Returned value is : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
