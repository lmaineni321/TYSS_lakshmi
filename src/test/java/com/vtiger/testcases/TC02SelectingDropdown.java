package com.vtiger.testcases;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.JavaUtil;
import com.vtiger.generic.TestData;
import com.vtiger.generic.WebDriverUtil;
import com.vtiger.objrepo.CreateNewOrgPage;
import com.vtiger.objrepo.HomePage;
import com.vtiger.objrepo.OrgInfoPage;

public class TC02SelectingDropdown extends BaseTest {

	public static void main(String[] args) throws Throwable {
		BaseTest b=new BaseTest();
	    b.openBrowser();
	   
	    HomePage homePage= new HomePage(driver);
		homePage.getOrglink().click();


		OrgInfoPage orgInfoPage = new OrgInfoPage(driver);
		orgInfoPage.getCreateorgbtn().click();


		TestData testData= new TestData();
		JavaUtil javaUtil = new JavaUtil();
		String orgname=testData.getOrganizationName()+javaUtil.createRandomnumber();
		CreateNewOrgPage createNewOrgPage= new CreateNewOrgPage(driver);

		createNewOrgPage.getOrgname().sendKeys(orgname);
		WebDriverUtil webDriverUtil=new WebDriverUtil(driver);

		webDriverUtil.selectValuefromdd("Active", createNewOrgPage.getRating());

		webDriverUtil.selectValuefromdd(createNewOrgPage.getIndustry(), "Education");

		webDriverUtil.selectValuefromdd(createNewOrgPage.getType(), 3);

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
