package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		//System.out.println("URL Launch sucess");
		//System.out.println("Today is Friday Class");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		loginPOM.sendUserName("admin@gmail.com");
		loginPOM.sendPassword("admin@778");
		loginPOM.clickLoginBtn(); 
		//screenShot.captureScreenShot("First");
		//My Code from Here
		System.out.println("Login Sucess & in Main Page");
		System.out.println(" Starting Change Password Test Case for User admin@gmail.com");
		
		loginPOM.clickChangepassword();
		loginPOM.sendPassword("admin@779");
		loginPOM.sendConfirmPassword("admin@779");
		loginPOM.clickSubmitBtn();
		System.out.println("You changed your Passwrod sucessfully");
	}
		
}
