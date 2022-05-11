package com.testng.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseClass;
import com.vtiger.generic.JavaUtil;
import com.vtiger.generic.TestData;
import com.vtiger.objrepo.CreateNewOrgPage;
import com.vtiger.objrepo.HomePage;
import com.vtiger.objrepo.OrgInfoPage;

public class Tc_01CreateOrgBase  extends BaseClass{
	
	@Test
	public void createorg () throws Throwable
	{
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
		
		Assert.assertEquals(actualorgname, orgname);

//		if (orgname.equals(actualorgname)) 
//		{
//			System.out.println("Tc Passes");
//		}
//		else {
//			System.out.println("TC Fail");
//		}
	}

}
