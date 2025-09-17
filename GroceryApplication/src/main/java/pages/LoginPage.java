package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}
	
	@FindBy(xpath="//input[@name='username']") private WebElement username;
	@FindBy(xpath="//input[@name='password']") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']") private WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") private WebElement loginpagetitle;

	
public void enterUsernameOnUsernameField(String usernameValue) {
		
		username.sendKeys(usernameValue);
	}
	
	public void enterPasswordOnPasswordField(String passwordValue) {
		
		password.sendKeys(passwordValue);
	}
	
	public void clickOnLoginButton() {
		
		signin.click();
		
	}
	
	public boolean IsDashboardDisplayed() {
		
		return dashboard.isDisplayed();
		
	}
	
	public String getPageTitle() {
		
		return loginpagetitle.getText();
	}


}
