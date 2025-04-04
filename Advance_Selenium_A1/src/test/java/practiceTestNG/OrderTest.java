package practiceTestNG;

import org.testng.annotations.Test;

public class OrderTest {
	
	@Test
	public void createOrderTest() {
		System.out.println("Execute Order Test");
	}
	
	@Test(dependsOnMethods="createOrderTest")
	public void billingOrderTest() {
		System.out.println("Execute Billing  Order Test");
	}

}
