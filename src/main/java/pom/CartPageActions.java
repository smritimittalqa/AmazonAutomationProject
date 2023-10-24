package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class CartPageActions {

	WebDriver d;
	CommonMethods common;

	@CacheLookup
	@FindBy(name="proceedToRetailCheckout")
	public WebElement proceedToCheckout;
	
	//NATC_SMART_WAGON_CONF_MSG_SUCCESS
	
	@CacheLookup
	@FindBy(id="NATC_SMART_WAGON_CONF_MSG_SUCCESS")
	public WebElement addedToCart;
	
	public CartPageActions(WebDriver driver) {
		this.d = driver;
		common = new CommonMethods(driver);
		PageFactory.initElements(d, this);
	}
	
	public void navigatetoCheckout() {
		common.waitForElement(proceedToCheckout);
		common.highlightElement(proceedToCheckout);
		proceedToCheckout.click();
	}
	
	public String getAddedToCartText() {
		return addedToCart.getAttribute("innerText");
	}
	
}
