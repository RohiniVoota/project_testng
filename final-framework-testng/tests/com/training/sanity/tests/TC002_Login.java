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
import com.training.pom.UniformLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC002_Login {

	private WebDriver driver;
	private String baseUrl;
	private UniformLoginPOM uniformloginpom;
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
		uniformloginpom = new UniformLoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLogin() {
		
		uniformloginpom.MyAccount();
		uniformloginpom.Login();
		uniformloginpom.email("welcome@gmail.com");
		uniformloginpom.password("Rohini123");
		uniformloginpom.LoginBtn();
		
		String Actual="MY ACCOUNT";
		String Expected=driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		Assert.assertEquals(Actual,Expected);
		
		
		
		
		screenShot.captureScreenShot("second");
	}
}
