package com.srvcode.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteOperation {

	public static String databaseUrl = "jdbc:mysql://localhost:3307/sampledb?user=root&password=admin";

	public static void main(String[] args) {

		String query = null;
		try (Connection con = DriverManager.getConnection(databaseUrl)) {

			Statement stmt = con.createStatement();

			query = "delete from users where phone_number is NULL";

			int result = stmt.executeUpdate(query);

			System.out.println("Query executed Successfully..! No. of deleted rows: " + result);
			
			System.out.println("User still remaining in the table: ");
			query = "select * from users";
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				System.out.print(rs.getString("first_name"));
				System.out.print("\t" + rs.getString("last_name"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
