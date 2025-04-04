package comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	
	WebDriver driver;
	public OrganizationInfo (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
}
