package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_042AddProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_042AddProductTests {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_042AddProductPOM RTTC_042AddProductPOM;
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
		RTTC_042AddProductPOM = new RTTC_042AddProductPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		//System.out.println("Today is Friday Class");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		RTTC_042AddProductPOM.sendUserName("admin");
		RTTC_042AddProductPOM.sendPassword("admin@123");
		RTTC_042AddProductPOM.clickLoginBtn(); 
		System.out.println("Login Sucess with admin User");
		
		RTTC_042AddProductPOM.clickCatlogBtn(); 
		RTTC_042AddProductPOM.clickCatlogSubmenu(); 
		RTTC_042AddProductPOM.clickProductsBtn(); 
		System.out.println("Products List Displayed");
				
		//Add products Button
		Thread.sleep(2000);
		RTTC_042AddProductPOM.clickAddnewBtn();
		RTTC_042AddProductPOM.sendProductname1("Finger Ring2020");
		RTTC_042AddProductPOM.sendmetatagtitle("Finger Ring for ladies");
		RTTC_042AddProductPOM.clickdatatab();
		Thread.sleep(2000);
		RTTC_042AddProductPOM.sendModelTBox("SKU-012");
		RTTC_042AddProductPOM.sendPriceInput("500");
		RTTC_042AddProductPOM.sendQuantity("50");
		Thread.sleep(1000);
		RTTC_042AddProductPOM.clickLinksTab();
		RTTC_042AddProductPOM.sendProductcat("EarRings");
		RTTC_042AddProductPOM.clickSavebtn();
		Thread.sleep(2000);
		
			}

}
