package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class LandingPageActions {
	
	WebDriver d;
	CommonMethods common;
	
	@CacheLookup
	@FindBy(xpath="//*[contains(text(),'New Releases')]")
	public WebElement newReleases;
	
	@CacheLookup
	@FindBy(xpath="//a[contains(@href,'/hz/wishlist')]")
	public WebElement wishList;
	
	@CacheLookup
	@FindBy(xpath="//*[contains(text(),'Hello, sign in')]")
	public WebElement accountsAndLists;
	
	@CacheLookup
	@FindBy(xpath="//a[contains(@href,'/prime?')]")
	public WebElement prime;
	
	@CacheLookup
	@FindBy(id="twotabsearchtextbox")
	public WebElement searchBox;
	
	//nav-search-submit-button
	@CacheLookup
	@FindBy(id="nav-search-submit-button")
	public WebElement submit;
	

	public LandingPageActions(WebDriver driver) {
		this.d = driver;
		common = new CommonMethods(driver);
		PageFactory.initElements(d, this);
	}
	
	public void navigateToNewReleases() {
		common.waitForElement(newReleases);
		common.highlightElement(newReleases);
		newReleases.click();
	}
	
	public void navigateToWishList() {
		common.waitForElement(wishList);
		common.highlightElement(wishList);
		wishList.click();
	}
	
	public void hoverOnAccountsAndLists() {
		Actions actions = new Actions(d);
	    //Hovering on main menu
		actions.moveToElement(accountsAndLists).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void navigateToPrime() {
		common.waitForElement(prime);
		common.highlightElement(prime);
		prime.click();
	}
	
	public void search(String key) {
		common.highlightElement(searchBox);
		searchBox.clear();
		searchBox.sendKeys(key);
		submit.click();
	}
	
}
