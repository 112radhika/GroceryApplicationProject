package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageNewsTest extends Base{
	

	@Test(description = "User is adding New news in Manage news page")
	public void verifyUserIsAbleToAddNewNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue); //calling methods from pageclass : LoginPage
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnLoginButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnManageNews();
		ManageNewsPage managenews = new ManageNewsPage(driver);
		managenews.clickOnManageNewsNewButton();
		String newlyAddednews = ExcelUtility.getStringData(0, 0,"ManageNewsPage");
		managenews.enterNewsInTextbox(newlyAddednews);
		managenews.clickOnSaveNews();
		boolean newsaddedsuccessalert = managenews.IsnewsAlertSuccessDisplayed();
		Assert.assertTrue(newsaddedsuccessalert,Constants.NEWNEWSADDEDERROR);
				
		
	}
	
	@Test(description = "User search for an existing news")
	public void verifyUserIsAbleToSearchNewlyAddedNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue); //calling methods from pageclass : LoginPage
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnLoginButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnManageNews();
		ManageNewsPage managenews = new ManageNewsPage(driver);
		managenews.clickOnManageNewsSearchButton();
		String newlyAddednews = ExcelUtility.getStringData(0, 0,"ManageNewsPage");
		managenews.enterTextInManageNewsSearchTextBox(newlyAddednews);
		managenews.clickOnSearchAfterEnteringNews();
		boolean searchednewstext = managenews.searchedNewsIsDisplayedInTable();
		Assert.assertTrue(searchednewstext, Constants.NEWSNOTFOUND);
	}
	
	@Test(description = "User clicks on Reset button in manage news page")
	public void verifyUserIsAbleToResetManageNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue); //calling methods from pageclass : LoginPage
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnLoginButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnManageNews();
		ManageNewsPage managenews = new ManageNewsPage(driver);
		managenews.clickOnManageNewsResetButton();
		String actual = managenews.getManageNewsPagetitle();
		String expected = "Manage News";
		Assert.assertEquals(actual, expected,Constants.NEWSRESETBUTTONERROR);
		
	}
	

}
