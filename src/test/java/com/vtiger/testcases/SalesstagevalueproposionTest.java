package com.vtiger.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SalesstagevalueproposionTest {
	@Test
	public void salesstagetest() throws Throwable
	{
		WebDriver d=new ChromeDriver();
		d.get("http://localhost:8888");
		d.manage().window().maximize();
		d.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("admin");
		d.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin");
		//input[@type="text"]
		d.findElement(By.xpath("//input[@id=\"submitButton\"]")).submit();
		d.findElement(By.xpath("//a[text()=\"Opportunities\"]")).click();
		d.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		WebElement add=d.findElement(By.name("sales_stage"));
		Select s=new Select(add);
//		s.selectByVisibleText("Value Proposition");
//		s.selectByIndex(4);
//		s.selectByIndex(5);
//		s.selectByIndex(6);
		s.selectByIndex(7);
		d.findElement(By.name("potentialname")).sendKeys("lakshmi");
		d.findElement(By.xpath("(//img[@src=\"themes/softed/images/select.gif\"])[1]")).click();
//string str=d.getWindowHandle();
//System.out.println(str);
//d.switchTo().window(str);
		Set<String> str=d.getWindowHandles();
		System.out.println(str);
		Iterator<String> iterator=str.iterator();
		String pw=iterator.next();
		String cw=iterator.next();
		d.switchTo().window(cw);
        d.findElement(By.id("1")).click();
        d.switchTo().window(pw);
		
		d.findElement(By.xpath("(//input[@class=\"crmbutton small save\"])[1]")).click();
		Actions a=new Actions(d);
		WebElement add1=d.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		a.moveToElement(add1).perform();
		d.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		d.close();
	}

}
