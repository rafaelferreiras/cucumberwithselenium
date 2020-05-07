package tests;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import managers.WebDriverManager;
import page_objects.LogInBank;
import utilities.JsonHandler;

public class OpenFirstTest extends WebDriverManager {

	OpenFirstTest() throws Exception {

	}

	JsonHandler jsonHandler = new JsonHandler();
	JSONObject jsonObject = null;
	String username;
	String password;
	

	@org.testng.annotations.BeforeClass
	public void BeforeClass() throws IOException, ParseException {

		jsonObject = jsonHandler.getDataFile("UsersData.json");

	}

	@Test
	public void verifyAcessSuccessfully() throws IOException, ParseException {

		jsonObject = jsonHandler.getDataGroup(jsonObject, "valid");
		username = (String) jsonObject.get("username");
		password = (String) jsonObject.get("password");
		new LogInBank(driver).loginBank(username, password);

		String getTitle = driver.getTitle();
		Assert.assertEquals(getTitle, "Digital Bank");
	}
	
	@Test
	public void verifyAcessInvalid() throws IOException, ParseException {

		
		jsonObject = jsonHandler.getDataGroup(jsonObject, "invalid");
		username = (String) jsonObject.get("username");
		password = (String) jsonObject.get("password");
		new LogInBank(driver).loginBank(username, password);

		String getTitle = driver.getTitle();
		Assert.assertEquals(getTitle, "Digital Bank");
	}
	
	
	@Test
	public void verifyAcessEmpty() throws IOException, ParseException {

		
		jsonObject = jsonHandler.getDataGroup(jsonObject, "allEmpty");
		username = (String) jsonObject.get("username");
		password = (String) jsonObject.get("password");
		new LogInBank(driver).loginBank(username, password);
		String getTitle = driver.getTitle();
		Assert.assertEquals(getTitle, "Digital Bank");
	}



	@AfterClass
	public void AfterMethod() {
		WebDriverManager.CloseDriver();
	}

}
