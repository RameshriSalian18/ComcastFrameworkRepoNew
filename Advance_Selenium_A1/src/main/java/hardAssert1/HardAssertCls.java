package hardAssert1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertCls {
	
	@Test
	public void hardassert() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Demo Web Shop");
		
		driver.findElement(By.id("small-searchterms")).sendKeys("books");
		driver.findElement(By.xpath	("//input[@value='Search']")).click();
		
		String tlt = driver.findElement(By.xpath("//h1[text()='Search']")).getText();
		Assert.assertEquals(tlt, "Search");
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
