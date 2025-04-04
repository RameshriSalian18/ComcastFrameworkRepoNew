package pactice.homepagetest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class HomePageSampleTest {

	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName()+ "Test Start");
		SoftAssert assertObj = new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		assertObj.assertEquals("Home", "Home");
		
		System.out.println("step-3");
		Assert.assertEquals("Home-CRM", "Home-CRM");
		System.out.println("step-4");
		assertObj.assertAll();
		System.out.println(mtd.getName()+ "Test End");
	}


	@Test
	public void verifyLogoHomePageTest(Method mtd) {
	System.out.print(mtd.getName() + "Test Start");
	SoftAssert assertObj = new SoftAssert();
	
	System.out.println(mtd.getName()+ "Test Start");
	System.out.println("step-1");
	System.out.println("step-2");
	assertObj.assertTrue(true);
	System.out.println("step-3");
	System.out.println("step-4");
	assertObj.assertAll();
	System.out.println(mtd.getName()+ "Test End");
	
	
	
//	if(status) {
//		System.out.println("Logo is verified==PASS");
//	}else {
//		System.out.println("Logo is not verified==FAIL");
//		
//	}
//	driver.close();
	
}}
