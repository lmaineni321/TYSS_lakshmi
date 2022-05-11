package com.testng.practice;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseClass;
import com.vtiger.generic.TestData;
import com.vtiger.generic.WebDriverUtil;
import com.vtiger.objrepo.ContactInfoPage;
import com.vtiger.objrepo.ContactOrg_Popup;
import com.vtiger.objrepo.CreateNewContactPage;
import com.vtiger.objrepo.HomePage;

public class TC03_CreateContact_orgBase extends  BaseClass {
	@Test
	public void createcontact_org() throws IOException, InterruptedException 
	{
		WebDriverUtil webDriverUtil = new WebDriverUtil(driver);

		HomePage homePage = new HomePage(driver);
		homePage.getContactslink().click();

		ContactInfoPage conatctInfoPage = new  ContactInfoPage(driver);
		conatctInfoPage.getCreatecontactsimg().click();
		TestData testData= new TestData();

		String contactname=testData.getLastname();

		System.out.println(contactname);

		CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver);
		createNewContactPage.getLastNameEdt().sendKeys(contactname);

		createNewContactPage.getOrganizationLookUpImage().click();

		Thread.sleep(2000);
		webDriverUtil.switchWindow("Accounts");

		Thread.sleep(4000);

		ContactOrg_Popup contactOrg_popup = new ContactOrg_Popup(driver);

		contactOrg_popup.searchandSelectforOrg("Judiciary");

		Thread.sleep(2000);
		webDriverUtil.switchWindow("Contacts");

		createNewContactPage.getSaveBtn().click();

		Thread.sleep(8000);

		String contactid=createNewContactPage.getcontactid().getText();

		System.out.println(contactid);
		driver.navigate().refresh();

		homePage.getContactslink().click();

		conatctInfoPage.checkcontactcreated(contactid);

		Thread.sleep(4000);

		String actualcontactlastname=conatctInfoPage.getactualcontact().getText();

		System.out.println(actualcontactlastname);
		
		Assert.assertEquals(actualcontactlastname,contactname );

//		if (actualcontactlastname.equals(contactname)) 
//		{
//			System.out.println("Tc Passes");
//		}
//		else {
//			System.out.println("TC Fail");
//		}
	}
}
