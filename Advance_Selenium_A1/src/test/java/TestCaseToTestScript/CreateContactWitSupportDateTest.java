package TestCaseToTestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWitSupportDateTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
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
		Row row = sh.getRow(4);
		String lastName = row.getCell(2).toString() + randomInt;
		
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
		
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 3: Click on create organization button
		
		driver.findElement(By.xpath("//img[@title='Create Contact]")).click();
		
		//Step 4: enter all the details & create new Organization
		Date dateObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = sim.format(dateObj);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String endDate = sim.format(cal.getTime());
//		System.out.println(dateRequired);

		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		
//		driver.findElement(By.id("phone")).sendKeys(phoneNumber);
		
		
		
		
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// Verify header msg expected result
//       String headerInfo = driver.findElement(By.xpath("//span[@class='dtlvHeaderText']")).getText();
//       
//       if(headerInfo.contains(orgName)) {
//    	   System.out.println(orgName + "is created == PASS");
//       }
//       
//       else {
//    	   System.out.println(orgName + "is not created == FAIL");
//       }
    	   
    	      
    	   
		// Verify Header orgName expected result
       
       String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
       
       if(actLastName.equals(lastName)) {
    	   System.out.println(lastName + "is created == PASS");
       }
       
       else {
    	   System.out.println(lastName + "is not created == FAIL");
       }
       
       //Start Date
       String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
       
       if(actStartDate.equals(startDate)) {
    	   System.out.println(startDate + "is created == PASS");
       }
       
       else {
    	   System.out.println(startDate + "is not created == FAIL");
       }
       
       
       //End Date
       String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
       
       if(actEndDate.equals(endDate)) {
    	   System.out.println(endDate + "is created == PASS");
       }
       
       else {
    	   System.out.println(endDate + "is not created == FAIL");
       }
		
		//step 5:
		driver.quit();

	}

}
