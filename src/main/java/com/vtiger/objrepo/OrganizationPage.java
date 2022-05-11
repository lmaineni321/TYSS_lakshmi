package com.vtiger.objrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtil;

public class OrganizationPage {
	
	WebDriver driver;

	public OrganizationPage() {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[.='Organizations']")
	private WebElement orglnk;
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorgimage;
	
	@FindBy(name="search_text")
	private WebElement searchtextfld;
	
	@FindBy(name="search_Field")
	private WebElement searchtypedd;
	
	@FindBy(name="submit")
	private WebElement submitbtn;
	
	@FindBy(name="accountname")
	private WebElement orgnametb;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public WebElement getOrglnk() {
		return orglnk;
	}

	public WebElement getCreateorgimage() {
		return createorgimage;
	}

	public WebElement getSearchtextfld() {
		return searchtextfld;
	}

	public WebElement getSearchdd() {
		return searchtypedd;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public WebElement getOrgnametb() {
		return orgnametb;
	}
	
	public WebElement getSavebtn() {
		return savebtn;
	}

	WebDriverUtil wdu=new WebDriverUtil(driver);
	
	public void searchOrg(String orgname,String value)
	{
		orglnk.click();
		searchtextfld.sendKeys(orgname);
		wdu.selectValuefromdd(searchtypedd, value);
		submitbtn.click();
	}
	public void createOrg(String orgname)
	{
		orglnk.click();
		createorgimage.click();
		searchtextfld.sendKeys(orgname);
		savebtn.click();
		
	}

}
