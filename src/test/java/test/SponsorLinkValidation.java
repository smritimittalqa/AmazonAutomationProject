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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SponsorLinkValidation extends Base {

	LandingPageActions lp;
	SearchPageActions sp;
	ItemPageActions ip;

	//TC5
	@Parameters({"searchQuery"})
	@Test(priority = 1)
	public void validateSponsoredLink(String searchQuery) {
		lp.search(searchQuery);
		sp.navigateToFirstResult();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String originalWindowHandle = driver.getWindowHandle();
		AssertJUnit.assertTrue(driver.getWindowHandles().size() == 1);
		
		
	    ip.scrollToSponsor();
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.switchTo().frame("ape_Detail_hero-quick-promo_Desktop_iframe");
		WebElement link = driver.findElement(By.xpath("//a[contains(@class, 'ad-link')]"));
		((JavascriptExecutor) driver).executeScript("window.open(arguments[0].getAttribute('href'), '_blank');", link);
		
		AssertJUnit.assertTrue(driver.getWindowHandles().size() == 2);

		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.switchTo().window(originalWindowHandle);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().to(baseUrl);
	}

	@BeforeClass
	public void beforeClass() {
		lp = new LandingPageActions(drivermanager.getDriver());
		sp = new SearchPageActions(drivermanager.getDriver());
		ip = new ItemPageActions(drivermanager.getDriver());

	}

}
