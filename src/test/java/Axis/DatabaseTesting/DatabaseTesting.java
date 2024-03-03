package Axis.DatabaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class DatabaseTesting {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String dbURL = "jdbc:mysql://localhost:3306/qaaxisbank";
		String username = "root";
		String password ="root";
		// Load the mysql jdbc driver file
		Class.forName("com.mysql.cj.jdbc.Driver");
		//creating the connection to the database
		Connection con = DriverManager.getConnection(dbURL,username,password);
		//creating the statement object
		java.sql.Statement st = con.createStatement();
		String selectquery = "select * from bankemployees ";
		//executing the sql query
		ResultSet rs = st.executeQuery(selectquery);
		//while lopp to iterate through all data and results
		
		while (rs.next()) {
			
			System.out.println(rs.getString("EmployeeID"));
			System.out.println(rs.getString("EmployeeName"));
		}
		}
	}