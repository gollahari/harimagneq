package com.testng.selenium.java;

import org.testng.annotations.Test;

public class Groups {
	
	@Test(groups= {"smoke","sanity"})
	public void test1()
	{
		System.out.println("Printing Test1");
	}
	@Test(groups= {"sanity","regression"})
	public void test2()
	{
		System.out.println("Printing Test2");
	}
	@Test(groups= {"sanity","retesting"})
	public void test3()
	{
		System.out.println("printing Test3");
	}
	@Test
	public void test4()
	{
		System.out.println("printing Test4");
	}

}
