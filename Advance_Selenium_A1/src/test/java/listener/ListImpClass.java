package listener;

import java.util.Date;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.generic.baseclassutility.BaseClassTest;

import net.bytebuddy.utility.privilege.GetMethodAction;

public class ListImpClass implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		System.out.println("Report configuration");
		String time = new Date().toString().replace("","_").replace(":","_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report" +time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		
		//Add Env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("==== " + result.getMethod().getMethodName()+ "=====Start======");
		ExtentTest test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "==Started==" );
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println("==== " + result.getMethod().getMethodName()+ "====End=======");
		ExtentTest test = null;
		test.log(Status.PASS, result.getMethod().getMethodName()+ "===Completed===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
//		TakesScreenshot tks = (TakesScreenshot) driver;
//		tks.getScreenshotAs(OutputType.FILE);
		
		TakesScreenshot eDriver = (TakesScreenshot) BaseClassTest.eDriver;
		String filepath = eDriver.getScreenshotAs(OutputType.BASE64);
//		String time = new Date().toString().replace("","_").replace(":","_");
		ExtentTest test = null;
		test.addScreenCaptureFromBase64String(filepath, testName + "_" + time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+ "===Failed===");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		ExtentTest test;
		test.log(Status.SKIP, result.getMethod().getMethodName()+ "===Test got skipped===");
	}

	
	
}
