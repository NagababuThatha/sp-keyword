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
import com.training.pom.MemberpaymentPOM;
import com.training.pom.UserloginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_042tests{

	private WebDriver driver;
	private String baseUrl;
	private MemberpaymentPOM memberpaymentPOM;
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
		memberpaymentPOM=new MemberpaymentPOM(driver);
		loginPOM = new AdminloginPOM(driver); 
		//userloginPOM = new userloginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	@Test
	public void validLoginTest() throws AWTException, InterruptedException  {
		memberpaymentPOM.sendUserName("abcde");
		
		memberpaymentPOM.sendpassword();
		memberpaymentPOM.clickLoginBtn();
		Thread.sleep(2000);
		memberpaymentPOM.clickaccountBtn();
		Thread.sleep(2000);
		memberpaymentPOM.clickpaymentBtn();
		Thread.sleep(2000);
		memberpaymentPOM.sendmemberUserName("nagababu001");
		Thread.sleep(2000);
	
		memberpaymentPOM.sendamount("5000");
		Thread.sleep(2000);
		//memberpaymentPOM.clicktypeBtn();
		memberpaymentPOM.senddescription("birth day gift");
		Thread.sleep(2000);
		memberpaymentPOM.clicksubmitBtn(); 
		Thread.sleep(2000);
		memberpaymentPOM.clicksubmit1Btn();
		Thread.sleep(2000);
		memberpaymentPOM.clicklogoutBtn();
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		loginPOM.sendUserName("admin");

		loginPOM.sendpassword();
		loginPOM.clickLoginBtn(); 
		memberpaymentPOM.sendmemberUserName("abcde");
		Thread.sleep(2000);
		memberpaymentPOM.clickaccountinfo();
	Thread.sleep(2000);
		String title=driver.findElement(By.xpath("//td[contains(text(),'Account balance')]")).getText();

		
		String expectedtitle="Account balance";
		
		
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
