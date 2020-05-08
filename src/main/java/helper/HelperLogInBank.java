package helper;

import page_objects.LogInBank;

public class HelperLogInBank {

	private LogInBank page;

	public HelperLogInBank() {

		page = new LogInBank();
	}

	public HelperLogInBank preencherLogin(String login) {

		page.txt_UserName.sendKeys(login);
		return this;
	}

	public HelperLogInBank preencheSenha(String senha) {

		page.txt_Password.sendKeys(senha);
		return this;
	}

	public HelperLogInBank clicarSumit() {

		page.btn_Submit.click();
		return this;
	}

}
