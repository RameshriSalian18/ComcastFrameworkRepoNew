package jsonPack;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		// Step 1: Parse Json physical file in to Java Object using Json Parser class
		JSONParser parser =new JSONParser();
		Object obj = parser.parse(new FileReader("./TestData/JSONcommondata.json"));
		
		// Step 2: Convert Java Object into JsonObject using downcasting 
		 JSONObject map = (JSONObject)obj;
		 
		 // Step 3: Get the value from json file using key 
		 System.out.println(map.get("url"));
		 System.out.println(map.get("browser"));
		 System.out.println(map.get("username"));
		 System.out.println(map.get("password"));
		 System.out.println(map.get("timeOut"));
		

	}

	

}
