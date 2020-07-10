package managers;

import org.openqa.selenium.WebDriver;

import page_objects.HomePage;



public class PageObjectManager  {

	private WebDriver driver;
	private HomePage homepage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {

		return (homepage == null) ? homepage = new HomePage(driver) : homepage;

	}

}
