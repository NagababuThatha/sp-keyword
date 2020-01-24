package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class CYTC_001tests {

	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerPOM = new RegisterPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	

	@Test
	
	public void validRegisterTest() throws InterruptedException {
		registerPOM.clickSubmitButton();
		registerPOM.sendLoginName("nagababu001");
		registerPOM.sendFullName("nagababu001");
		registerPOM.sendEmail("abcdehgfff@gmail.com");
		//registerPOM.sendbirthday("26-04-1987");
		registerPOM.clickgender();
		registerPOM.sendaddress("Bangalore");
		registerPOM.sendpostalcode("560054");
		registerPOM.sendcity("Bangalore");
		registerPOM.sendphone("7876563669");
		registerPOM.sendmobilephone("7876689229");
		registerPOM.sendfax("9876543210");
		registerPOM.sendurl("www.google.com");
		registerPOM.sendPassword("dhwani123");
		registerPOM.sendconfirmPassword("dhwani123");
		//String str=driver.findElement(By.xpath("//img[@id='captchaImage']")).getText();
		//registerPOM.sendCaptcha(str);
		Thread.sleep(20000);
		registerPOM.clickSubmitBtn();
		String expectedtitle="Thanksforregistering!Youraccounthasbeencreatedandneedstobeactivatedbytheadministration.";
		String title=driver.findElement(By.xpath("//*[contains(text(),'Thanks for registering!')]")).getText();
		StringTokenizer st=new StringTokenizer(title);
		String name="";
		while(st.hasMoreTokens()){
			name=name+st.nextToken();
		}
				
		Assert.assertEquals(name,expectedtitle );
		System.out.println(name);
		
	}
	@AfterMethod
	public void tearDown() throws Exception {
		driver .close();
		
	}
}
