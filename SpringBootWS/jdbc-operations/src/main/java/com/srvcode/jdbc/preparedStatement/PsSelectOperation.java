package com.srvcode.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PsSelectOperation {

	public static String databaseUrl = "jdbc:mysql://localhost:3307/sampledb?user=root&password=admin";

	public static void main(String[] args) {

		String query = null;
		try (Connection con = DriverManager.getConnection(databaseUrl)) {

			query = "select emp_id, emp_name, designation, salary from employee_data where emp_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 103);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getString("emp_id") + "\t" + rs.getString("emp_name") + "\t"
						+ rs.getString("designation") + "\t" + rs.getDouble("salary") + "\n");
			}
			System.out.println("Query executed Successfully..");
		} catch (SQLException ex) {
			System.err.println("SQLState: " + ex.getSQLState());
			System.err.println("Errorcode: " + ex.getErrorCode());
			System.err.println("Message: " + ex.getMessage());
			System.err.println("Localized Message: " + ex.getLocalizedMessage());
			System.err.println("Cause: " + ex.getCause());
		}
	}

}
