package JDBC_Tut;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Sample_Test {

	public static void main(String[] args) throws SQLException {
		
		// Step 1: load /  register the database driver
		   Driver driverref = new Driver();
		   DriverManager.registerDriver(driverref);
		    
		// Step 2 : Connect to database
		    DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "", "");
		    

	}

}
