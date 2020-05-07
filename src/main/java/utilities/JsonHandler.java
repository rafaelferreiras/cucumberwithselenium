package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonHandler {

	public  JSONObject getDataFile(String fileName)
			throws IOException, ParseException {
		
		
		InputStream inputStream = getClass().getResourceAsStream("/" + fileName);
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(inputStream));

		// criando um parses para utilizamos no momento da leitura do arquivo json
		JSONParser parser = new JSONParser();

		// criando um objeto json que vai receber os dados do arquivo json
		JSONObject jsonDataObject = null;
		try {
			// inserindo o arquivo json em um objeto
			Object jsonFileObject = parser.parse(buffRead);

			// convertendo o objeto com o arquivo json para o formato de objeto json
			jsonDataObject = (JSONObject) jsonFileObject;
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		// garantindo que o objeto json não está nulo
		assert jsonDataObject != null;

		// retornando o objeto json
		return jsonDataObject;

	}
	
	public JSONObject getDataGroup (JSONObject jsonDataObject,String dataGroup) {
		
		// retornando o objeto json, filtrando pelo grupo de dados desejado
		return (JSONObject) jsonDataObject.get(dataGroup);
		
	}
	

}

/*
 * //criando método que recebe o nome do arquivo json e o nome do grupo de dados
 * desejado protected JSONObject getJsonDataObject(String jsonFileName, String
 * dataGroup) {
 * 
 * // criando um parses para utilizamos no momento da leitura do arquivo json
 * JSONParser parser = new JSONParser();
 * 
 * // criando um objeto json que vai receber os dados do arquivo json JSONObject
 * jsonDataObject = null; try { // inserindo o arquivo json em um objeto Object
 * jsonFileObject = parser.parse(new FileReader(System.getProperty("user.dir") +
 * File.separator + "src" + File.separator + "main" + File.separator + "java" +
 * File.separator + "data" + File.separator + jsonFileName));
 * 
 * // convertendo o objeto com o arquivo json para o formato de objeto json
 * jsonDataObject = (JSONObject) jsonFileObject; } catch (IOException |
 * ParseException e) { e.printStackTrace(); }
 * 
 * // garantindo que o objeto json não está nulo assert jsonDataObject != null;
 * 
 * // retornando o objeto json, filtrando pelo grupo de dados desejado return
 * (JSONObject) jsonDataObject.get(dataGroup);
 */