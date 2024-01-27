package com.srvcode.jdbc.resultSet.navigation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Configure a ResultSet object to allow navigation in either direction,
 * including the ability to jump to specific points.
 * 
 */
public class ResultSetNavigation {
	public static String databaseUrl = "jdbc:mysql://localhost:3307/sampledb?user=root&password=admin";
	
	public static void main(String[] args) {
		
		String query = null;
		
		try (Connection con = DriverManager.getConnection(databaseUrl)) {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			query = "select * from employee_data";
			ResultSet rs = stmt.executeQuery(query);
			System.out.println();
			
			rs.first();
			displayEmpData("first()", rs);
			System.out.println();
			
			rs.relative(3);
			displayEmpData("relative(3)", rs);
			System.out.println();
			
			rs.previous();
			displayEmpData("previous()", rs);
			System.out.println();
			
			rs.absolute(6);
			displayEmpData("absolute(6)", rs);
			System.out.println();
			
			rs.last();
			displayEmpData("last()", rs);
			System.out.println();
			
			rs.relative(-5);
			displayEmpData("relative(-5)", rs);
			System.out.println();
			
			Statement stmt1 = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs1 = stmt1.executeQuery(query);
			rs1.next();
			displayEmpData("next()", rs1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void displayEmpData(String label, ResultSet result) throws SQLException {
		
		int id = result.getInt("emp_id");
		String name = result.getString("emp_name");
		String designation = result.getString("designation");
		double salary = result.getDouble("salary");
		
		String empData = "%s: %d | %s | %s | %.2f \n";
		System.out.format(empData, label, id, name, designation, salary);
		
	}

}
