package Practices;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlipkartseachitemsTest {

	public static void main(String[] args) {
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("http://amazon.in");
		WebElement add = d.findElement(By.id("searchDropdownBox"));
		add.click();
		Random r=new Random();
		int no=r.nextInt(80);
		System.out.println(no);
		Select s=new Select(add);
        s.selectByIndex(no);
   //     d.close();
	}

}
