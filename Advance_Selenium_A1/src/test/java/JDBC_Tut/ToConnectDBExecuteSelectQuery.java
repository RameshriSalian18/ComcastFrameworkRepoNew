package JDBC_Tut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class ToConnectDBExecuteSelectQuery {

	public static void main(String[] args) throws SQLException {
		
		//Step 1: load/register the database driver
		
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//Step 2: Connect to DB
		
		Connection conn = DriverManager.getConnection("URL of JDBC");
		System.out.println("===Done===");
		
		//Step 3: Create SQL Statement
		
		Statement stat = conn.createStatement();
		
		// Step 4: Execute select query & get result
		
		Resultset resultset = (Resultset) stat.executeQuery("select *fromproject");
		
		while(((ResultSet) resultset).next()) {
			System.out.println(((Object) resultset).toString());
		}
		
		conn.close();

	}

}
