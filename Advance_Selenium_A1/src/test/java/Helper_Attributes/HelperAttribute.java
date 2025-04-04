package Helper_Attributes;

import org.testng.annotations.Test;

public class HelperAttribute {

	@Test (priority = 2)
	public void Lilly() {
		System.out.println("Lilly got executed");
		
	}
	
	@Test
	public void Kookku() {
		System.out.println("Kookku got executed");
		
	}
	
	@Test
	public void Trunku() {
		System.out.println("Trunku got executed");
		
	}
	
}
