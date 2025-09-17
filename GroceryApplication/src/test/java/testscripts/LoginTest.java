package testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");//getting the usernameValue value from excel
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");// getting the passwordValue value from excel
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue); //calling methods from pageclass : LoginPage
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnLoginButton();
		boolean dashboarddisplay = loginpage.IsDashboardDisplayed();
		Assert.assertTrue(dashboarddisplay,"User couldn't login with valid credentials");
	}
	
	@Test
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		
		String usernameValue = ExcelUtility.getStringData(1,0,"LoginPage");
		String passwordValue = ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue); //calling methods from pageclass : LoginPage
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnLoginButton();
		String actual = loginpage.getPageTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,"User was able to login with invalid username");
	}
	
	@Test
	public void verifyuserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		
		String usernameValue = ExcelUtility.getStringData(2,0,"LoginPage");
		String passwordValue = ExcelUtility.getStringData(2,1,"LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue); //calling methods from pageclass : LoginPage
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnLoginButton();
		String actual = loginpage.getPageTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,"User was able to login with invalid password");
	}
	
	@Test
	public void verifyUserLoginWithInvalidCredentials() throws IOException {
		
		String usernameValue = ExcelUtility.getStringData(3,0,"LoginPage");
		String passwordValue = ExcelUtility.getStringData(3,1,"LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue); 
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnLoginButton();
		String actual = loginpage.getPageTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,"User was able to login with invalid credentials");
	}

}
