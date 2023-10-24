package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class SearchPageActions {

	WebDriver d;
	CommonMethods common;
	
	@CacheLookup
	@FindBy(css="span[data-component-type='s-result-info-bar']")
	public WebElement searchResult;
	
	@CacheLookup
	@FindBy(xpath="(//a[contains(@class,'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal')])[1]")
	public WebElement firstResult;

	//(//span[@class='a-price-whole'])[1]
			
	@CacheLookup
	@FindBy(xpath="(//span[@class='a-price-whole'])[1]")
	public WebElement firstResultWholePrice;
	
	public SearchPageActions(WebDriver driver) {
		this.d = driver;
		common = new CommonMethods(driver);
		PageFactory.initElements(d, this);
	}
	
	public String getSearchResult() {
		String result;
		common.waitForElement(searchResult);
		common.highlightElement(searchResult);
		result = searchResult.getAttribute("innerText");
		return result;
	}
	
	public String getPrice() {
		String result;
		common.waitForElement(firstResultWholePrice);
		common.highlightElement(firstResultWholePrice);
		result = firstResultWholePrice.getAttribute("innerText");
		return result;
	}
	
	public void navigateToFirstResult() {
		common.waitForElement(firstResult);
		common.highlightElement(firstResult);
		firstResult.click();
	}
	
}
