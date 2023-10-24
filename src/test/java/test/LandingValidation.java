package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import base.Base;

public class LandingValidation extends Base {
  @Test(priority = 1)
  public void validateUrl() {
	  String expectedUrl = "https://www.amazon.ca/";
	  AssertJUnit.assertEquals(driver.getCurrentUrl(), expectedUrl);
  }
  
  @Test(priority = 2)
  public void validateTitle() {
	  String expectedTitle = "Amazon.ca: Low Prices – Fast Shipping – Millions of Items";
	  AssertJUnit.assertEquals(driver.getTitle(), expectedTitle);
  }
  
  @BeforeClass
  public void beforeClass() {
  }

}
