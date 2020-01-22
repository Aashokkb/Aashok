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
import com.training.pom.TC067POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC067_Tests {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private TC067POM tc067POM;
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
		tc067POM = new TC067POM(driver);
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
	public void Proddata(String ProductName, String Price, String Status, String Model, String Quantity , String Image) throws InterruptedException {
		
		tc067POM.sendUserName("admin");
		tc067POM.sendPassword("admin@123");
		tc067POM.clickLoginBtn(); 
		System.out.println("Login Sucess with admin User");
		tc067POM.clickCatlogBtn(); 
		tc067POM.clickCatlogSubmenu(); 
		tc067POM.clickProductsBtn(); 
		System.out.println("Products List Displayed");
		
		tc067POM.sendProductName(ProductName);
		tc067POM.sendPrice(Price);
		tc067POM.sendStatus(Status);
		tc067POM.sendModel(Model);
		tc067POM.sendQuantity(Quantity);
		tc067POM.sendImage(Image);
		Thread.sleep(2000);
		tc067POM.clickFilterBtn();
		Thread.sleep(3000);
		//screenShot.captureScreenShot(userName);
		
	}

}
