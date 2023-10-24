package drivermanager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class drivermanager {


	public static WebDriver driver;

	public void setup(String browser, String url) {

		String systemPath=System.getProperty("user.dir");
		System.out.println("returning the location my dr>> "+ systemPath);
		String path = "/driver/chromedriver-mac-x64/chromedriver";

		if(browser.equalsIgnoreCase("chrome"))	{
			System.setProperty("webdriver.chrome.driver",systemPath+path);
			driver = new ChromeDriver();
			System.out.println("this is the launched br >>  "+ browser);


		} else if(browser.equalsIgnoreCase("firefox")) {
		       System.setProperty("webdriver.gecko.driver",systemPath+"/driver/geckodriver");
			   driver = new FirefoxDriver();
			
		} else {
			System.out.println("this is not correct choice of browser >>   "+ browser);
		}

		if (url!="") {
			driver.get(url);
			System.out.println("the url is >>   "+ url);
		}else {
			driver.get("about:blank");
			System.out.println("the url is blank and not as expected >>   "+ url);
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

	}

	public void teardown() {
		driver.quit();

	}

	public static WebDriver getDriver() {
		return driver;

	}


}


