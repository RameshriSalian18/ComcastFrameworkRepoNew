package TestNgTaskPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class SampleTest 
{
public static void main(String[] args) throws InterruptedException 
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com");
	WebElement element = driver.findElement(By.name("q"));
	element.sendKeys("iphone");
	Thread.sleep(2000);
	driver.navigate().refresh();
	element.sendKeys("shoes");
	
}
}
