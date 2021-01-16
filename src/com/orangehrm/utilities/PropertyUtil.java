package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
	
	static Properties prop;
	public static void initializePropert() throws IOException {
		String path = System.getProperty("user.dir");
		File file = new File(path+"\\resources\\config\\Orangehrm.properties");
		FileInputStream fis = new FileInputStream(file);
		 prop = new Properties();
		prop.load(fis);	
	}

	public static String readProperty(String key)  {
		return prop.getProperty(key);
		
	

		
	}

}
