package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrganisationemailoptoutTest {
	@Test
	public void orgemailoptoutTest()
	{
		WebDriver d=new ChromeDriver();
		d.get("http://localhost:8888");
		d.manage().window().maximize();
		d.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("admin");
		d.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin");
		d.findElement(By.xpath("//input[@id=\"submitButton\"]")).submit();
		d.findElement(By.xpath("//a[text()=\"Organizations\"]")).click();
		d.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		WebElement val=d.findElement(By.name("emailoptout"));
		if(val.isEnabled())
		{
			System.out.println("is enabled");
		}
		else
		{
			System.out.println("is disabled");
		}
	}
	

}
