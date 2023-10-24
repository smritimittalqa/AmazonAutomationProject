package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

	Properties prop;
	FileInputStream fs;
	String path = "/Users/smritimittal/Downloads/JAVA/summer 2023/Amazonproject/config.properties";
	
	public Properties readPropertyObject() {
		try {
			fs = new FileInputStream(path);
			prop = new Properties();
			prop.load(fs);
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	
}
