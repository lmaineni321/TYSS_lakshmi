package com.testng.practice;

import org.testng.annotations.Test;

public class Test2 extends Annotations {

	@Test(groups = {"smoke"})
	public void testIOSapp() {
		System.out.println("testIOSapp");

	}
	@Test(groups = {"regression"},enabled = false)
	public void testdesktopapp() {
		System.out.println("testdesktopapp");
		
	}
}
