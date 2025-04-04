package pactice.homepagetest;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.Test;

public class SampleTestForScreenshot {

	@Test
	public void amazonTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
		
		//step 1 - create an object to event firing web driver
		
//		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		
		TakesScreenshot edriver = (TakesScreenshot) driver;
	    edriver.getScreenshotAs(OutputType.FILE);
	    File src = edriver.getScreenshotAs(OutputType.FILE);
	}
}
