package com.citi.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private static String server="jdbc:postgresql://localhost:5432/CyDB";
//	Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CyDB", "postgres", "123456");
//
//	Statement s = conn.createStatement();
//
//	ResultSet rs = s.executeQuery("SELECT count(*) FROM company where age>25");

	public static int getQueryCount(String username, String password, String query) throws SQLException
	{
		Connection conn = DriverManager.getConnection(DBUtils.server, username, password);

		Statement s = conn.createStatement();

		ResultSet rs = s.executeQuery(query);
		rs.next();
		
		return Integer.parseInt(rs.getString(1));
	}
}
