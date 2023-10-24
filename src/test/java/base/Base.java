package base;

import drivermanager.drivermanager;
import utils.ReadProperties;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class Base {

 drivermanager dm = new drivermanager();
 
 ReadProperties obj;
 
 public static String baseUrl;
 
 public static WebDriver driver;
 
 
  @Parameters({"browser","url"})
  @BeforeTest(alwaysRun=true)
  public void beforeTest(String browser, String url) {
	  
	  obj = new ReadProperties();
	  Properties properties = obj.readPropertyObject();
	  
//	  dm.setup(properties.getProperty("Browser"), properties.getProperty("Url"));
	  dm.setup(browser, url);
	  driver = drivermanager.getDriver();
	  baseUrl = url;
  }

  @AfterSuite(alwaysRun=true)
  public void afterSuite() {
	  driver.quit();
  }

}
