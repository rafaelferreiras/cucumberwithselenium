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
	
	
	public HelperLogInBank login(String login, String senha){
		
		page.txt_UserName.sendKeys(login);
		page.txt_Password.sendKeys(senha);
		page.btn_Submit.click();
		return this;
	}
	
	public String verifySucessLogin() {
		
		
		return page.sucess_login.getText();
	}
	
	public String verifyErrorLogin() {
		
		
		return page.error_login.getAttribute("innerText");
	}
	
	

}