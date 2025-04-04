package com.comcast.crm.genericdatabaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility{
	Connection con;
	private ResultSet result;
	
	public void getDbconnection(String url, String username, String password) {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
	}}
	
	public void getConnection() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://locaost:3306/projects", "root" ,  "root");
		}catch(Exception e) {
	}}
	public ResultSet closeDbconnection() throws SQLException {
		
		try {
			con.close();
			
		}catch(Exception e){
		
		}
		return result;
	}
   public ResultSet executeNonSelectQuery(String query) throws Throwable {
	   ResultSet result = null; 
	   try {
		   Statement stat = con.createStatement();
		   result=stat.executeQuery(query);
	   }
	   catch(Exception e) {
		   
	   }
	   return result;
   }
   
	public int executeNonselectQuery(String query) {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			result = stat.executeUpdate(query);
		}
		catch(Exception e) {
			
		}
		return result;
	}
	
}



		

