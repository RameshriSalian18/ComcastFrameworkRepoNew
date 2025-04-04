package practiceTest2;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	
	ExtentReports report;
	@BeforeSuite
	public void configBS() {
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
	@AfterSuite
	public void configAS() {
		report.flush();
	}

	@Test
	public void createContactTest() {
		//Spark report config
//		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
//		spark.config().setDocumentTitle("CRM Test Suite Results");
//		spark.config().setReportName("CRM Report");
//		spark.config().setTheme(Theme.DARK);
//		
//		
//		//Add Env information and create test
//		ExtentReports report = new ExtentReports();
//		report.attachReporter(spark);
//		report.setSystemInfo("OS", "Windows-10");
//		report.setSystemInfo("BROWSER", "CHROME-100");
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://49.249.28.218:8888/");
		TakesScreenshot tks = (TakesScreenshot) driver;
		String filepath = tks.getScreenshotAs(OutputType.BASE64);
		
		
		
		
		ExtentTest test = report.createTest("createContactTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO ,"create contact");
		
//		System.out.println("Login to app");
//		System.out.println("Navigate to contact page");
//		System.out.println("create contact");
		if("HDF1C".equals("HDFC")) {
			test.log(Status.PASS, "contact is created ==  PASS");
		}else {
//			test.log(Status.FAIL, "contact is not created");
			test.addScreenCaptureFromBase64String(filepath, "errorfile");
		}
		
		//Taking back up by using flush()
//		report.flush();
		System.out.println("Login to app");
	}
	
	@Test
	public void createContactWitORG() {
		ExtentTest test = report.createTest("createContactWitORG");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO ,"create contact");
		
//		System.out.println("Login to app");
//		System.out.println("Navigate to contact page");
//		System.out.println("create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created ==  PASS");
		}else {
			test.log(Status.FAIL, "contact is not created");
		}
		
		//Taking back up by using flush()
//		report.flush();
	}
	
	@Test
	public void createContactWithPhoneNumber() {
		ExtentTest test = report.createTest("createContactWithPhoneNumber");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO ,"create contact");
		
//		System.out.println("Login to app");
//		System.out.println("Navigate to contact page");
//		System.out.println("create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created ==  PASS");
		}else {
			test.log(Status.FAIL, "contact is not created");
		}
		
		//Taking back up by using flush()
//		report.flush();
	}
}
