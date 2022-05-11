package com.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunchTest {
	@Test
	public void browserlaunch()
	{
	   WebDriverManager.chromedriver().setup();
	   WebDriver d=new ChromeDriver();
//	   d.get("https://flipkart.com");
	   d.get("http://localhost:8888");
	   d.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("admin");
		d.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin");
		d.findElement(By.xpath("//input[@id=\"submitButton\"]")).submit();
		d.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
		d.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		 Faker f=new Faker();
		d.findElement(By.name("lastname")).sendKeys(f.name().lastName());
	  
//	  System.out.println(f.address());
	  
	   
		
	}

}
