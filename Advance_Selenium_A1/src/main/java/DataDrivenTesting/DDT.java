package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

public class DDT {

	public static void main(String[] args) throws IOException {
		
		FileInputStream  fls = new FileInputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\DDT.properties");
		Properties pObj = new Properties();
		
		pObj.load(fls);
		
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		

	}

}
