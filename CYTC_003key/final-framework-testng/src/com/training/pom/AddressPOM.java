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


public class AddressPOM {
	private WebDriver driver; 
	
	public AddressPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="//div[@id='virtualKeyboard']//div//input[@class='button']")
	private WebElement loginBtn; 
	@FindBy(xpath="//td[@class='tdContentTableForms innerBorder']//td[1]//a[1]")
	private WebElement profile;
	@FindBy(xpath="//input[@id='modifyButton']")
	private WebElement change;
	@FindBy(xpath="//tr[7]//td[2]//span[1]//input[2]")
	private WebElement address;
	@FindBy(xpath="//input[@id='saveButton']")
	private WebElement submit;
	
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
	public void clickprofile() 
	{
		this.profile.click(); 
		
	}
	public void clickchange() 
	{
		this.change.click(); 
		
	}
	public void clickaddress() 
	{
		this.address.clear(); 
		
	}
	public void sendaddress(String address) {
		
		this.address.sendKeys(address);
	}
	public void clickSubmitBtn() {
		this.submit.click(); 
	}
}
