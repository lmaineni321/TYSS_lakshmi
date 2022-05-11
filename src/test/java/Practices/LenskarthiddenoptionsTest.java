package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LenskarthiddenoptionsTest {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://lenskart.com");
		
		driver.findElement(By.id("wzrk-cancel")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("q")).click();
		
		WebElement ops = driver.findElement(By.xpath("//div[@class=\"trending_block\"]"));
		
		System.out.println(ops.getText());

	}

}
