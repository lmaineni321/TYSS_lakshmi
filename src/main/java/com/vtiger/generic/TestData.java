package com.vtiger.generic;

import com.github.javafaker.Faker;

public class TestData {
	
	/**
	 * this mtd gonna create fake data for the firstname
	 * 
	 * @return String firstname
	 * 
	 */
	public String getFirstname()
	{
		Faker f=new Faker();
		String fn=f.name().firstName();
		
		return fn;
		
	}
	
	/**
	 * this method will return name of the city
	 * 
	 * @return String cityname
	 */
	public String cityname()
	{
		Faker f=new Faker();
		String cn=f.address().cityName();
		return cn;
	}
	
	public String getOrganizationName()
	{
		Faker fk=new Faker();
			String orgname = fk.company().industry();
				return orgname;
	}
	
	public String getLastname()
	{
		Faker f=new Faker();
		String ln=f.name().lastName();
		
		return ln;
	

	
	}
	
	

}
