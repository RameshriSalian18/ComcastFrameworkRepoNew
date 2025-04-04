package TestCaseToTestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganizationTest {

	public static void main(String[] args) throws ParseException, EncryptedDocumentException, IOException {
		// read common data from Json file
//		JSONParser parser = new JSONParser();
//		Object obj = parser.parse("./TestData/Org.xlsx");
		
//		JSONObject map = (JSONObject)obj;
//		
//		
//		String URL = test.getParameter("url");
//		String BROWSER = test.getParameter("browser");
//		String USERNAME = test.getParameter("username");
//		String PASSWORD = test.getParameter("password");
		
		
		//Read data from properties file
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
		
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		
		String orgName = row.getCell(2).toString() + randomInt;
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
    	   
    	      
    	   
		// Verify Header orgName expected result
       
       String actOrgName = driver.findElement(By.className("dvHeaderText")).getText();
       
       if(headerInfo.equals(orgName)) {
    	   System.out.println(orgName + "is created == PASS");
       }
       
       else {
    	   System.out.println(orgName + "is not created == FAIL");
       }
		
		//step 5:
		driver.quit();
		

	}

}
