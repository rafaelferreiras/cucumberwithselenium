package page_objects;

import org.openqa.selenium.WebDriver;

public class HomePage {

	protected WebDriver driver;

	public HomePage(WebDriver driver) {
		
		this.driver = driver;
	}

	public void GoHomePage() {

		driver.get("http://dbankdemo.com/login");

	}

}
