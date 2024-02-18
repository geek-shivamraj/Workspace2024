package com.srvcode.jdbc.resultSet.navigation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetFeatures {
	public static String databaseUrl = "jdbc:mysql://localhost:3307/sampledb?user=root&password=admin";

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(databaseUrl)) {

			DatabaseMetaData metadata = con.getMetaData();
			System.out.println("-- ResultSet Properties -- \n");
			System.out.println(
					"Supports TYPE_FORWARD_ONLY: " + metadata.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
			System.out.println("Supports TYPE_SCROLL_INSENSITIVE: "
					+ metadata.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
			System.out.println("Supports TYPE_SCROLL_SENSITIVE: "
					+ metadata.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));

			System.out.println("\n\n-- ResultSet Concurrency --\n");
			System.out.println(
					"Supports CONCUR_READ_ONLY: " + metadata.supportsResultSetType(ResultSet.CONCUR_READ_ONLY));
			System.out.println(
					"Supports CONCUR_UPDATABLE: " + metadata.supportsResultSetType(ResultSet.CONCUR_UPDATABLE));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
