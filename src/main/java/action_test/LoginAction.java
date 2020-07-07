package action_test;

import org.json.simple.JSONObject;

import helper.HelperLogInBank;

public class LoginAction implements IActionTest {

	private String username;
	private String password;

	HelperLogInBank helper = new HelperLogInBank();

	@Override
	public void dataProviderTest(JSONObject jsonObject) {

		username = (String) jsonObject.get("username");
		password = (String) jsonObject.get("password");

		ActionTest();

	}

	@Override
	public void ActionTest() {

		try {

			helper.login(username, password);
			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println("Falha ao executar ->" + e.getMessage());
		}
	}

}
