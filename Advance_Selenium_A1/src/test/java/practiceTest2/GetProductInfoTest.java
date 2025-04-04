package practiceTest2;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.genericutility.ExcelUtility;

public class GetProductInfoTest {

	@Test(dataProvider="getData", groups="smokeTest")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
//		String productName = "Samsung Galaxy S25 5G AI Smartphone (Silver Shadow, 12GB RAM, 256GB Storage), 50MP Camera with Galaxy AI" ;
		//Search for the product program
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);
		String price = driver.findElement(By.xpath("//span[text()='"+productName+"']/ancestor::div[@class = 'puisg-col-inner']//span[@class='a-price-whole']")).getText();
		System.out.println(price);
		
		
		
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowcount("product");
		
		Object[][] objArr = new Object[rowCount][2];
		
		for(int i=0; i<rowCount; i++) {
			objArr[i][0] = eLib.getDataFromExcel("product", i+1, 0);
			objArr[i][1] = eLib.getDataFromExcel("product", i+1, 1);
			
//			objArr[1][0] = eLib.getDataFromExcel("product", i+1, 0);
		}
		
		
		
		
//		objArr[0][0] ="iphone";
//		objArr[0][1] ="Apple iPhone 15 (128 GB) - Black";
		
		
		
//		objArr[0][2] = 9989898898L;
		
//	     objArr[1][0] ="iphone";
//		objArr[1][1] ="Apple iPhone 13 (128GB) - Blue";
////		objArr[1][2] = 9989898228L;
//		
//		objArr[2][0] ="iphone";
//		objArr[2][1] ="Apple iPhone 15 (128 GB) - Black";
////		objArr[2][2] = 9982598898L;
		
		return objArr;
	}
	
}
