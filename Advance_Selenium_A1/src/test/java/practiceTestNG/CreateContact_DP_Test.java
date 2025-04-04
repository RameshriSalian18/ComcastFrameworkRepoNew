package practiceTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {

	@Test(dataProvider = "getData")
	public void CreateContact(String firstName, String lastName) {
		System.out.println("FirstName :" + firstName + ", LastName:" + lastName);
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[3][2];
		objArr[0][0] ="Trunku";
		objArr[0][1] ="cat";
		
		objArr[1][0] ="Lily";
		objArr[1][1] ="meow";
		
		objArr[2][0] ="Chinna";
		objArr[2][1] ="babycat";
		
		return objArr;
	}
	
	
}
