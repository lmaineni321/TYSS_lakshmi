package Practices;

import java.io.FileInputStream;
import java.util.Properties;

public class Propertyfile {
	
	public String readdatafrompropertyfile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./exldata.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}

}
