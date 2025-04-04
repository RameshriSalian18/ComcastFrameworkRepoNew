package pactice.homepagetest;
	
//	package pactice.homepagetest;

	import java.lang.reflect.Method;
	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;

	public class HomePageReport {


		@Test
		public void homePageTest(Method mtd) {
//			System.out.println(mtd.getName()+ "Test Start");
			Reporter.log(mtd.getName() + "Test Start");
			SoftAssert assertObj = new SoftAssert();
			Reporter.log("step-1" , true);
			Reporter.log("step-2" , true);
			assertObj.assertEquals("Home", "Home");
			
			Reporter.log("step-3", true);
			Assert.assertEquals("Home-CRM", "Home-CRM");
			Reporter.log("step-4", true);
			assertObj.assertAll();
			Reporter.log(mtd.getName()+ "Test End");
		}
         
		// Reporter.log will help us to show report on web browser
		// by adding true it will also provide result in console window

		@Test
		public void verifyLogoHomePageTest(Method mtd) {
			Reporter.log(mtd.getName() + "Test Start");
		SoftAssert assertObj = new SoftAssert();
		
		Reporter.log(mtd.getName()+ "Test Start");
		Reporter.log("step-1", true);
		Reporter.log("step-2", true);
		assertObj.assertTrue(true);
		Reporter.log("step-3", true);
		Reporter.log("step-4", true);
		assertObj.assertAll();
		Reporter.log(mtd.getName()+ "Test End");
		
		
		
//		if(status) {
//			System.out.println("Logo is verified==PASS");
//		}else {
//			System.out.println("Logo is not verified==FAIL");
//			
//		}
//		driver.close();
		
	}}

	
	
	
