package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class ItemPageActions {

	WebDriver d;
	CommonMethods common;

	@CacheLookup
	@FindBy(id="contextualIngressPtLabel_deliveryShortLine")
	public WebElement deliveryBox;
	
	
	@CacheLookup
	@FindBy(id="GLUXZipUpdateInput_0")
	public WebElement zipcode1;
	
	
	@CacheLookup
	@FindBy(id="GLUXZipUpdateInput_1")
	public WebElement zipcode2;
	
	
	@CacheLookup
	@FindBy(css="[aria-labelledby='GLUXZipUpdate-announce']")
	public WebElement apply;
	
	@CacheLookup
	@FindBy(id="add-to-cart-button")
	public WebElement addToCart;
	
	@CacheLookup
	@FindBy(id="ape_Detail_hero-quick-promo_Desktop_iframe")
	public WebElement sponsor;
	
	
	public void clickOnaddToCart() {
		common.waitForElement(addToCart);
		common.highlightElement(addToCart);
		addToCart.click();
	}
	
	public void clickOnApply() {
		common.waitForElement(apply);
		common.highlightElement(apply);
		apply.click();
	}
	
	public void enterPinCode(String code1, String code2) {
		zipcode1.clear();
		zipcode2.clear();
		zipcode1.sendKeys(code1);
		zipcode2.sendKeys(code2);
	}
	
	public void scrollToSponsor() {
		common.waitForElement(sponsor);
		common.scroll(sponsor);
		common.highlightElement(sponsor);
		
	}
	public ItemPageActions(WebDriver driver) {
		this.d = driver;
		common = new CommonMethods(driver);
		PageFactory.initElements(d, this);
	}
	
}
