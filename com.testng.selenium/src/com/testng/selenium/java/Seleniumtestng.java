package com.testng.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Seleniumtestng {
	
	WebDriver driver;
	
	@Parameters("browserName")

	@BeforeTest(groups= {"sanity"})
	public void openBrowser(String browserName)
	{
		switch(browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sriha\\eclipse-workspace\\com.testng.selenium\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sriha\\eclipse-workspace\\com.testng.selenium\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Browser is Invalid");
			break;
		
		}
		driver.manage().window().maximize();
	}
	@Parameters("url")
    @Test(groups= {"smoke","sanity"})
    public void lunchApp(String url)
    {
    	driver.get(url);
    }
    @Parameters({"userName" , "password"})
    @Test(groups={"sanity","regression"})
    public void login(String username,String password) throws InterruptedException
    {
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right margin-right-logo']/li[1]")).click();
    	driver.findElement(By.linkText("User Login")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.id("sign_user_email")).sendKeys(username);
    	driver.findElement(By.id("sign_user_password")).sendKeys(password);
    	driver.findElement(By.xpath("//input[@id='sign_user_password']/following-sibling::button")).click();
    	Thread.sleep(2000);
    }
    @Test(groups= {"smoke","regression"})
    public void loginStatus()
    {
    	String expected ="Welcome, Nani";
    	String actual = driver.findElement(By.linkText("Welcome, Nani")).getText();
    	System.out.println(actual);
    	
    	Assert.assertEquals(actual, expected, "Welcome msg mismatched");
    }
    @Test(groups= {"smoke","retesing"})
    public void logout()
    {
    	driver.findElement(By.partialLinkText("Welcome")).click();
    	driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right margin-right-logo']/descendant::a[text()=' Log Out']")).click();
    	
    }
    @AfterTest
    public void tearDown()
    {
    	driver.close();
    }
    
    
    
	
		

	

}
