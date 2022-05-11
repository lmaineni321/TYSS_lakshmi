package com.vtiger.testcases;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FuturedateTest {
	@Test
	public void futuredate() throws Throwable
	{
	
	
	Date date = new  Date();

			String currentdate=date.toString();
			System.out.println(currentdate);      //Fri Apr 29 12:17:27 IST 2022
			
			//Thu Apr 28 18:09:03 IST 2022
			// 0   1   2    3      4    5 
			// Thu Apr 28 2022
			
			String[] arr = currentdate.split(" ");
			
			String day= arr[0];
			String month= arr[1];
			String dt= arr[2];
			String year = arr[5];
			
			String xpath= day+" "+month+" "+dt+" "+year;
			
			System.out.println(xpath);

//			WebDriverManager.chromedriver().setup();

			WebDriver driver = new ChromeDriver();

			driver.get("https://www.makemytrip.com/");

			driver.manage().window().maximize();
			
			//this method is valid for the version of selenium 4.X
			
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
			
			driver.findElement(By.xpath("//li[@data-cy=\"account\"]")).click();
			
			
			driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();

			Thread.sleep(1000);
//			driver.findElement(By.xpath("//div[@aria-label='"+xpath+"']")).click();
			driver.findElement(By.xpath("//div[@aria-label=\"Sat Apr 30 2022\"]")).click();
			
		}
}
