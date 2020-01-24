package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPOM {
	
	
	public RegisterPOM(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='loginRegistrationDiv']//input[@class='button']")
	private WebElement submit1;
	
	@FindBy(xpath="//input[@name='member(user).username']")
	private WebElement loginName;
	
	@FindBy(xpath="//input[@name='member(name)']")
	private WebElement fullName;
	
	@FindBy(xpath="//input[@name='member(email)']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='_id1578896309554_975']")
	private WebElement birthday;
	
	@FindBy(xpath="//input[@id='_radio_2_1']")
	private WebElement gender;
	
	@FindBy(xpath="//tr[6]//td[2]//input[3]")
	private WebElement address;
	
	@FindBy(xpath="//tr[7]//td[2]//input[3]")
	private WebElement postalcode;
	
	@FindBy(xpath="//tr[8]//td[2]//input[3]")
	private WebElement city;
	
	@FindBy(xpath="//tr[10]//td[2]//input[3]")
	private WebElement phone;
	
	@FindBy(xpath="//tr[11]//td[2]//input[3]")
	private WebElement mobilephone;
	
	@FindBy(xpath="//tr[12]//td[2]//input[3]")
	private WebElement fax;
	
	@FindBy(xpath="//tr[13]//td[2]//input[3]")
	private WebElement url;
	
	@FindBy(xpath="//input[@name='member(user).password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	private WebElement confirmpassword;
	
	@FindBy(xpath="//input[@name='captcha']")
	private WebElement captcha;
	
	@FindBy(xpath="//input[@id='saveButton']")
	private WebElement submit;
	
	public void clickSubmitButton() {
		this.submit1.click(); 
	}
	
	public void sendLoginName(String loginName) {
		this.loginName.clear();
		this.loginName.sendKeys(loginName);
	}
	public void sendFullName(String fullName) {
		this.fullName.clear();
		this.fullName.sendKeys(fullName);
	}
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	public void sendbirthday(String birthday) {
		this.birthday.clear();
		this.birthday.sendKeys(birthday);
	}
	
	public void clickgender() {
		this.gender.click(); 
	}
	public void sendaddress(String address) {
		this.address.clear();
		this.address.sendKeys(address);
	}
	public void sendpostalcode(String postalcode) {
		this.postalcode.clear();
		this.postalcode.sendKeys(postalcode);
	}
	public void sendcity(String city) {
		this.city.clear();
		this.city.sendKeys(city);
	}
	public void sendphone(String phone) {
		this.phone.clear();
		this.phone.sendKeys(phone);
	}
	public void sendmobilephone(String mobilephone) {
		this.mobilephone.clear();
		this.mobilephone.sendKeys(mobilephone);
	}
	public void sendfax(String fax) {
		this.fax.clear();
		this.fax.sendKeys(fax);
	}
	public void sendurl(String url) {
		this.url.clear();
		this.url.sendKeys(url);
	}
	
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	public void sendconfirmPassword(String confirmpassword) {
		this.confirmpassword.clear(); 
		this.confirmpassword.sendKeys(confirmpassword); 
	}
	/*public void sendCaptcha(String str) 
	{
		this.captcha.clear(); 
		this.captcha.sendKeys(str);
		
		
	}*/
	
	public void clickSubmitBtn() {
		this.submit.click(); 
	}
}
