package Practices;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Testdata {
	@Test
	public void testdata()
	{
	WebDriver d=new ChromeDriver();
	d.get("http://localhost:8888");
	d.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("admin");
	d.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin");
	
	d.findElement(By.xpath("//input[@id=\"submitButton\"]")).submit();

	d.findElement(By.xpath("(//a[text()=\"Organizations\"])[1]")).click();
	d.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
	Faker f=new Faker();
	d.findElement(By.name("accountname")).sendKeys(f.name().firstName());
	d.findElement(By.xpath("(//input[@class=\"crmbutton small save\"])[1]")).click();
	
	d.findElement(By.xpath("(//a[text()=\"Opportunities\"])[1]")).click();
	d.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
	
	WebElement add=d.findElement(By.name("sales_stage"));
	Select s=new Select(add);
    s.selectByValue("Prospecting");
	
	d.findElement(By.name("potentialname")).sendKeys(f.name().firstName());
	d.findElement(By.xpath("(//img[@src=\"themes/softed/images/select.gif\"])[1]")).click();
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
