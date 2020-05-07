package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonHandler {

	public JSONObject getDataFile(String fileName, String block) throws IOException, ParseException {

		JSONArray jsonList = null;
		JSONObject object = null;
		JSONParser jsonParser = new JSONParser();

		try (InputStream inputStream = getClass().getResourceAsStream("/" + fileName);
				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

			Object obj = jsonParser.parse(br);
			jsonList = (JSONArray) obj;
			// System.out.println(jsonList); // Isso imprime o arquivo json inteiro
			for (int i = 0; i < jsonList.size(); i++) {
				JSONObject objects = (JSONObject) jsonList.get(i);
				object = (JSONObject) objects.get(block);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		return object; // the entire json file
	}

}