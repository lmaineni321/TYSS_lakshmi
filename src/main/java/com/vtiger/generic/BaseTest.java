package com.vtiger.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {


	
	 public static WebDriver driver;
	 
	 public void openBrowser() throws Throwable
	
	 {
		PropertyFiles prop = new PropertyFiles(driver);
		
		String BROWSER=	prop.readdatafrompropertyfile("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("No Browser Provided Launching Default browser");
			driver= new ChromeDriver();
		}

		driver.get(prop.readdatafrompropertyfile("url"));

		driver.findElement(By.name("user_name")).sendKeys(prop.readdatafrompropertyfile("username"));
		driver.findElement(By.name("user_password")).sendKeys(prop.readdatafrompropertyfile("password"));
        driver.findElement(By.id("submitButton")).click();
	}

}
