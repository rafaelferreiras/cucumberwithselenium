package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import enums.BrowserType;
import page_objects.HomePage;

public class WebDriverManager {

	
	protected static WebDriverWait wait;
	protected static WebDriver driver;
	protected static PageObjectManager pageObjectManager;
	protected static HomePage homePage;

	
	
	@BeforeTest
	@Parameters({ "BrowserType" })
	public static void OpenDriver(String BrowserType) {

		driver = WebDriverManager.LocalDrivers(BrowserType);
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		homePage.GoHomePage();

	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}

	public static void ManageBrowser() {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 100);

	}

	public static WebDriver LocalDrivers(String driversType) {

		BrowserType type = BrowserType.driversTypeForName(driversType);

		switch (type) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");

			driver = new ChromeDriver();
			ManageBrowser();
			return driver;

		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");

			driver = new FirefoxDriver();
			ManageBrowser();
			return driver;

		case INTERNETEXPLORE:
			System.setProperty("webdriver.ie.driver", "./src/test/resources/IEDriverServer.exe");

			driver = new InternetExplorerDriver();
			ManageBrowser();
			return driver;

		default:
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");

			driver = new ChromeDriver();
			ManageBrowser();
			return driver;

		/*
		 * ERROR: Output in Eclipse: WebDriver Open IE Go to Tools -> Internet Options
		 * -> Security Set all zones to the same protected mode, enabled or disabled
		 * should not matter. Finally, set Zoom level to 100%
		 */

		}

	}

	public static void CloseDriver() {

		driver.close();

	}

}
