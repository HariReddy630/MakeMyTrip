package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.testng.Assert;

public class PropertyData {
public static HashMap<String, String> properties(String propertyFilePath){
		
		HashMap<String, String> propertyData = new HashMap<String, String>();
		
		
		try {
			InputStream is = new FileInputStream(propertyFilePath);
			Properties props = new Properties();
			props.load(is);
			
			Set<Object> allKeys = props.keySet();
			
			for (Object keyName: allKeys) {
				propertyData.put(keyName.toString(), props.getProperty(keyName.toString()));
				 
			}
			
			
			
		} catch (IOException e) {
			Assert.assertTrue(false, "File is not found in the given location");
		}
		
		return propertyData;
		
	}

}
