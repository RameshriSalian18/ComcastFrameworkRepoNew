package Helper_Attributes;

import org.testng.annotations.Test;

public class DependsOnMethods {
	
	@Test (dependsOnMethods = "Register" )
	public void Login() {
		System.out.println("Login got executed");
	}

	@Test 
	public void Register() {
		System.out.println("Register got executed");
	}
}
