package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.genericdatabaseutility.DataBaseUtility;
import com.comcast.crm.genericutility.FileUtility;

import comcast.crm.objectrepositoryutility.Home;
import comcast.crm.objectrepositoryutility.LoginUtility;

public class BaseClassTest {

	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriver driver = null;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	@BeforeSuite()
	public void configBS() {
		System.out.println("== Connect to DB, Report config");
		dbLib.getConnection();	
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		
		//Add Env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
		
	
	
	}
	
	@AfterSuite()
	public void configAS() throws SQLException {
		System.out.println(" Close DB");
		dbLib.closeDbconnection();
		report.flush();
	}
	
	@BeforeClass()
	public void configBC() throws IOException {
		System.out.println("launc browser");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		
		
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}
	
    @AfterClass()
	
	public void configAC() {
		System.out.println("Close browser");
		driver.quit();
	}
    
    @BeforeMethod()
	
	public void configBM() throws IOException {
		System.out.println("Login");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		LoginUtility lp = new LoginUtility(driver);
		lp.loginToapp(URL, USERNAME);
	}

    @AfterMethod()
    public void configAM() {
	System.out.println("logout");
	Home hp = new Home(driver);
	hp.logout();
}
}
