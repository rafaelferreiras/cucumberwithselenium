package base_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import managers.BroserManager;
import page_objects.HomePage;
import page_objects.PageObjectManager;

public class BaseTest {

	protected static WebDriverWait wait;
	protected static WebDriver driver;
	protected static PageObjectManager pageObjectManager;
	protected static HomePage homePage;

	@BeforeTest
	@Parameters({ "BrowserType" })
	public static void getDriver(String BrowserType) {

		BroserManager broserManager = new BroserManager();

		broserManager.LocalDrivers(BrowserType);
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		homePage.GoHomePage();

	}

	@AfterSuite
	public void TestReport() {

	}

	@AfterTest
	public void ClosedDriver() {
		driver.close();

	}

	public static WebDriver getDriver() {
		return driver;
	}

}
