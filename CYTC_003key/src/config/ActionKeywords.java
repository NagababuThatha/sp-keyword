package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActionKeywords 
{
	public static WebDriver driver;
	public static void openBrowser()
	{ 
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares Required For Testing Batch\\Testing Softwares\\seleniumGH20software\\chromedriver_win32 (1)\\chromedriver.exe");
		 driver=new ChromeDriver();
	}

	 public static void navigate()
	 { 
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get("http://localhost:8585/");
	 }
	 public static void Input_Username()
	 {
		 driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
	 }
	 public static void Input_password()
	 {
		 driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
			driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
			driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();
			driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click();
	 }
	 public static void click_login()
	 {
		 driver.findElement(By.xpath("//div[@id='virtualKeyboard']//div//input[@class='button']")).click();
	 }
	 
	 public static void Input_member()

	 {
		 driver.findElement(By.xpath("//input[@id='memberUsername']")).sendKeys("nagababu001");
	 }
	 
	 public static void click_member()
	 {
		 driver.findElement(By.xpath("//body[@class='main']//tr//tr[2]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[2]//td[2]//input[1]")).click();
	 }
	 
	 public static void click_group()
	 {
		 driver.findElement(By.xpath("//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/select/option[4]")).click();
	 }
	 
	 public static void Input_description()
	 {
		 driver.findElement(By.xpath("//textarea[@id='comments']")).sendKeys("full access to the member");
	 }
	 
	 public static void click_submit()
	 {
		 driver.findElement(By.xpath("//table[@class='defaultTable']//input[@class='button']")).click();
	 }
	 
	 public static void click_popok()
	 {
		 Alert alert1=driver.switchTo().alert();
	     alert1.accept();	 }
}
