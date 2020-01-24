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


public class PermissionsPOM {
	private WebDriver driver; 
	
	public PermissionsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="memberUsername")
	private WebElement memberuserName; 
	@FindBy(xpath="//body[@class='main']//tr//tr[2]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[4]//input[1]")
	private WebElement submit1; 
	@FindBy(xpath="//select[@name='newGroupId']")
	private WebElement newgroup;
	@FindBy(xpath="//option[contains(text(),'Full members')]")
	private WebElement fullmembers;
	@FindBy(xpath="//textarea[@id='comments']")
	private WebElement comments;
	@FindBy(xpath="//table[@class='defaultTable']//input[@class='button']")
	private WebElement submit2;
	
	
	public void sendmemberUserName(String memberuserName) {
		this.memberuserName.clear();
		this.memberuserName.sendKeys(memberuserName);
	}
	public void sendpassword() 
	{
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click();
		
		
	}

	public void clicksubmit1() 
	{
		this.submit1.click(); 
		
	}
	public void clicknewgroup() 
	{
		this.newgroup.click(); 
		
	}
	public void clickfullmembers() 
	{
		this.fullmembers.click(); 
		
	}
	public void sendcomments(String comments) {
		this.comments.clear();
		this.comments.sendKeys(comments);
	}
	public void clicksubmit2() 
	{
		this.submit2.click(); 
		
	}

}
