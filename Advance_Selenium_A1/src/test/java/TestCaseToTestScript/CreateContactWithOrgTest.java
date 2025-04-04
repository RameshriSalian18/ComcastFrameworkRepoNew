package TestCaseToTestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		WebDriverUtility wLib = new WebDriverUtility();
		FileInputStream fis = new FileInputStream("./TestData/commonDataNew.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		// generate the random number
		Random random = new Random();
		int randomInt = random.nextInt(2000);
		
		//read testscript data from excel file
		FileInputStream fis1 = new FileInputStream("./TestData/Org.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(7);
		
		String orgName = row.getCell(2).toString() + randomInt;
		String contactLastName = row.getCell(2).toString() + randomInt;
		wb.close();
		
		WebDriver driver = null;
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		//Step 1: login to App
		wLib.waitForPageToLoad(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 2:  navigate to Organization module
		
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 3: Click on create organization button
		
		driver.findElement(By.xpath("//img[@title='Create Organization]")).click();
		
		//Step 4: enter all the details & create new Organization
		driver.findElement(By.name("accountname")).sendKeys("orgName");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// Verify header msg expected result
       String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
       
       if(headerInfo.contains(orgName)) {
    	   System.out.println(orgName + "is created == PASS");
       }
       
       else {
    	   System.out.println(orgName + "is not created == FAIL");
       }
    	   
       
       //Step 5: Navigate to contact module
       
       driver.findElement(By.linkText("Contacts")).click();
		
		//Step 6: Click on create organization button
		
		driver.findElement(By.xpath("//img[@title='Create Contact]")).click();
		
		//Step 7: enter all the details & create new Organization
		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		driver.findElement(By.xpath("//input[@name='account name']/following-sibling::img")).click();
		
		
		
		//Switch to child window
		wLib.switchToTabUrl(driver, "module=Accounts");
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains("module=Accounts")) {
				break;
			}
		}
		
		
		//Switch to parent window
		wLib.switchToTabUrl(driver, "Contacts&action");
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		
//		while(it1.hasNext()) {
//			String windowID = it1.next();
//			driver.switchTo().window(windowID);
//			
//			String actUrl = driver.getCurrentUrl();
//			if(actUrl.contains("Contacts&action")) {
//				break;
//			}
//		}
		
		
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName + "']")).click();
//		driver.findElement(By.id("phone")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
   	   
   	      
   	   
		// Verify Header phone number info  expected result
      
      headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
      if(headerInfo.contains(orgName)){
    	  System.out.println(orgName + "header verified==PASS");
      }else {
    	  System.out.println(orgName + "header is not verified ==FAIL");
      }
      
      // verify header orgName info expected result
      
      String actOrgName = driver.findElement(By.id("mouseArea"
      		+ "_organization Name")).getText();
      if(actOrgName.equals(orgName)) {
    	  System.out.println(orgName + "information is created==PASS");
      }
      else {
    	  System.out.println(orgName + "information is not created==FAIL");
      }
      
      
		//step 5:
		driver.quit();
		

	}

}
