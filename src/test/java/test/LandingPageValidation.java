package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.AssertJUnit;
import base.Base;
import drivermanager.drivermanager;
import pom.LandingPageActions;
import org.testng.Assert;

public class LandingPageValidation extends Base {
	

  LandingPageActions lp;

	
  @Test(priority=1)
  public void validateNewReleases() {
	  
	  AssertJUnit.assertTrue(lp.newReleases.isDisplayed());
	  lp.navigateToNewReleases();
      Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.ca/gp/new-releases/?ref_=nav_cs_newreleases");
	  driver.navigate().back();
  }
  
  @Test(priority=2)
  public void validateWishList() {
	
	  lp.hoverOnAccountsAndLists();
	  AssertJUnit.assertTrue(lp.wishList.isDisplayed());
	  lp.navigateToWishList();
      Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.ca/hz/wishlist/intro");
	  driver.navigate().back();
	  
  }
  
  @Test(priority=3)
  public void validatePrime() {
	  
	  AssertJUnit.assertTrue(lp.prime.isDisplayed());
	  lp.navigateToPrime();
      Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.ca/amazonprime?ref_=nav_cs_primelink_nonmember");
	  driver.navigate().back();
  }
  
  @Parameters({"searchQuery"})
  @Test(priority=4)
  public void validateSearch(String searchQuery) {
	  
	  AssertJUnit.assertTrue(lp.searchBox.isDisplayed());
	  AssertJUnit.assertTrue(lp.submit.isDisplayed());

	  lp.search(searchQuery);
	  String expectedUrl = "https://www.amazon.ca/s";
	  String actualUrl = driver.getCurrentUrl();
	  AssertJUnit.assertTrue(actualUrl.indexOf(expectedUrl) == 0);
	  driver.navigate().back();

  }
  
  @BeforeClass
  public void beforeClass() {
	  lp = new LandingPageActions(drivermanager.getDriver());
	  
  }

}
