package com.vtiger.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.objrepo.CreateNewOrgPage;
import com.vtiger.objrepo.HomePage;
import com.vtiger.objrepo.LoginPage;
import com.vtiger.objrepo.OrgInfoPage;
import com.vtiger.generic.JavaUtil;
import com.vtiger.generic.PropertyFiles;
import com.vtiger.generic.TestData;
import com.vtiger.generic.WebDriverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01_CreateOrg {
	public WebDriver driver;

	@Test
	public void createorg () throws Throwable {

		// Launch Browser and login

		PropertyFiles proppertyFiles= new PropertyFiles(driver);

		String BROWSER=proppertyFiles.readdatafrompropertyfile("browser");

		if (BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("Invalid input");
		}

		driver.get(proppertyFiles.readdatafrompropertyfile("url"));

		LoginPage loginPage = new LoginPage(driver);
		loginPage.logintoApp();

		WebDriverUtil webDriverUtil = new WebDriverUtil(driver);

		webDriverUtil.maxwindow();
		webDriverUtil.pageloadtimeout();
		HomePage homePage = new HomePage(driver);

		homePage.getOrglink().click();

		OrgInfoPage orgInfoPage= new OrgInfoPage(driver);
		orgInfoPage.getCreateorgbtn().click();

		TestData testData= new TestData();
		JavaUtil javaUtil = new JavaUtil();
		String orgname=testData.getOrganizationName()+javaUtil.createRandomnumber();
	
		CreateNewOrgPage createNewOrgPage = new CreateNewOrgPage(driver);

		createNewOrgPage.getOrgname().sendKeys(orgname);
		createNewOrgPage.getSaveorgbtn().click();
		
		Thread.sleep(4000);
		driver.navigate().refresh();

		homePage.getOrglink().click();
		
		orgInfoPage.searchforOrg(orgname, "accountname");

		Thread.sleep(3000);

		String actualorgname=orgInfoPage.getfirstOrg().getText();


		if (orgname.equals(actualorgname)) 
		{
			System.out.println("Tc Passes");
		}
		else {
			System.out.println("TC Fail");
		}

		
		homePage.logoutfromApp();

		Thread.sleep(10000);

		driver.close();
	}

}