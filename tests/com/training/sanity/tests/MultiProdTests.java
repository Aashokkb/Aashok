package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.AddMultiPrdctPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MultiProdTests {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddMultiPrdctPOM AddMultiPrdctPOM;
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
		loginPOM = new LoginPOM(driver);
		AddMultiPrdctPOM = new AddMultiPrdctPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void Proddata(String addproductname, String metatagtitle, String Model, String Price , String Productcat) throws InterruptedException {
		
		AddMultiPrdctPOM.sendUserName("admin");
		AddMultiPrdctPOM.sendPassword("admin@123");
		AddMultiPrdctPOM.clickLoginBtn(); 
		System.out.println("Login Sucess with admin User");
		AddMultiPrdctPOM.clickCatlogBtn(); 
		AddMultiPrdctPOM.clickCatlogSubmenu(); 
		AddMultiPrdctPOM.clickProductsBtn(); 
		System.out.println("Products List Displayed");
		
		AddMultiPrdctPOM.clickAddnewBtn();
		AddMultiPrdctPOM.sendProductname1(addproductname);
		AddMultiPrdctPOM.sendmetatagtitle(metatagtitle);
		Thread.sleep(2000);
		AddMultiPrdctPOM.clickdatatab();
		AddMultiPrdctPOM.sendModel(Model);
		AddMultiPrdctPOM.sendPrice(Price);
		Thread.sleep(2000);
		AddMultiPrdctPOM.clickLinksTab();
		AddMultiPrdctPOM.sendProductcat(Productcat);
		
		Thread.sleep(2000);
		AddMultiPrdctPOM.clickSavebtn();
		Thread.sleep(3000);
		//screenShot.captureScreenShot(userName);
		
	}

}
