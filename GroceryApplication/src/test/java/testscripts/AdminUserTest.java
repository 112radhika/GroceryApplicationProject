package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {
	
	@Test
	public void verifyUserIsAbleToAddNewUser() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue); //calling methods from pageclass : LoginPage
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnLoginButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAdminUsers();
		AdminUserPage adminpage = new AdminUserPage(driver);
		RandomDataUtility randomdata = new RandomDataUtility();
		adminpage.clickOnNewButton();
		String newUsername = randomdata.randomUsername(); //entering username using faker class
		String newPassword = randomdata.randomPassword(); //entering password using faker class
		adminpage.enterUsernameForNewUser(newUsername);
		adminpage.enterPasswordForNewUser(newPassword);
		adminpage.selectUserTypeForNewUser();
		adminpage.clickOnSaveNewUser();	
		boolean useralertsuccess = adminpage.userAddedSuccessAlertIsDisplayed();
		Assert.assertTrue(useralertsuccess, "User is not added successfully");
	}
	
	@Test
	public void verifyUserIsAbleToSearchNewlyAddedUser() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue); //calling methods from pageclass : LoginPage
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnLoginButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAdminUsers();
		String newUsername = ExcelUtility.getStringData(0,0,"AdminUserPage");
		AdminUserPage adminpage = new AdminUserPage(driver);
		adminpage.clickOnSearch();
		adminpage.enterUsernameOnSearch(newUsername);
		adminpage.clickOnSearchSubmit();
		String actual = adminpage.getSearchedUserInTable();
		System.out.println(actual);
		String expected = "scotty.blick";
		Assert.assertEquals(actual, expected,"User not found");
			
	}
	
	@Test
	public void verifyUserIsAbleToResetTheList() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue); //calling methods from pageclass : LoginPage
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnLoginButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAdminUsers();
		AdminUserPage adminpage = new AdminUserPage(driver);
		adminpage.clickOnResetButton();
		String actual = adminpage.getAdminUserPageTitle();
		String expected = "Admin Users";
		Assert.assertEquals(actual, expected,"User landed on a different page after clicking reset button on Admin User page!");
		
	}
		
	
}
