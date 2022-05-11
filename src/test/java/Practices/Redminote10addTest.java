package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Redminote10addTest {

	public static void main(String[] args) throws Throwable {
		WebDriver d=new ChromeDriver();
		
		d.get("http://flipkart.com");
		d.manage().window().maximize();
		d.findElement(By.xpath("//button[text()='✕']")).click();
        d.findElement(By.name("q")).sendKeys("REDMI NOTE 10 Pro");
        d.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        Thread.sleep(3000);
        WebElement add = d.findElement(By.xpath("(//div[text()='REDMI Note 10 Pro (Dark Night, 128 GB)']/ancestor::div[@class=\"_3pLy-c row\"]//div[@class='_30jeq3 _1_WHN1'])[1]"));
       Point loc = add.getLocation();
      
        JavascriptExecutor jse=(JavascriptExecutor)d;
	    jse.executeScript("window.scrollBy"+loc);
	   System.out.println(add.getText());
	   String s1=add.getText();
	   String fprice=s1.replaceAll("[^a-zA-Z0-9]", "");
	   d.close();
	   WebDriver d2=new ChromeDriver();
	   d2.get("https://www.amazon.in/");
	   d2.manage().window().maximize();
	   d2.findElement(By.id("twotabsearchtextbox")).sendKeys("RED MI NOTE 10 PRO");
	   d2.findElement(By.id("nav-search-submit-button")).click();
	   WebElement add2 = d2.findElement(By.xpath("//span[text()='Redmi Note 10 Pro (Dark Night, 6GB RAM, 128GB Storage) -120hz Super Amoled Display|64MPwith 5mp Super Tele-Macro | 33W Charger Included']/ancestor::div[@class=\"a-section a-spacing-small a-spacing-top-small\"]//span[@class=\"a-price-whole\"]"));
	   System.out.println(add2.getText());
	   String s2=add2.getText();
	   String aprice=s2.replaceAll("[^a-zA-Z0-9]", "");
	   int a=Integer.parseInt(fprice);
	   int b=Integer.parseInt(aprice);
	   System.out.println(a+"\n"+b);
	   if(a>b)
	   {
		   System.out.println("amazon price is cheaper");
	   }
	   else if(a<b)
	   {
		 System.out.println("flipkart price is cheaper");  
		   
	   }
	   else
	   {
		   System.out.println("both prices are equal");   
	   }
	   
	}

}
