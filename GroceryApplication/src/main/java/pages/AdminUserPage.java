package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	
	public WebDriver driver;
	
	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") private WebElement newbutton;
	@FindBy(id="username") private WebElement newusername;
	@FindBy(id="password") private WebElement newpassword;
	@FindBy(id="user_type") private WebElement newusertype;
	@FindBy(name="Create") private WebElement newsave;
	@FindBy(xpath="//a[@onclick='click_button(2)']") private WebElement searchbutton;
	@FindBy(id="un") private WebElement searchusername;
	@FindBy(id="ut") private WebElement searchusertype;
	@FindBy(name="Search") private WebElement searchsubmit;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='btn btn-rounded btn-warning']") private WebElement resetbutton;
	
		
	public void clickOnNewButton() {
		newbutton.click();
	}
	
	public void enterUsernameForNewUser(String newUsername) {
		newusername.sendKeys(newUsername);
	}
	
	public void enterPasswordForNewUser(String newPassword) {
		newpassword.sendKeys(newPassword);
	}
	
	public void selectUserTypeForNewUser() {
		Select select = new Select(newusertype);
		select.selectByValue("staff");
	}
	
	public void clickOnSaveNewUser() {
		newsave.click();
	}
	
	public void clickOnSearch() {
		
		searchbutton.click();
	}
	
	public void enterUsernameOnSearch(String searchUsername) {
		
		searchusername.sendKeys(searchUsername);
		
	}
	
	public void clickOnSearchSubmit() {
		
		searchsubmit.click();
	}
	
	public void clickOnResetButton() {
		
		resetbutton.click();
		
		
	}
}
	

	
	

