package dataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataPackage {
	
	@DataProvider()
	public Object[][] demo() {
		Object[][] data = new Object[1][2];
		
		data [0][1] = "https://demowebshop.tricentis.com/";
		data [0][1] = "books";
		return data;
		
	}
	
	@Test(dataProvider = "demo")
	public void test(String url, String search) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		driver.findElement(By.id("small-searchterms")).sendKeys(search);
//		driver.findElement(By.id(search)).click();
		System.out.println(url);
		System.out.println(search);
	}
		
	
	
}

