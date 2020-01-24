package com.training.pom;

import java.awt.AWTException;
import java.awt.AWTKeyStroke;
import java.awt.Robot;
import java.awt.event.MouseEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MemberpaymentPOM {
	private WebDriver driver; 
	
	public MemberpaymentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="//div[@id='virtualKeyboard']//div//input[@class='button']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")
	private WebElement account; 
	@FindBy(xpath="//span[contains(text(),'Member Payment')]")
	private WebElement payment; 
	@FindBy(id="memberUsername")
	private WebElement memberuserName; 
	
	@FindBy(id="amount")
	private WebElement amount; 
	@FindBy(id="type")
	private WebElement type; 
	@FindBy(id="description")
	private WebElement description; 
	@FindBy(id="submitButton")
	private WebElement submit;
	@FindBy(xpath="//table[@class='defaultTable']//input[@class='button']")
	private WebElement submit1;
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement logout;
	
	@FindBy(xpath="//tr[5]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement accountinfo;
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	public void sendpassword() 
	{
		driver.findElement(By.xpath("//*[@value='d']")).click();
		driver.findElement(By.xpath("//*[@value='h']")).click();
		driver.findElement(By.xpath("//*[@value='w']")).click();
		driver.findElement(By.xpath("//*[@value='a']")).click();
		driver.findElement(By.xpath("//*[@value='n']")).click();
		driver.findElement(By.xpath("//*[@value='i']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();
		
	}

	public void clickLoginBtn() 
	{
		this.loginBtn.click(); 
		
	}
	public void clickaccountBtn() 
	{
		this.account.click(); 
		
	}
	public void clickpaymentBtn() 
	{
		this.payment.click(); 
		
	}
	public void sendmemberUserName(String memberuserName) {
		this.memberuserName.clear();
		this.memberuserName.sendKeys(memberuserName);
	}
	
	public void sendamount(String amount) {
		this.amount.clear();
		this.amount.sendKeys(amount);
	}
	public void clicktypeBtn() 
	{
		this.type.click(); 
		
	}
	public void senddescription(String description) {
		this.description.clear();
		this.description.sendKeys(description);
	}
	public void clicksubmitBtn() 
	{
		this.submit.click(); 
		
	}
	public void clicksubmit1Btn() 
	{
		this.submit1.click(); 
		
	}
	public void clicklogoutBtn() 
	{
		this.logout.click(); 
		
	}
	public void clickaccountinfo() 
	{
		this.accountinfo.click(); 
		
	}
}
