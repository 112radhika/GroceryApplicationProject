package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']") private WebElement admin;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']") private WebElement logout;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']/i[@class='fas fa-arrow-circle-right']") private WebElement adminuser;

	
	public void clickOnAdmin() {
		
		admin.click();
	}
	
	public void clickOnLogout() {
		
		logout.click();
	}
	

	public void clickOnAdminUsers() {
		
		adminuser.click();
	}
	

}
