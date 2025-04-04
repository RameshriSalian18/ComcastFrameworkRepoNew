package hardAssert1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SftAssrt {
	

	@Test
	
	public void sftsrt() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		String title = driver.getTitle();
		SoftAssert assrt = new SoftAssert();
		assrt.assertEquals(title, "Demo Web Shop");
		
		driver.findElement(By.id("small-searchterms")).sendKeys("books");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
		String text = driver.findElement(By.xpath("//h1[text()='Search']")).getText();
		assrt.assertEquals(text, "Search");
		
		Thread.sleep(3000);
		driver.close();
		assrt.assertAll();
	}

}
