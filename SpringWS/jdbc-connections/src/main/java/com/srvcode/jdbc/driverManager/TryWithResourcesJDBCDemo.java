package com.srvcode.jdbc.driverManager;

import java.sql.Connection;
import java.sql.SQLException;

public class TryWithResourcesJDBCDemo {

	public static void main(String[] args) {
		
		try (Connection con = MySqlJDBCUtil.getConnection()) {
			
			if(con != null) {
				System.out.println("The connection has been successfully established");
			}
			
		} catch (SQLException e) {
			System.out.println("A connection error has occured");
			e.printStackTrace();
		}
	}

}
