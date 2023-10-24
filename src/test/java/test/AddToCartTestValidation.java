package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.AssertJUnit;
import base.Base;
import drivermanager.drivermanager;
import pom.CartPageActions;
import pom.ItemPageActions;
import pom.LandingPageActions;
import pom.SearchPageActions;

public class AddToCartTestValidation extends Base {
	LandingPageActions lp;
	SearchPageActions sp;
	ItemPageActions ip;
	CartPageActions cp;

	@Parameters({"searchQuery"})
	@Test (priority = 1)
	public void validateAddToCart(String searchQuery) {

		lp.search(searchQuery);
		sp.navigateToFirstResult();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ip.clickOnaddToCart();
		String expectedResult = " Added to Cart";
		String actualResult = cp.getAddedToCartText();
		AssertJUnit.assertEquals(actualResult, expectedResult);
	}
	
	
	@Test (priority = 2)
	public void validateProceedToCheckout() {

		cp.navigatetoCheckout();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expectedTitle = "Amazon Sign In";
		String actualTitle = driver.getTitle();
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();	
	 
	}
	
	@BeforeClass
	public void beforeClass() {

		lp = new LandingPageActions(drivermanager.getDriver());
		sp = new SearchPageActions(drivermanager.getDriver());
		ip = new ItemPageActions(drivermanager.getDriver());
		cp = new CartPageActions(drivermanager.getDriver());
	}

}
