package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PurchaseorderApprovedTest {
	@Test
	public void purchaseorderapprovedtest()
	{
		WebDriver d=new ChromeDriver();
		d.get("http://localhost:8888");
		d.manage().window().maximize();
		d.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("admin");
		d.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin");
		d.findElement(By.xpath("//input[@id=\"submitButton\"]")).submit();
		WebElement add=d.findElement(By.xpath("//a[text()=\"More\"]"));
		Actions a=new Actions(d);
		a.moveToElement(add).perform();
		d.findElement(By.name("Purchase Order")).click();
		d.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		WebElement add1=d.findElement(By.name("postatus"));
		Select s=new Select(add1);
//		s.selectByValue("Approved");
//		s.selectByValue("Created");
//		s.selectByValue("Cancelled");
//		s.selectByValue("Delivered");
		s.selectByValue("Received Shipment");
		Actions a1=new Actions(d);
		WebElement add2=d.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		a1.moveToElement(add2).perform();
		d.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		d.close();
	}

}
