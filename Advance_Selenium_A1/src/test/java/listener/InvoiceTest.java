package listener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClassTest;
 @Listeners(listener.ListImpClass.class)
public class InvoiceTest extends BaseClassTest {

	@Test
	public void createInvoiceTest()  {
		System.out.println("execute createInvoiceTest");
		String var = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
//		System.out.println(var);
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
	@Test
	public void createInvoicewithContactTest() {
		System.out.println("execute createInvoicewithContactTest");
		System.out.println("execute createInvoicewithContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
