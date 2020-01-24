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
import com.training.pom.PermissionsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_003tests {

	private WebDriver driver;
	private String baseUrl;
	private AdminloginPOM loginPOM;
	private PermissionsPOM permissionsPOM;
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
	   permissionsPOM = new PermissionsPOM(driver);
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
		permissionsPOM.sendmemberUserName("nagababu001");
		Thread.sleep(3000);
		permissionsPOM.clicksubmit1();
		Thread.sleep(2000);
		permissionsPOM.clicknewgroup();
		Thread.sleep(2000);
		permissionsPOM.clickfullmembers();
		Thread.sleep(2000);
		permissionsPOM.sendcomments("full access to the member");
		Thread.sleep(2000);
		permissionsPOM.clicksubmit2();
		Thread.sleep(2000);
		Alert alert1=driver.switchTo().alert();
		String alerttitle=driver.switchTo().alert().getText();
		System.out.println("Alert title is:"+alerttitle);
		String expectedtitle="The member's group was changed, however, the activation mail could not be sent";
		Assert.assertEquals(alerttitle, expectedtitle);
		Thread.sleep(2000);
		 alert1.accept();
		//screenShot.captureScreenShot("First");
		
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
	
	}
}
