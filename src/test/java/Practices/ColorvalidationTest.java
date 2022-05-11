package Practices;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.support.Color;

		public class ColorvalidationTest {

			public static void main(String[] args) {
				WebDriver driver=new ChromeDriver();
				driver.get("https://www.facebook.com");
				driver.manage().window().maximize();
				String col="#1877f2";
				String Colorn = driver.findElement(By.name("login")).getCssValue("background-color");
				System.out.println(Colorn);
				String Imgcolor = Color.fromString(Colorn).asHex();
				System.out.println(Imgcolor);
				if(col.equals(Imgcolor))
				{
					System.out.println("it is matching");
				}
				else
				{
					System.out.println("Its not matching");
				}

			}

	}


