package Basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExcelVtiger {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./TestData/ReadData");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		WebDriver driver = null;
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		else {
			driver = new ChromeDriver();
		}
		
		
		// Step 1: Login to App
		
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys("USERNAME");
		driver.findElement(By.name("password")).sendKeys("PASSWORD");
		driver.findElement(By.id("submitButton")).clear();
		
		//Navigate to organisation module
		
		driver.findElement(By.linkText("Organization")).click();
		
		//Step 4: Enter all the details &  create new organization
		
		

	}

}
