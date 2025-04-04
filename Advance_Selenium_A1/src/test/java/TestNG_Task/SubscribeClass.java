package TestNG_Task;

import org.testng.Reporter;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SubscribeClass {
	
@Test

public void SubscribeBtn() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demowebshop.tricentis.com/");
	driver.findElement(By.id("newsletter-email")).sendKeys("testqsp1234@gmail.com");
	driver.findElement(By.id("newsletter-subscribe-button")).click();
	Reporter.log("Subscribe got executed");
	Thread.sleep(5000);
	driver.close();
	
}
}
