package TestNgAttributes;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseOrCommon.CommonMethods;

public class Attribute_DataProvider extends CommonMethods{

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
	
	@DataProvider(name ="loginCredentials")
	public Object getCredentials() {
		
		Object[][] values = new Object[3][2];
		
		values[0][0] = "Admin";
		values[0][1] = "admin123";
		
		values[1][0] = "Admin";
		values[1][1] = "admin123";
		
		values[2][0] = "Admin";
		values[2][1] = "admin123";
		
		return values;
		
	}
	
	@Test(priority = 1, dataProvider = "loginCredentials")
	public void addCredentials(String username, String password) {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
			
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			
		System.out.println("i am in addCredentials method");	
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
