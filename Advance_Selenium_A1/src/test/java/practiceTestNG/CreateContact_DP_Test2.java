package practiceTestNG;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test2 {

	@Test(dataProvider = "getData")
	public void CreateContact(String FirstName, String lastName, long phoneNumber) {
		System.out.println("FirstName :" + FirstName + ", LastName:" + lastName + ",phoneNumber: "+phoneNumber);
		
	}
		

		
		@DataProvider
		public Object[][] getData() {
			Object[][] objArr = new Object[3][2];
			objArr[0][0] ="Trunku";
			objArr[0][1] ="cat";
			objArr[0][2] = 9989898898L;
			
			objArr[1][0] ="Lily";
			objArr[1][1] ="meow";
			objArr[1][2] = 9989898228L;
			
			objArr[2][0] ="Chinna";
			objArr[2][1] ="babycat";
			objArr[2][2] = 9982598898L;
			
			return objArr;
		}
		
		
	}


