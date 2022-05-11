package com.testng.practice;


import org.testng.SkipException;
import org.testng.annotations.Test;

public class Test1 extends Annotations {


	@Test(groups = {"smoke"})
	public void testAndroidapp() {
		System.out.println("testAndroidapp");
 
	}
	@Test(groups = {"sanity"},invocationCount = 0)
	public void testWebapp() {
		System.out.println("testWebapp");
	}

	@Test(groups = {"regression"})
	public void testWebapp1() {
		System.out.println("testWebapp1");
    throw new SkipException("msg");

	}
}