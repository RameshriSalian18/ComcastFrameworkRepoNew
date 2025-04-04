package AdvanceSeleniumTP;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Reading Data from External resource
		
		
		//Step 1: get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("./TestData/commonDataNew.properties");
		
		// Step 2: using properties class, load all the keys
		Properties pobj = new Properties();
		pobj.load(fis);
		
		// Step 3: get the value based on key
		
		
		String property = pobj.getProperty("browser");
		System.out.println(property);
		

	}

}
