package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.generic.Excelutility;

public class Tc_001 {

	public static void main(String[] args) throws Throwable {
	
		WebDriver d=new ChromeDriver();
		d.get("http:localhost:8888");
		Excelutility eu=new Excelutility();
		String un=eu.readdatafromexcel("Sheet2", 0, 0);
        double pwd=eu.readnumericdata("Sheet2", 1, 0);
        System.out.println(un);
        System.out.println(pwd);
        int intval=(int) Math.round(pwd);
        System.out.println(intval);
        String pwd2=Integer.toString(intval);
        System.out.println(pwd2);
        d.findElement(By.name("user_name")).sendKeys(un);
        d.findElement(By.name("user_password")).sendKeys(pwd2);
	}

}
