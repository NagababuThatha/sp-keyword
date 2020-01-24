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
import com.training.pom.AddressPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_005tests{

	private WebDriver driver;
	private String baseUrl;
	private AddressPOM addresschangePOM;
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
		addresschangePOM=new AddressPOM(driver);
		//userloginPOM = new userloginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	@Test
	public void validLoginTest() throws AWTException, InterruptedException  {
		addresschangePOM.sendUserName("abcde");
		
		addresschangePOM.sendpassword();
		addresschangePOM.clickLoginBtn();
		Thread.sleep(2000);
		addresschangePOM.clickprofile();
		Thread.sleep(2000);
		addresschangePOM.clickchange();
		Thread.sleep(2000);
		addresschangePOM.clickaddress();;
		Thread.sleep(2000);
		addresschangePOM.sendaddress("singsandra");
		addresschangePOM.clickSubmitBtn();
		Thread.sleep(2000);
		Alert alert1=driver.switchTo().alert();
		String alerttitle=driver.switchTo().alert().getText();
		System.out.println("Alert title is:"+alerttitle);
		String expectedtitle="Profile modified";
		Assert.assertEquals(alerttitle, expectedtitle);
		Thread.sleep(2000);
		 alert1.accept();
		 Thread.sleep(2000);
		//String title=driver.findElement(By.xpath("//*[contains(text(),'Quick access')]")).getText();

		
		//String expectedtitle="Quick access";
		
		
		//Assert.assertEquals(expectedtitle,title ); 
		//System.out.println(title);
		screenShot.captureScreenShot("First");
		
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.close();
	}
}
