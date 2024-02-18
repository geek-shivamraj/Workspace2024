package com.srvcode.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementObjectDemo {
	public static String databaseUrl = "jdbc:mysql://localhost:3307/sampledb?user=root&password=admin";

	public static void main(String[] args) {
		String query = null;
		try (Connection con = DriverManager.getConnection(databaseUrl)) {
			Statement statement = con.createStatement();
			query = "insert into employee_data(emp_id, emp_name, designation, salary) "
					+ "values(101,'Alan', 'Java Developer', 87000), "
					+ "(102, 'Claudia', 'Senior software engineer', 102000)";
			
			int updatedRows = statement.executeUpdate(query);
			
			System.out.println("Query executed successfully. Row updated: " + updatedRows);

			System.out.println("Contents of the table: ");
			query = "select * from employee_data order by emp_name";
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				System.out.print(rs.getString("emp_name") + "\t" + rs.getString("designation") + "\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
