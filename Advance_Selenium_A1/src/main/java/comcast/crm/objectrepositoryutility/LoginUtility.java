package comcast.crm.objectrepositoryutility;

import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

//Rule 1 -  Create a seprate java class
//Rule 2 -  Object Creation

public class LoginUtility extends WebDriverUtility {
	WebDriver driver;
	
	public LoginUtility(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	
	//Rule 3 - Object Initialization
	
	//Rule 4 - Object Encapsulation
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Rule 5: Provide Action
	
	/** login to application based username, password, url arguements
	 * @param url
	 * @param username
	 * @password
	 *  **/
	
	public void loginToapp(String username , String password) {
		waitForPageToLoad(driver);
//		driver.get(URL);
   		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
}
