package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	private WebElement userName; 
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[contains(text(),'Change')]")
	private WebElement ChangeyourPassword;
	
	@FindBy(name="confirm")
	private WebElement ConfirmPassword;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement SubmitBtn;
	
		
	public void clickChangepassword()
	{
		this.ChangeyourPassword.click();
		this.password.clear();
								
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
		
		}
	
	public void sendConfirmPassword(String confirm) {
		this.ConfirmPassword.clear();
		this.ConfirmPassword.sendKeys(confirm);
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	public void clickSubmitBtn() {
		this.SubmitBtn.click();
	}
}
