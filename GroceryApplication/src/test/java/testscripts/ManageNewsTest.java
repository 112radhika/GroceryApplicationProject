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
	
	HomePage homepage;
	ManageNewsPage managenews;
	

	@Test(description = "User is adding New news in Manage news page")
	public void verifyUserIsAbleToAddNewNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnLoginButton();
		managenews = homepage.clickOnManageNews();
		managenews.clickOnManageNewsNewButton();
		String newlyAddednews = ExcelUtility.getStringData(0, 0,"ManageNewsPage");
		managenews.enterNewsInTextbox(newlyAddednews).clickOnSaveNews();
		boolean newsaddedsuccessalert = managenews.IsnewsAlertSuccessDisplayed();
		Assert.assertTrue(newsaddedsuccessalert,Constants.NEWNEWSADDEDERROR);
				
		
	}
	
	@Test(description = "User search for an existing news")
	public void verifyUserIsAbleToSearchNewlyAddedNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnLoginButton();
		managenews = homepage.clickOnManageNews();
		managenews.clickOnManageNewsSearchButton();
		String newlyAddednews = ExcelUtility.getStringData(0, 0,"ManageNewsPage");
		managenews.enterTextInManageNewsSearchTextBox(newlyAddednews).clickOnSearchAfterEnteringNews();
		boolean searchednewstext = managenews.searchedNewsIsDisplayedInTable();
		System.out.println(searchednewstext);
		Assert.assertTrue(searchednewstext, Constants.NEWSNOTFOUND);
	}
	
	@Test(description = "User clicks on Reset button in manage news page")
	public void verifyUserIsAbleToResetManageNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnLoginButton();
		managenews = homepage.clickOnManageNews();
		managenews.clickOnManageNewsResetButton();
		String actual = managenews.getManageNewsPagetitle();
		String expected = "Manage News";
		Assert.assertEquals(actual, expected,Constants.NEWSRESETBUTTONERROR);
		
	}
	

}
