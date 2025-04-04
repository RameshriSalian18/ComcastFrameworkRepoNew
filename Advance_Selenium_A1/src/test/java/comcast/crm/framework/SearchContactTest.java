package comcast.crm.framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import comcast.crm.objectrepositoryutility.LoginUtility;

/** Test class for contact module
 * 
 * @author Rameshri
 */

public class SearchContactTest {

	private static final WebDriver WebDriver = null;

	@Test
	public void searchcontactTest() {
		LoginUtility lp = new LoginUtility(WebDriver); 
	}
	
	
}
