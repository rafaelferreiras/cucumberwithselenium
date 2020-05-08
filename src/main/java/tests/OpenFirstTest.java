package tests;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import helper.HelperLogInBank;
import managers.WebDriverManager;
import utilities.JsonHandler;
import org.openqa.selenium.By;


public class OpenFirstTest extends WebDriverManager {

	OpenFirstTest() throws Exception {

	}

	HelperLogInBank helper;
	JsonHandler jsonHandler;
	JSONObject jsonObject = null;
	String username;
	String password;

	@org.testng.annotations.BeforeClass
	public void init() throws IOException, ParseException {

		jsonHandler = new JsonHandler();
		helper = new HelperLogInBank();
		// jsonObject = jsonHandler.getDataFile("UsersData.json");

	}

	@Test
	public void verifyAcessSuccessfully() throws InterruptedException {

		// jsonObject = jsonHandler.getDataGroup(jsonObject, "valid");
		jsonObject = jsonHandler.getDataFile("UsersData.json", "valid");
		username = (String) jsonObject.get("username");
		password = (String) jsonObject.get("password");

		helper.preencherLogin(username)
		.preencheSenha(password)
		.clicarSumit();
		Thread.sleep(3000);

		String getTitle = driver.findElement(By.xpath("//li[contains(.,'Welcome RAFAEL')]")).getText();
		Assert.assertEquals(getTitle, "Welcome RAFAEL");
	}

	@Test
	public void verifyAcessInvalid() throws InterruptedException {

		// jsonObject = jsonHandler.getDataGroup(jsonObject, "allEmpty");
		jsonObject = jsonHandler.getDataFile("UsersData.json", "invalid");
		username = (String) jsonObject.get("username");
		password = (String) jsonObject.get("password");

		helper.preencherLogin(username)
		.preencheSenha(password)
		.clicarSumit();
		Thread.sleep(3000);

		boolean getAlert = driver.findElement(By.cssSelector(".sufee-alert.alert.with-close.alert-danger.alert-dismissible.fade.show")).getAttribute("innerText").contains("Invalid credentials or access not granted.");
		Assert.assertEquals(getAlert, true);
	}

	@Test
	public void verifyAcessEmpty() throws InterruptedException {

		// jsonObject = jsonHandler.getDataGroup(jsonObject, "allEmpty");
		jsonObject = jsonHandler.getDataFile("UsersData.json", "allEmpty");
		username = (String) jsonObject.get("username");
		password = (String) jsonObject.get("password");

		helper.preencherLogin(username)
		.preencheSenha(password)
		.clicarSumit();
		Thread.sleep(3000);

		boolean getAlert = driver.findElement(By.cssSelector(".sufee-alert.alert.with-close.alert-danger.alert-dismissible.fade.show")).getAttribute("innerText").contains("Invalid credentials or access not granted.");
		Assert.assertEquals(getAlert, true);
	}

	@AfterClass
	public void AfterMethod() {
		WebDriverManager.CloseDriver();
	}

}
