package com.srvcode.jdbc.dataSource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCDataSourceDemo {

	public static DataSource getMySQLDataSource() {
		MysqlDataSource mysqlDS = null;

		try {
			mysqlDS = new MysqlDataSource();
			mysqlDS.setUrl("jdbc:mysql://localhost:3307");
			mysqlDS.setUser("root");
			mysqlDS.setPassword("admin");
		}catch(Exception e) { e.printStackTrace(); }
		return mysqlDS;
	}

	public static void main(String[] args) {

		try(Connection con = getMySQLDataSource().getConnection()) {
			if (con != null) {
				System.out.println("The connection has been succesfully established!");
			}
		} catch (SQLException e) {
			System.out.println("A connection error has occured");
			e.printStackTrace();
		}
	}

}
