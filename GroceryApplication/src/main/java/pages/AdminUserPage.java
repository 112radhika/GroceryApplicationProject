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
	@FindBy(xpath="//h1[text()='Admin Users']") private WebElement adminusertitle;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement useraddedsuccessalert;
		
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
	
	public void enterUsernameOnSearch(String newUsername) {
		
		searchusername.sendKeys(newUsername);
		
	}
	
	public void clickOnSearchSubmit() {
		
		searchsubmit.click();
	}
	
	public void clickOnResetButton() {
		
		resetbutton.click();
		
	}
	
	public String getAdminUserPageTitle() {
		
		return adminusertitle.getText();
	}
	
	public boolean userAddedSuccessAlertIsDisplayed() {
		
		return useraddedsuccessalert.isDisplayed();
	}
}
	
/*
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]") private WebElement tablecontent;
@FindBy(xpath = "//span[@class='badge bg-success']") private WebElement useractivestatus;
@FindBy(xpath="//a[@title='Show Details']") private WebElement clickpassword;
@FindBy(xpath="//div[@class='profile-info-name']") private WebElement checkpassword;
@FindBy(xpath="//a[@role='button' and @class='btn btn-sm btn btn-success btncss']") private WebElement lockbutton;
@FindBy(xpath = "//span[@class='badge bg-warning']") private WebElement userinactivestatus;
@FindBy(xpath="//a[@role='button' and @class='btn btn-sm btn btn-danger btncss']") private WebElement deletebutton;
*/
	
	
	//Perform actions on the newly added user
	 /*public void verifyActionsPerformedOnSearchedUser() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", "");
		System.out.println(tablecontent.getText());
		System.out.println(useractivestatus.getText());
		clickpassword.click();
		System.out.println(checkpassword.getText());
		lockbutton.click();
		this.verifyUserIsAbleToSearchNewlyAddedUser();
		js.executeScript("window.scrollBy(0,100)", "");
		System.out.println(userinactivestatus.getText());		
		
	}
	// Delete the newly added user
	public void verifyUserIsAbleToDeleteTheUser() {
		
		deletebutton.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}*/
	
	

