package JDBC_Tut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ProgramToExecuteNonSelectQuery {

	public static void main(String[] args) throws SQLException {
		
		// Step 1: Load/register the database driver
		
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//Step 2: Connect to database
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects" , "root" , "root");
		System.out.println("==Done==");
		
		// Step 3: Create SQL Statement
		
		Statement stat = conn.createStatement();
		
		// Step 4: Execute select Query & get result
		
		int resultset = stat.executeUpdate( "insert into project value"('Ty_proj201', 'Ram', '01/01/2025', 'FB_01', 'Ongoing'));
		
		char[] result;
		System.out.println(result);

		conn.close();
	}
	

	

}
