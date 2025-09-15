package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/*
This utility:
Captures a screenshot when a test fails.
Creates a timestamped file name.
Stores the screenshot inside OutputScreenShot folder in your project.
 * 
 */

public class ScreenshotUtility {
	
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {

		TakesScreenshot scrShot = (TakesScreenshot) driver; //TakesScreenshot - interface. By casting driver into TakesScreenshot, we gain access to the screenshot-taking ability of the browser.
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //store screenshot as temporary file

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); //add timestamp on screenshot file

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory
		if (!f1.exists()) {

		f1.mkdirs();
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
		+ ".png";
		// String destination = f1.getPath() + "//" + failedTestCase + timeStamp +
		// ".png";

		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination); //Copies the screenshot from the temporary file to your permanent folder.
		}

}
