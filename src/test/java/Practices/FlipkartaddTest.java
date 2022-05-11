package Practices;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartaddTest {

	public static void main(String[] args) throws Throwable {
	
		WebDriver d=new ChromeDriver();
	
		d.get("http://flipkart.com");
		d.findElement(By.xpath("//button[text()='✕']")).click();
        d.findElement(By.name("q")).sendKeys("mobiles");
        d.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        Thread.sleep(3000);
        d.findElement(By.xpath("//div[text()='POCO C31 (Royal Blue, 64 GB)']")).click();
        d.findElement(By.xpath("(//div[@class=\"_2kHMtA\"])[1]")).click();
        Set<String> str=d.getWindowHandles();
		System.out.println(str);
		Iterator<String> iterator=str.iterator();
		String pw=iterator.next();
		String cw=iterator.next();
		d.switchTo().window(cw);
		WebElement val = d.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']"));
		System.out.println("before add: "+val.getText());
		d.findElement(By.xpath("//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")).click();
		d.switchTo().window(pw);
		Thread.sleep(2000);
//		d.findElement(By.xpath("//span[.='Cart']")).click();   //span[.='Cart']
	    d.manage().window().maximize();
		d.findElement(By.xpath("//span[.='Cart']")).click();
		Thread.sleep(2000);
		 WebElement add = d.findElement(By.xpath("//button[text()='+']"));
	     Point loc = add.getLocation();
		JavascriptExecutor jse=(JavascriptExecutor)d;
	    jse.executeScript("window.scrollBy"+loc);
	    
	     add.click();
	     Thread.sleep(4000);
	     WebElement val2 = d.findElement(By.xpath("//span[@class='_2-ut7f _1WpvJ7']"));
	     System.out.println("After adding: "+val2.getText());
	     d.quit();
	    
		
	}

	
}

