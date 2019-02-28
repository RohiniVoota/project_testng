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
import com.training.pom.TC0033_Checkout_registeredlogin_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;



public class TC0033_Checkout_registeredlogin {

	private WebDriver driver;
	private String baseUrl;
	private TC0033_Checkout_registeredlogin_POM tc0033_pom;
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
		tc0033_pom = new TC0033_Checkout_registeredlogin_POM(driver); 
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
	@Test()
	public void ValidCheckout() throws InterruptedException {
		tc0033_pom.Shop_Uniforms();
		Thread.sleep(2000);
		tc0033_pom.T_shirt();
		
		//select the size
		Select dropdown= new Select(driver.findElement(By.id("input-option389")));
		dropdown.selectByVisibleText("26");
		
		//add to cart
		tc0033_pom.Cart();
		Thread.sleep(2000);
		
		tc0033_pom.Cart_icon();
		Thread.sleep(2000);
		
		//view cart
		tc0033_pom.ViewCart();
		Thread.sleep(2000);
		
		//checkout
		tc0033_pom.Checkout();
		
		//login with valid credentials
		tc0033_pom.email("welcome@gmail.com");
		tc0033_pom.password("Rohini123");
		tc0033_pom.LoginBtn();
		
		//continue to billing
		tc0033_pom.continue_billing();
		tc0033_pom.shipping_billing();
		
		//comments
		tc0033_pom.comment("Please deliver between 7am to 10am");
		tc0033_pom.shippingbtn();
		Thread.sleep(5000);
		
		//terms and conditions checkbox
		tc0033_pom.checkbox();
		tc0033_pom.paymentbtn();
		
		//Confirm button
		tc0033_pom.confirmbtn();
		
		
		//compare the actual title of the page with the expected one
		String Actual="Thanks for shopping with us online!";
		String Expected=driver.findElement(By.xpath("//*[@id=\"content\"]/p[5]")).getText();
		Assert.assertEquals(Actual, Expected);
	   
		
		screenShot.captureScreenShot("Eight");
	}
}
