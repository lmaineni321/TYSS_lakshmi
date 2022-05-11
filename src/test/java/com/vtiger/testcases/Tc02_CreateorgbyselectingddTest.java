package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.TestData;
import com.vtiger.generic.WebDriverUtil;

public class Tc02_CreateorgbyselectingddTest extends BaseTest {

	public static void main(String[] args) throws Throwable {
		BaseTest b=new BaseTest();
	    b.openBrowser();
	   
	    driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	    WebDriverUtil wdu=new WebDriverUtil(driver);
	    wdu.pageloadtimeout();
	    wdu.maxwindow();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		TestData td=new TestData();
		String orgname=td.getOrganizationName();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		WebElement dd1value = driver.findElement(By.name("industry"));
        wdu.selectValuefromdd("Education", dd1value);
        WebElement dd2value = driver.findElement(By.name("accounttype"));
        wdu.selectValuefromdd("Customer", dd2value);
        WebElement dd3value = driver.findElement(By.name("rating"));
        wdu.selectValuefromdd("Active", dd3value);

        
        driver.findElement(By.name("button")).click();
        Thread.sleep(4000);


        driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		WebElement dd4value = driver.findElement(By.id("bas_searchfield"));
		 wdu.selectValuefromdd("Organization Name", dd4value);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 Thread.sleep(4000);
         String text = driver.findElement(By.xpath("//a[@title=\"Organizations\"]")).getText();
	     System.out.println(text);
	    if(orgname.equalsIgnoreCase(text))
	    {
	    	System.out.println("verified successfully");
	    }
	    else
	    {
	    	System.out.println("name not matched or not created ");
	    }
	    WebElement logout = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
        wdu.moveToelement(logout);
       
        driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
        Thread.sleep(8000);
        driver.close();
	}

}
