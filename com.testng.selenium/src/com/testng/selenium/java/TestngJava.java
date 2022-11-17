package com.testng.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestngJava {
	  WebDriver driver;
      @BeforeSuite
      public void beforesuite()
      {
    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\sriha\\eclipse-workspace\\com.qa.seleniumjava\\drivers\\chromedriver.exe");
    	 driver = new ChromeDriver();
    	 
      }
      @Test
      public void test()
      {
    	  driver.get("http://www.google.com/");
      }
      @Test
      public void operation()
      {
    	 driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("nani");
      }
}
