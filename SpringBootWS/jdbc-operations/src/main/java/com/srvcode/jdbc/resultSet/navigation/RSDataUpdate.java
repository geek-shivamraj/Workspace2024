package com.srvcode.jdbc.resultSet.navigation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Updating Data while Navigating a ResultSet
 */
public class RSDataUpdate {
	public static String databaseUrl = "jdbc:mysql://localhost:3307/sampledb?user=root&password=admin";
	
	public static void main(String[] args) {
		
		String query = null;
		
		try (Connection con = DriverManager.getConnection(databaseUrl)) {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			query = "select * from employee_data";
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			displayEmpData("next()", rs);
			
			Thread.sleep(12000);
			/*
			 * While we wait for 12 sec, and change data in db, 
			 * the cursor will pick the changed data. becoz of refreshRow()
			 */
			rs.last();
			rs.refreshRow(); // update will be done on fly
			displayEmpData("last()", rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
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
