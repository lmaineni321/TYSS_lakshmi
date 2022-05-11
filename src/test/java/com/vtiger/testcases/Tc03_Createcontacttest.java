package com.vtiger.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.TestData;
import com.vtiger.generic.WebDriverUtil;

public class Tc03_Createcontacttest extends BaseTest {
	@Test
	public void createcontact() throws Throwable
	{
		BaseTest b=new BaseTest();
	    b.openBrowser();
	   
	    driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
	    WebDriverUtil wdu=new WebDriverUtil(driver);
	    wdu.pageloadtimeout();
	    wdu.maxwindow();
	    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	    
	    TestData td=new TestData();
	    String name = td.getLastname();
	    driver.findElement(By.name("lastname")).sendKeys(name);
	    System.out.println(name);
	    driver.findElement(By.xpath("//img[@title=\"Select\"]")).click();
	    Set<String> str=driver.getWindowHandles();
		System.out.println(str);
		Iterator<String> iterator=str.iterator();
		String pw=iterator.next();
		System.out.println(pw);
		String cw=iterator.next();
		System.out.println(cw);
		driver.switchTo().window(cw);
//	    String pw = driver.getTitle();
//	    System.out.println("parent="+pw);
//	    
	    driver.findElement(By.xpath("//input[@name=\"search_text\"]")).sendKeys("Judiciary");
	    driver.findElement(By.name("search")).submit();
	    driver.findElement(By.id("1")).click();
	    Thread.sleep(3000);
	    driver.switchTo().window(pw);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    Thread.sleep(9000);
	    String id = driver.findElement(By.xpath("//td[@id='mouseArea_First Name']/../td[4]")).getText();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
	    driver.findElement(By.name("search_text")).sendKeys(id);
	    driver.findElement(By.name("submit")).click();
	    Thread.sleep(4000);
	     String lname = driver.findElement(By.xpath("(//a[@title=\"Contacts\"])[2]")).getText();
	    System.out.println(lname);
	    if(name.equals(lname))
	    {
	    	System.out.println("successful");
	    }
	    else
	    {
	    	System.out.println("failed");
	    }
	   
	}

}
