package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}
	
	public void selectDropdownWithIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);

	}
	
	public void DragAndDrop(WebDriver driver,WebElement drag, WebElement drop) {
		
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element) {
		
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}
	
	public void clickOKButtonOnAlert(WebDriver driver) {
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	
	public void clickOnRadioButton(WebElement element) {
		
		element.click();
	}
	
	public void clickOnCheckBox(WebElement element) {
		
		element.click();
		element.isSelected();
	}
	
	public void javascriptScrollBy(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)","");
	}


}
