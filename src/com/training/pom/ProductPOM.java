package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPOM {

private WebDriver driver; 
	
	public ProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement userName; 
	
	@FindBy(name="password")
	private WebElement password; 
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[@id='button-menu']")
	private WebElement CatlogBtn;
	
	@FindBy(xpath="//span[contains(text(),'Catalog')]//following::a[2]")
	private WebElement ProductsBtn;
	
	@FindBy(xpath="//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-catalog']/a[1]")
	private WebElement CatlogSubmenu;
	
	@FindBy(xpath="//input[@placeholder='Product Name']")
	private WebElement ProductName; 
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement FilterBtn;
	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement Price;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement Model;
	
	
		
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
		
			}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickCatlogBtn() {
		this.CatlogBtn.click(); 
	}
	
	public void clickProductsBtn() {
		this.ProductsBtn.click(); 
	}
	
	public void clickCatlogSubmenu() throws InterruptedException {
		this.CatlogSubmenu.click(); 
		Thread.sleep(3000);
	}
	public void sendProductName(String ProductName) {
		this.ProductName.clear(); 
		this.ProductName.sendKeys(ProductName);
	}
	
	public void clickFilterBtn() {
		this.FilterBtn.click(); 
		
		}
	
	public void sendPrice(String Price) {
		this.Price.clear(); 
		this.Price.sendKeys(Price);
	}
	
	public void sendModel(String Model) {
		this.Model.clear(); 
		this.Model.sendKeys(Model);
	}
}
	
	
