package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	
	WebDriver driver;
	
	public CommonMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void highlightElement(WebElement ele) {
		JavascriptExecutor jsexe = (JavascriptExecutor)driver;
		jsexe.executeScript("arguments[0].style.border='2px solid red'", ele);
	}	
	
	public void scroll(WebElement ele) {
		JavascriptExecutor jsexe = (JavascriptExecutor)driver;
		jsexe.executeScript("arguments[0].scrollIntoView();", ele);

	}

}
