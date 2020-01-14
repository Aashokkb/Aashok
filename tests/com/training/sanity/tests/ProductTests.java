package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ProductTests {
	private WebDriver driver;
	private String baseUrl;
	private ProductPOM ProductPOM;
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
		ProductPOM = new ProductPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		//System.out.println("URL Launch success");
		//System.out.println("Today is Friday Class");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		ProductPOM.sendUserName("admin");
		ProductPOM.sendPassword("admin@123");
		ProductPOM.clickLoginBtn(); 
		System.out.println("Login Sucess with admin User");
		
		ProductPOM.clickCatlogBtn(); 
		ProductPOM.clickCatlogSubmenu(); 
		ProductPOM.clickProductsBtn(); 
		System.out.println("Products List Displayed");
		ProductPOM.sendProductName("Finger Ring");
		ProductPOM.clickFilterBtn();
		System.out.println("Data Loaded for the slected Product");
		Thread.sleep(2000);
		//Test Step with Filter Product Name and Price
		ProductPOM.clickProductsBtn(); 
		ProductPOM.sendProductName("Finger Ring");
		ProductPOM.sendPrice("500.0000");
		ProductPOM.clickFilterBtn();
		System.out.println("Data Loaded for the slected Product & Price Filter Condition");
		Thread.sleep(2000);
		//Test Step with Filter Product Name and Price & Model
		
		ProductPOM.clickProductsBtn(); 
		ProductPOM.sendProductName("Finger Ring");
		ProductPOM.sendPrice("500.0000");
		ProductPOM.sendModel("SKU-012");
		ProductPOM.clickFilterBtn();
		System.out.println("Data Loaded for the slected Product, Price & ModelFilter Condition");
				
			}

}
