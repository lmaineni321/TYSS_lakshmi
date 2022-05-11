package Practices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Olympics {
	
	public void olympic() throws Throwable {
	
	WebDriver d=new ChromeDriver();
	d.manage().window().maximize();
	d.get("https://olympics.com");
	
	
	
	}

}
