package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;

public class RTTC_042AddProductPOM {

private WebDriver driver; 

GenericMethods genericcheck;
	
	public RTTC_042AddProductPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement AddnewBtn;
	
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement addproductname;
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement metatagtitle;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement datatab;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement ModelTBox;
	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement PriceInput;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement Quantity;
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement LinksTab;
	
	@FindBy(xpath="//input[@id='input-category']")
	private WebElement Productcat;
	
	@FindBy(xpath="//div[@class='pull-right']//button[@class='btn btn-primary']")
	private WebElement Savebtn;
		
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
	
	public void clickAddnewBtn() {
		this.AddnewBtn.click(); 
	}
		
	public void sendProductname1(String addproductname) {
		//this.addproductname.clear(); 
		genericcheck = new GenericMethods(driver);
		genericcheck.txtBoxVisibility(this.addproductname, addproductname);
		//this.addproductname.sendKeys(addproductname);
}
	public void sendmetatagtitle(String metatagtitle) {
		//this.metatagtitle.clear();
		genericcheck = new GenericMethods(driver);
		genericcheck.txtBoxVisibility(this.metatagtitle, metatagtitle);
		//this.metatagtitle.sendKeys(metatagtitle);
}
	public void clickdatatab() {
		genericcheck = new GenericMethods(driver);
		genericcheck.linkVisibility(this.datatab);
		
		}
	
	public void sendModelTBox(String ModelTBox) {
		//this.ModelTBox.clear();
		//genericcheck = new GenericMethods(driver);
		genericcheck.txtBoxVisibility(this.ModelTBox, ModelTBox);
		//this.ModelTBox.sendKeys(ModelTBox);
	}
	public void sendPriceInput(String PriceInput) {
		//this.PriceInput.clear();
		genericcheck = new GenericMethods(driver);
		genericcheck.txtBoxVisibility(this.PriceInput, PriceInput);
		//this.PriceInput.sendKeys(PriceInput);
	}
	
	public void sendQuantity(String Quantity) {
		//genericcheck = new GenericMethods(driver);
		genericcheck.txtBoxVisibility(this.Quantity, Quantity);
		
	}
	
	public void clickLinksTab() {
		genericcheck = new GenericMethods(driver);
		genericcheck.linkVisibility(this.LinksTab);
		
		}
	
	public void sendProductcat(String Productcat) {
		genericcheck = new GenericMethods(driver);
		genericcheck.txtBoxVisibility(this.Productcat, Productcat);
		//this.Productcat.sendKeys(Productcat);
	}
	
	public void clickSavebtn() {
		genericcheck = new GenericMethods(driver);
		genericcheck.linkVisibility(this.Savebtn);
		
		}
}
