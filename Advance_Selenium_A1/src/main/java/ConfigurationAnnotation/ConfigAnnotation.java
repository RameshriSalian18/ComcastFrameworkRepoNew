package ConfigurationAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConfigAnnotation {
	
	@Test
	
	@BeforeSuite 
	public void BS() {
		System.out.println("Connected to DB");
	}
	
	@BeforeTest
		public void BT() {
			System.out.println("Before Testing");
		}
	
	@BeforeClass
	public void BC() {
		System.out.println("Before class");
	}
	
	@BeforeMethod
	public void BM() {
		System.out.println("Before Method");
	}
	
	@Test
	public void test() {
		System.out.println("Test case executed");
	}
	
	@AfterMethod
	public void AM() {
		System.out.println("AM executed");
	}
	
	@AfterClass
	public void AC() {
		System.out.println("AC executed");
	}
	
	@AfterTest
	public void AT() {
		System.out.println("AT executed");
	}
	
	@AfterSuite
	public void AS() {
		System.out.println("AS executed");
	}
	
	
	}


