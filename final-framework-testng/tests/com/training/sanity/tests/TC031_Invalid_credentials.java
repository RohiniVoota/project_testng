package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.TC031_Invalid_Credentials_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC031_Invalid_credentials {

	private WebDriver driver;
	private String baseUrl;
	private TC031_Invalid_Credentials_POM tc0031pom;
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
		tc0031pom= new TC031_Invalid_Credentials_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//close the browser
		driver.quit();
	}
	@Test
	public void validLogin() {
		
		//login with invalid credentials
		tc0031pom.MyAccount();
		tc0031pom.Login();
		tc0031pom.email("welcome");
		tc0031pom.password("Rohi123");
		tc0031pom.LoginBtn();
		
		//compare the actual title of the page with the expected one
		String Actual="RETURNING CUSTOMER";
		String Expected=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h2")).getText();
		Assert.assertEquals(Actual,Expected);
		
		
		//take the screenshot
		
		screenShot.captureScreenShot("Sixth");
	}
}
