package com.jsp.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestRead {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "root";
		int n = 1;
		Connection connection = null;
		String sql = "select * from student";

		try {
			// load/register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish connection
			connection = DriverManager.getConnection(url, username, password);

			// Create statement
			Statement statement = connection.createStatement();

			// Execute statement
			ResultSet resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				System.out.println("Student Record no=" + n++);
				System.out.println(resultset.getInt(1));
				System.out.println(resultset.getString(2));
				System.out.println(resultset.getString(3));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// connection closed
		finally {
			if (connection != null) {
				connection.close();
			}

		}

	}
}
