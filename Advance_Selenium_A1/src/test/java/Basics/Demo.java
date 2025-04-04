package Basics;

import org.testng.annotations.Test;

public class Demo {
private static final boolean False = false;
//	TestNG always follows alphabetic order 
	
	@Test
	public void Lilly() {
		System.out.println("Lilly got executed");
		
	}
	
	@Test
	public void Kookku() {
		System.out.println("Kookku got executed");
	}
	@Test (enabled = False)
	public void Trunku() {
		System.out.println("Trunku got executed");
	}

}
