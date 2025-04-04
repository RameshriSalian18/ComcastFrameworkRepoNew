package com.crm.comcast.orgtest;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.generic.baseclassutility.BaseClassTest;

import comcast.crm.objectrepositoryutility.Home;
import comcast.crm.objectrepositoryutility.Organization;
import comcast.crm.objectrepositoryutility.OrganizationInfo;
import junit.framework.Assert;

public class CreateOrganizationTestNew extends BaseClassTest {

	@Test(groups="smokeTest")
	public void createOrgTest() {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		
		//Read testScript data from Excel file..
		String orgName = FinanceLib.getDataFromExcel("org", 1,2) + jLib.getRandomNumber();
		
		//Step 2: Navigate to Organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		WebDriver driver;
		Home hp = new Home(driver);
		hp.getOrgLink().click();
		
		//Step 3: Click on "create organization" button
		UtilityClassObject.getTest().log(Status.INFO, "create new org");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		
		//Step 4: enter all the deatils & create new organization
	
		UtilityClassObject.getTest().log(Status.INFO, orgName + "===Create a new Org");
		
		//Verify header msg expected result
		
		OrganizationInfo oip = new OrganizationInfo(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(actOrgName));
	}
	
	@Test(groups="regressionTest")
	public void createOrgWithPhoneNumber() {
		
		//read testscript data from excel file
		UtilityClassObject.getTest().log(Status.INFO, read data from excel);
		String orgName = eLib.getDataFromExcel("org",7,2) + jLib,getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org",7,3);
		
		//step 2: navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "create a new org");
		Home hp = new Home(driver);
		hp.getOrgLink().click();
		
		//step 3: click on "create organization " button
		
		Organization cnp = new Organization(driver);
		cnp.getCreateNewOrgBtn().click();
		
		//step 4: enter all the deatils & create new organization
		UtilityClassObject.getTest().log(Status.INFO, "create a new org with phone number");
		CreateingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrgPhoneNumber(orgName, phoneNumber);
		
		//verify header phone number info expected result
		
		UtilityClassObject.getTest().log(Status.INFO, "verifiy phone number");
		OrganizationInfo cnop = new OrganizationInfo(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(actOrgName));
		String actPhoneNumber = oip.getPhoneNumberInfo().getText();
		Assert.assertEquals(actPhoneNumber, phoneNumber);
		UtilityClassObject.getTest().log(Status.PASS, actPhoneNumber + "===verify the phone number");
	}
	
	@Test(groups="regressionTest")
	public void createOrgWithIndustriesTest() {
		//read testscript data from excel file
		UtilityClassObject.getTest().log(Status.INFO, "READ DATA FROM EXCEL");
		String orgName = eLib.getDataFromExcel("org",4,2)+ jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4,4);
		
		//step 2: navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "create a new org");
		Home hp = new Home(driver);
		hp.getOrgLink().click();
		
		//step 3: click on "create organization" button
		Organization cnp =new Organization(driver);
		cnp.getCreateNewOrgBtn().click();
	}
}
