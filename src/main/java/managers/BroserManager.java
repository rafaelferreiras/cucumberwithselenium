package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import base_test.BaseTest;
import enums.BrowserType;

public class BroserManager extends BaseTest {

	public void ManageBrowser() {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 100);

	}

	public WebDriver LocalDrivers(String driversType) {

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
		 * ERRO: Saída no Eclipse: WebDriver Open IE Vá para Ferramentas -> Opções da
		 * Internet -> Segurança Defina todas as zonas para o mesmo modo protegido,
		 * ativado ou desativado não deve importar. Por fim, defina o nível de zoom para
		 * 100%
		 */

		}

	}

}
