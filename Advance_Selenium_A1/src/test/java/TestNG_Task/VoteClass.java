package TestNG_Task;

import org.testng.Reporter;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VoteClass {

	@Test
	
	public void VoteMthd() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.id("pollanswers-1")).click();
		driver.findElement(By.id("vote-poll-1")).click();
		Reporter.log("Search got executed");
		Thread.sleep(5000);
		driver.close();
	}
}
