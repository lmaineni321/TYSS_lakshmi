package com.testng.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleHardAssert {

	@Test
	public void org()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		WebElement un=driver.findElement(By.name("user_name"));
		boolean unvalue=un.isDisplayed();
		
		Assert.assertEquals(unvalue, true);
		un.sendKeys("admin");
		
		WebElement pwd=driver.findElement(By.name("user_password"));
		boolean pwdvalue=un.isDisplayed();
		
		Assert.assertEquals(pwdvalue, true);
		pwd.sendKeys("admin");
		
		WebElement loginbtn=driver.findElement(By.id("submitButton"));
		loginbtn.click();
		
		
	}
}
