package com.vtiger.generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PropertyFiles {
	
	public WebDriver driver;

	public PropertyFiles(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String readdatafrompropertyfile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("G:\\Selenium_Automation\\TYSS-LAKSHMI\\common.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}

}
