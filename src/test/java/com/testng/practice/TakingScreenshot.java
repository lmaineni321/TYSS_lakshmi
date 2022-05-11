package com.testng.practice;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;


public class TakingScreenshot {

	@Test
	public void screenshot() throws Throwable
	{
	WebDriver driver=new ChromeDriver();
	driver.get("http:localhost:8888");
	
	 TakesScreenshot screenshot=(TakesScreenshot)driver;
	 File src=screenshot.getScreenshotAs(OutputType.FILE);
	 File dest=new File("G:\\Selenium_Automation\\TYSS-LAKSHMI\\screenshot/vtiger.png");
	 Files.copy(src, dest);
}
}