package TestNG_Task;

import org.testng.Reporter;
import org.testng.annotations.Test;
import java.sql.Driver;
import java.time.Duration;

import org.checkerframework.common.util.count.report.qual.ReportCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchBoxClass {

	@Test (invocationCount = 3, threadPoolSize = 2)
	
	public void search() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.id("small-searchterms")).sendKeys("books");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Reporter.log("Search got executed");
		Thread.sleep(5000);
		driver.close();
	}
	

}
