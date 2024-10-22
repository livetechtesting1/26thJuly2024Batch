package TestNgAttributes;


import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import BaseOrCommon.CommonMethods;

public class Attribute_Timeout extends CommonMethods{

	@BeforeSuite
	public void launchBrowser() {

		browserLaunching("chrome");

		System.out.println("i am in @BeforeSuite method");
	}

	
	@BeforeClass
	public void launchURL() {
		
		urlLaunching("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		browserMaximize();		
		
		System.out.println("i am in @BeforeClass method");		
	}
	
	@BeforeMethod
	public void waitingTime() {
		
		waits();
		
		System.out.println("i am in @BeforeMethod method");		

	}
	
	@Test(priority = 1, timeOut = 5000)
	public void enterUsername() {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		
		System.out.println("i am in enterUsername method");	
	}
	
	@Test(priority = 2)
	public void enterPassword() {
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		
		System.out.println("i am in enterPassword method");	
	}
	

	@Test(priority = 3)
	public void clickLogin() {
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("i am in clickLogin method");		
	}
	
	
	@AfterMethod
	public void waitingTime1() {
		
		waits();
		
		System.out.println("i am in @AfterMethod method");		

	}
	
	@AfterSuite
	public void closeBrowser() {

		browserClosing();
		
		System.out.println("i am in @aftersuite method");

	}

}
