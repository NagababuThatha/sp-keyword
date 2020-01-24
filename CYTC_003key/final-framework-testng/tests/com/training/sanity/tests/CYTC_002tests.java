package com.training.sanity.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.glass.events.KeyEvent;
import com.training.generics.ScreenShot;
import com.training.pom.AdminloginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_002tests {

	private WebDriver driver;
	private String baseUrl;
	private AdminloginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminloginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	@Test
	public void validLoginTest() throws AWTException, InterruptedException  {
		loginPOM.sendUserName("admin");

		loginPOM.sendpassword();
		loginPOM.clickLoginBtn(); 
		String title=driver.findElement(By.xpath("//span[contains(text(),'Logged user: admin - srikumar')]")).getText();

		
		String expectedtitle="Logged user: admin - srikumar";
		
		
		Assert.assertEquals(expectedtitle,title );  
		System.out.println(title);
		screenShot.captureScreenShot("First");
		
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.close();
	}
}
