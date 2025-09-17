package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") private WebElement managenewsnewbutton;
	@FindBy(id="news") private WebElement managenewsenternews;
	@FindBy(xpath="//button[text()='Save']") private WebElement managenewssavenews;
	@FindBy(xpath="//i[@class='icon fas fa-check']") private WebElement newsaddedsuccessalert;
	@FindBy(xpath="//a[@onclick='click_button(2)']") private WebElement managenewssearchbutton;
	@FindBy(name="un") private WebElement managenewsenternewsinsearch;
	@FindBy(name="Search") private WebElement managenewssearchsubmit;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") private WebElement managenewsresetbutton;
	@FindBy(xpath="//h1[text()='Manage News']") private WebElement managenewstitle;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr") private WebElement searchednewsintable;
	
	
	public void clickOnManageNewsNewButton() {
		
		managenewsnewbutton.click();
	}
	
	public void enterNewsInTextbox(String newlyAddednews) {
		
		managenewsenternews.sendKeys(newlyAddednews);
	}
	
	public void clickOnSaveNews() {
		
		managenewssavenews.click();
	}
	
	public boolean IsnewsAlertSuccessDisplayed() {
		
		return newsaddedsuccessalert.isDisplayed();
	}
	
	public void clickOnManageNewsSearchButton() {
		
		managenewssearchbutton.click();
	}
	
	public void enterTextInManageNewsSearchTextBox(String newlyAddednews) {
		
		managenewsenternewsinsearch.sendKeys(newlyAddednews);
	}
	
	public void clickOnSearchAfterEnteringNews() {
		
		managenewssearchsubmit.click();
		
	}
	
	public void clickOnManageNewsResetButton() {
		
		managenewsresetbutton.click();
	}
	
	public String getManageNewsPagetitle() {
		
		return managenewstitle.getText();
	}
	
	public boolean searchedNewsIsDisplayedInTable() {
		
		return searchednewsintable.isDisplayed();
	}
	
	
	

}
