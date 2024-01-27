package com.srvcode.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectWithOrderByOperation {

	public static String databaseUrl = "jdbc:mysql://localhost:3307/sampledb?user=root&password=admin";

	public static void main(String[] args) {

		String query = null;
		try (Connection con = DriverManager.getConnection(databaseUrl)) {

			Statement stmt = con.createStatement();
			System.out.println("Users ordered by first name: ");
			query = "select * from users order by first_name";
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
