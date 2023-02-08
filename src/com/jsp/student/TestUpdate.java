package com.jsp.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String password = "root";
		String username = "root";
		Connection connection = null;
		String sql = "update student set name='kajalgupta' where id=1";
		try {
			// load/register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish the connection
			connection = DriverManager.getConnection(url, username, password);

			// create statement
			Statement statement = connection.createStatement();

			// Execute statement
			int res = statement.executeUpdate(sql);
			if (res > 0) {
				System.out.println("updated");
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
