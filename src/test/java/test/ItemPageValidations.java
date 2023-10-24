package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.AssertJUnit;
import base.Base;
import drivermanager.drivermanager;
import pom.ItemPageActions;
import pom.LandingPageActions;
import pom.SearchPageActions;

import org.openqa.selenium.By;

public class ItemPageValidations extends Base {


	LandingPageActions lp;
	SearchPageActions sp;
	ItemPageActions ip;

	@Parameters({"searchQuery"})
	@Test(priority = 1)
	public void validateDeliveryBox(String searchQuery) {

		lp.search(searchQuery);
		sp.navigateToFirstResult();
		ip.deliveryBox.click();
		ip.enterPinCode("v3z", "2j4");
		ip.clickOnApply();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// need to do this because page refreshes
		String result = driver.findElement(By.id("contextualIngressPtLabel_deliveryShortLine")).getAttribute("innerText");
		String expectedResult = "V3Z 2J";
		AssertJUnit.assertTrue(result.contains(expectedResult));
		driver.navigate().to(baseUrl);

	}


	@BeforeClass
	public void beforeClass() {
		lp = new LandingPageActions(drivermanager.getDriver());
		sp = new SearchPageActions(drivermanager.getDriver());
		ip = new ItemPageActions(drivermanager.getDriver());

	}

}
