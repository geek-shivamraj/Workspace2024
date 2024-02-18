package com.srvcode.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableOperation {

	public static String databaseUrl = "jdbc:mysql://localhost:3307/sampledb?user=root&password=admin";

	public static void main(String[] args) {

		String query = null;
		try (Connection con = DriverManager.getConnection(databaseUrl)) {

			Statement stmt = con.createStatement();

			query = "create table users (first_name varchar(50), "
					+ "last_name varchar(50), email varchar(50), phone_number varchar(50))";
			
			stmt.execute(query);
			
			System.out.println("Query executed Successfully..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
