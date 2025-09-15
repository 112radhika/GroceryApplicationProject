package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	
	@Test
	public void verifyUserIsAbleToLogout() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue); //calling methods from pageclass : LoginPage
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnLoginButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAdmin();
		homepage.clickOnLogout();
	}

}
