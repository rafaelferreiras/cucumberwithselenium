package tests;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import action_test.LoginAction;
import base_test.BaseTest;
import helper.HelperLogInBank;
import utilities.JsonHandler;

public class TestLoginBank extends BaseTest {

	LoginAction loginBankAction;
	JsonHandler jsonHandler;
	HelperLogInBank helper;
	JSONObject jsonObject = null;
	String element;
	String testObjective;

	@BeforeClass
	public void init() throws IOException, ParseException {

		jsonHandler = new JsonHandler();
		loginBankAction = new LoginAction();
		helper = new HelperLogInBank();

	}

	@Test
	public void verifyAcessSuccessfully() {

		jsonObject = jsonHandler.getDataFile("UsersData.json", "valid");

		loginBankAction.dataProviderTest(jsonObject);
		element = helper.verifySucessLogin();
		testObjective = (String) jsonObject.get("message");
		Assert.assertEquals(element, testObjective);
	}

	@Test
	public void verifyAcessInvalid() {

		jsonObject = jsonHandler.getDataFile("UsersData.json", "invalid");

		loginBankAction.dataProviderTest(jsonObject);
		element = helper.verifyErrorLogin();
		testObjective = (String) jsonObject.get("message");
		Assert.assertTrue(element.contains(testObjective));
	}

	@Test
	public void verifyAcessEmpty() {

		jsonObject = jsonHandler.getDataFile("UsersData.json", "allEmpty");

		loginBankAction.dataProviderTest(jsonObject);
		element = helper.verifyErrorLogin();
		testObjective = (String) jsonObject.get("message");
		Assert.assertTrue(element.contains(testObjective));

	}

}
