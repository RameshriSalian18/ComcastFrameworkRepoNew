package com.crm.generic.baseclassutility;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassTest {

	public static TakesScreenshot eDriver;

	@BeforeSuite()
	public void configBS() {
		System.out.println("== Connect to DB, Report config");
	}
	
	@AfterSuite()
	public void configAS() {
		System.out.println(" Close DB");
	}
	
	@BeforeClass()
	public void configBC() {
		System.out.println("launc browser");
	}
	
    @AfterClass()
	
	public void configAC() {
		System.out.println("Close browser");
	}
    
    @BeforeMethod()
	
	public void configBM() {
		System.out.println("Login");
	}

    @AfterMethod()
    public void configAM() {
	System.out.println("logout");
}
}
