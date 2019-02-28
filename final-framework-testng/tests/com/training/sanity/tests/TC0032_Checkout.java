package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.TC0032_Checkout_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;



public class TC0032_Checkout {

	private WebDriver driver;
	private String baseUrl;
	private TC0032_Checkout_POM tc0032_pom;
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
		tc0032_pom = new TC0032_Checkout_POM(driver); 
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
	public void ValidCheckout() throws InterruptedException {
		tc0032_pom.Shop_Uniforms();
		Thread.sleep(2000);
		tc0032_pom.T_shirt();
		
		//select the size
		Select dropdown= new Select(driver.findElement(By.id("input-option389")));
		dropdown.selectByVisibleText("26");
		
        //click on add cart
		tc0032_pom.Cart();
		Thread.sleep(2000);
		
		
		tc0032_pom.Cart_icon();
		Thread.sleep(2000);
		
		//view the cart
		tc0032_pom.ViewCart();
		Thread.sleep(2000);
		
		//Checkout
		tc0032_pom.Checkout();
		
		//compare the actual title of the page with the expected one
	    String Actual="CHECKOUT";
		String Expected=driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		Assert.assertEquals(Actual,Expected);
		
		
		screenShot.captureScreenShot("Seventh");
	}
}
