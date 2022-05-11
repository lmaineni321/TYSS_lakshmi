package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HdfcappdropdownTest {

	public static void main(String[] args) throws Throwable {
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.hdfcbank.com/");
		Thread.sleep(3000);
		d.findElement(By.id("nvpush_cross")).click();
		Thread.sleep(3000);
		d.findElement(By.id("onetrust-close-btn-container")).click();

		Thread.sleep(3000);
		d.findElement(By.xpath("//img[@src=\"https://www.hdfcbank.com/static/features/%5BBBHOST%5D/feature-hdfc-slick-slider/media/pop-close.png\"]")).click();
		Thread.sleep(3000);       
		d.findElement(By.xpath("//a[.='Select Product Type']")).click();
		d.findElement(By.xpath("//li[text()='Accounts']")).click();
		Thread.sleep(3000); 
        d.findElement(By.xpath("//a[text()='Select Product']")).click();
        d.findElement(By.xpath("//li[text()='Salary Accounts']")).click();
        d.close();
	}
	
}
