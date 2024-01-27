package com.srvcode.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PsInsertOperation {

	public static String databaseUrl = "jdbc:mysql://localhost:3307/sampledb?user=root&password=admin";

	public static void main(String[] args) {

		String query = null;
		try (Connection con = DriverManager.getConnection(databaseUrl)) {

			query = "insert into employee_data (emp_id,emp_name,designation,salary) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, 101);
			ps.setString(2, "Raj");
			ps.setString(3, "Tech lead");
			ps.setDouble(4, 110000);
			ps.executeUpdate();

			ps.setInt(1, 102);
			ps.setString(2, "Maria");
			ps.setString(3, "Product Manager");
			ps.setDouble(4, 118000);
			ps.executeUpdate();

			ps.setString(1, "103");
			ps.setString(2, "Ryan");
			ps.setString(3, "Project Manager");
			ps.setString(4, "100000");
			ps.executeUpdate();

			System.out.println("Contents of the table: ");
			query = "select * from employee_data order by emp_name";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);

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
