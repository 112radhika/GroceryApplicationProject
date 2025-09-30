package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']") private WebElement admin;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']") private WebElement logout;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']/i[@class='fas fa-arrow-circle-right']") private WebElement adminuser;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") private WebElement managenews;
	
	public HomePage clickOnAdmin() {
		
		admin.click();
		return this;
	}
	
	public LoginPage clickOnLogout() {
		
		logout.click();
		return new LoginPage(driver);
	}
	

	public AdminUserPage clickOnAdminUsers() {
		
		adminuser.click();
		return new AdminUserPage(driver);
	}
	
	public ManageNewsPage clickOnManageNews() {
		
		WaitUtility wait = new WaitUtility();
		wait.waitUntilElementToBeClickable(driver,managenews);
		managenews.click();
		return new ManageNewsPage(driver);
	}

}
