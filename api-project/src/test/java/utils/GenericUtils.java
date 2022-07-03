package utils;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GenericUtils {
	//Updating Utils
	public static String getPropertyValue(String fileName, String key)
	{
		String urlVal=null;
		try {
			FileReader reader = new FileReader("src/test/resources/"+fileName+".properties");
			Properties properties =new Properties();
			properties.load(reader);
		    urlVal = properties.getProperty(key);		
			System.out.println("URL from properties is : "+ urlVal);
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return urlVal;
	}
}
