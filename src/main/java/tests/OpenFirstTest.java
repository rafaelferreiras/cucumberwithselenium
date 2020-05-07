package tests;


import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import managers.WebDriverManager;
import page_objects.LogInBank;
import utilities.JsonHandler;

public class OpenFirstTest extends WebDriverManager {

	JsonHandler jsonHandler = new JsonHandler();
	JSONObject jsonObject = null;
	String username;
	String password;

	
	@org.testng.annotations.BeforeClass
	public void BeforeClass() throws IOException, ParseException  {

		jsonObject = jsonHandler.getDataFile("UsersData.json","users");
		username = (String) jsonObject.get("username");
		password = (String) jsonObject.get("password");

	}

	@Test
	public void verifyAcessSuccessfully() {

		new LogInBank(driver).loginSuccessfully(username, password);
	

	

	String getTitle = driver.getTitle();
	Assert.assertEquals(getTitle,"Digital Bank");
	}

	@AfterClass
	public void AfterMethod() {
		WebDriverManager.CloseDriver();
	}

}
