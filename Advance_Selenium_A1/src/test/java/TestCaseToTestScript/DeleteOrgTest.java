package TestCaseToTestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.genericutility.ExcelUtility;
import com.comcast.crm.genericutility.FileUtility;

import comcast.crm.objectrepositoryutility.CreateNewOrganization;
import comcast.crm.objectrepositoryutility.Home;
import comcast.crm.objectrepositoryutility.LoginUtility;
import comcast.crm.objectrepositoryutility.Organization;
import comcast.crm.objectrepositoryutility.OrganizationInfo;

public class DeleteOrgTest {

	public static void main(String[] args) throws ParseException, EncryptedDocumentException, IOException {
		// read common data from Json file
//		JSONParser parser = new JSONParser();
//		Object obj = parser.parse("./TestData/Org.xlsx");
		
		//Create Object
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
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
		
		LoginUtility lu = new LoginUtility(driver);
		lu.loginToapp("admin", "admin");
		
		//Step 2:  navigate to Organization module
		Home op = new Home(driver);
		op.getOrgLink().click();
		
		
		//Step 3: Click on create organization button
		
		OrganizationInfo cnp = new OrganizationInfo(driver);
		cnp.getCreateNewOrgBtn().click();
		
		//Step 4: enter all the details & create new Organization
		CreateNewOrganization cnp1 = new CreateNewOrganization(driver);
		cnp1.getOrgNameEdt(orgName);
		
		// Verify header msg expected result
       String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
       
       if(headerInfo.contains(orgName)) {
    	   System.out.println(orgName + "is created == PASS");
       }
       
       else {
    	   System.out.println(orgName + "is not created == FAIL");
       }
    	   
    	   
		// Verify Header orgName expected result
       
        OrganizationInfo oip = new OrganizationInfo(driver);
        String actOrgName = oip.getHeaderMsg().getText();
        if(actOrgName.contains(orgName)) {
        	System.out.println(orgName + "name is verified == PASS");
        	
        }
        else {
        	System.out.println(orgName + "name is not verified == FAIL");
        }
		
        //Go back to Organizations info and 
        Home hp = new Home(driver);
        hp.getOrgLink().click();
        
        // search for organization
        Organization org = new Organization(driver);
        org.getSearchEdt().sendKeys(orgName);
        wLib.select(org.getSearchDD(), "Organization Name");
        org.getSearchBtn().click();
        driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
        
        
        // In dynamic web table select and delete org
		//step 5:
        op.logout();
		driver.quit();
		

	}
}
