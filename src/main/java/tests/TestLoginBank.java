package tests;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base_test.BaseTest;
import helper.DemoFeatureStepDef;
import utilities.JsonHandler;

public class TestLoginBank extends BaseTest {

	DemoFeatureStepDef demo;
	JsonHandler jsonHandler;

	JSONObject jsonObject = null;
	String element;
	String testObjective;
	String username;
	String password;

	@BeforeClass
	public void init() throws IOException, ParseException {

		jsonHandler = new JsonHandler();
		demo = new DemoFeatureStepDef();

	}

	@Test
	public void verifyAcessSuccessfully() {

		jsonObject = jsonHandler.getDataFile("UsersData.json", "valid");

		username = (String) jsonObject.get("username");
		password = (String) jsonObject.get("password");

		demo.eu_navego_para_aplicacao_para_teste_Success().eu_tento_entrar_com_as_credenciais_validas(username,
				password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Falha ao executar ->" + e.getMessage());
			e.printStackTrace();
		}

		element = demo.eu_devo_ver_que_entrei_com_sucesso();
		testObjective = (String) jsonObject.get("message");
		Assert.assertEquals(element, testObjective);

	}

	@Test
	public void verifyAcessInvalid() {

		jsonObject = jsonHandler.getDataFile("UsersData.json", "invalid");

		username = (String) jsonObject.get("username");
		password = (String) jsonObject.get("password");

		demo.eu_navego_para_aplicacao_para_teste_invalid().eu_tento_entrar_com_as_credenciais_invalidas(username,
				password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Falha ao executar ->" + e.getMessage());
			e.printStackTrace();
		}

		element = demo.eu_devo_ver_que_nao_tive_acesso();
		testObjective = (String) jsonObject.get("message");
		Assert.assertTrue(element.contains(testObjective));
	}

	@Test
	public void verifyAcessEmpty() {

		jsonObject = jsonHandler.getDataFile("UsersData.json", "allEmpty");

		username = (String) jsonObject.get("username");
		password = (String) jsonObject.get("password");

		demo.eu_navego_para_aplicacao_para_teste_empty().eu_tento_entrar_com_as_credenciais_em_branco(username,
				password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Falha ao executar ->" + e.getMessage());
			e.printStackTrace();
		}

		element = demo.eu_devo_ver_que_nao_tive_acesso_com_dados_em_branco();
		testObjective = (String) jsonObject.get("message");
		Assert.assertTrue(element.contains(testObjective));

	}

}
