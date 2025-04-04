package ObjectRepository.SampleTestWithoutPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class SampleTestWithPOM {

//	private static SearchContext java;

	@FindBy(name="user_name")
	WebElement ele1;

	@FindBy(name="user_password")
	WebElement ele2;

	@FindAll({@FindBy(id="submitButton"), @FindBy(xpath="//input[@value='Login']")})
	private WebElement ele3;
	
	@Test
	public void sampleTest() {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://49.249.28.218:8888/");
		
		SampleTestWithPOM s = PageFactory.initElements(driver,SampleTestWithPOM.class);
//		WebElement ele1 = driver.findElement(By.name("user_name"));
//		WebElement ele2 = driver.findElement(By.name("user_password"));
//		WebElement ele3 = driver.findElement(By.id("submitButton"));
		
		s.ele1.sendKeys("admin");
		s.ele2.sendKeys("admin");
		
		driver.navigate().refresh();
		s.ele1.sendKeys("admin");
		s.ele2.sendKeys("admin");
		s.ele3.click();
	}

	

}
