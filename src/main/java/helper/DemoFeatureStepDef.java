package helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import page_objects.LogInBank;

public class DemoFeatureStepDef {

	private LogInBank page;

	public DemoFeatureStepDef() {

		page = new LogInBank();

	}

	@Step("Acessando aplicação")
	@Given("Eu navego para aplicacao para teste Success")
	public DemoFeatureStepDef eu_navego_para_aplicacao_para_teste_Success() {
		return this;

	}

	@When("Eu tento entrar com as credenciais validas")
	public DemoFeatureStepDef eu_tento_entrar_com_as_credenciais_validas(String user, String pass) {

		page.txt_UserName.sendKeys(user);
		page.txt_Password.sendKeys(pass);
		page.btn_Submit.click();
		return this;

	}

	@Then("Eu devo ver que entrei com sucesso")
	public String eu_devo_ver_que_entrei_com_sucesso() {

		return page.sucess_login.getText();

	}

	@Step("Acessando aplicação")
	@Given("Eu navego para aplicacao para teste invalid")
	public DemoFeatureStepDef eu_navego_para_aplicacao_para_teste_invalid() {
		return this;

	}

	@When("Eu tento entrar com as credenciais invalidas")
	public DemoFeatureStepDef eu_tento_entrar_com_as_credenciais_invalidas(String user, String pass) {

		page.txt_UserName.sendKeys(user);
		page.txt_Password.sendKeys(pass);
		page.btn_Submit.click();
		return this;

	}

	@Then("Eu devo ver que nao tive acesso")
	public String eu_devo_ver_que_nao_tive_acesso() {

		return page.error_login.getAttribute("innerText");

	}

	@Step("Acessando aplicação")
	@Given("Eu navego para aplicacao para teste empty")
	public DemoFeatureStepDef eu_navego_para_aplicacao_para_teste_empty() {
		return this;

	}

	@When("Eu tento entrar com as credenciais em branco")
	public DemoFeatureStepDef eu_tento_entrar_com_as_credenciais_em_branco(String user, String pass) {

		page.txt_UserName.sendKeys(user);
		page.txt_Password.sendKeys(pass);
		page.btn_Submit.click();
		
		return this;

	}

	@Then("Eu devo ver que nao tive acesso com dados em branco")
	public String eu_devo_ver_que_nao_tive_acesso_com_dados_em_branco() {

		return page.error_login.getAttribute("innerText");

	}

}
