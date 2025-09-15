package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserTest extends Base {
	
	@Test
	public void verifyUserIsAbleToAddNewUser() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue); //calling methods from pageclass : LoginPage
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnLoginButton();
		AdminUserPage adminpage = new AdminUserPage(driver);
		adminpage.clickOnAdminUsers();
		adminpage.clickOnNewButton();
		adminpage.enterUsernameForNewUser("Qsera1");
		adminpage.enterPasswordForNewUser("Qsera123");
		adminpage.selectUserTypeForNewUser();
		adminpage.clickOnSaveNewUser();		
	}
	
	@Test
	public void verifyUserIsAbleToSearchNewlyAddedUser() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue); //calling methods from pageclass : LoginPage
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnLoginButton();
		AdminUserPage adminpage = new AdminUserPage(driver);
		adminpage.clickOnAdminUsers();
		adminpage.clickOnSearch();
		adminpage.enterUsernameOnSearch("Qsera1");
		adminpage.clickOnSearchSubmit();
		
		
	}
	
	@Test
	public void verifyUserIsAbleToResetTheList() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue); //calling methods from pageclass : LoginPage
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnLoginButton();
		AdminUserPage adminpage = new AdminUserPage(driver);
		adminpage.clickOnAdminUsers();
		adminpage.clickOnResetButton();
		
	}
	
	
	
	

}
