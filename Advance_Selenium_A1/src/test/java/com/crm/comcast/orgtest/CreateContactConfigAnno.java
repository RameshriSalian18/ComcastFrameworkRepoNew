package com.crm.comcast.orgtest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseclassutility.BaseClassTest;

public class CreateContactConfigAnno extends BaseClassTest{
//	
//	@BeforeSuite()
//	public void configBS() {
//		System.out.println("execute BS");
//	}
//	
//	@BeforeClass()
//	public void configBC() {
//		System.out.println("execute BC");
//	}
//
//	@BeforeMethod()
//	
//	public void configBM() {
//		System.out.println("execute BM");
//	}
	
	
	@Test
	public void createContact() {
		System.out.println("execute createcontact & verify");
	}
	
	public void createContactWithDate() {
		System.out.println("execute createcontact & verify");
	}

//	@AfterMethod()
//	public void configAM() {
//		System.out.println("execute AM");
//    }
	
//	@AfterClass()
//	
//	public void configAC() {
//		System.out.println("execute AC");
//	}
	
//	@AfterSuite()
//	public void configAS() {
//		System.out.println("execute AS");
//	}
}

