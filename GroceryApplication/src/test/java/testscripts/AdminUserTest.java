package testscripts;

import java.io.Console;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {
	
	HomePage homepage;
	AdminUserPage adminuserpage;
	
	@Test(description = "User is creating a new user in Admin User page")
	public void verifyUserIsAbleToAddNewUser() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnLoginButton();
		adminuserpage = homepage.clickOnAdminUsers();
		RandomDataUtility randomdata = new RandomDataUtility();
		adminuserpage.clickOnNewButton();
		String newUsername = randomdata.randomUsername(); //entering username using faker class
		String newPassword = randomdata.randomPassword(); //entering password using faker class
		adminuserpage.enterUsernameForNewUser(newUsername).enterPasswordForNewUser(newPassword).selectUserTypeForNewUser().clickOnSaveNewUser();	
		boolean useralertsuccess = adminuserpage.userAddedSuccessAlertIsDisplayed();
		Assert.assertTrue(useralertsuccess, Constants.NEWUSERADDEDERROR);
	}
	
	@Test(description = "User is searching the list with an existing user details")
	public void verifyUserIsAbleToSearchNewlyAddedUser() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnLoginButton();
		adminuserpage = homepage.clickOnAdminUsers();
		String newUsername = ExcelUtility.getStringData(0,0,"AdminUserPage");
		adminuserpage.clickOnSearch().enterUsernameOnSearch(newUsername).clickOnSearchSubmit();
		String actual = adminuserpage.getSearchedUserInTable();
		System.out.println(actual);
		String expected = "scotty.blick";
		Assert.assertEquals(actual, expected,Constants.USERNOTFOUNDERROR);
			
	}
	
	@Test(description = "User clicks on Reset button in Admin user page")
	public void verifyUserIsAbleToResetTheList() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnLoginButton();
		adminuserpage = homepage.clickOnAdminUsers();
		adminuserpage.clickOnResetButton();
		String actual = adminuserpage.getAdminUserPageTitle();
		String expected = "Admin Users";
		Assert.assertEquals(actual, expected,Constants.USERRESETBUTTONERROR);
		
	}
		
	
}
