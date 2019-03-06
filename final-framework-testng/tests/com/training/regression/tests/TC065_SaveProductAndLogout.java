package com.training.regression.tests;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.TC065_SaveProductAndLogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC065_SaveProductAndLogout {

	private WebDriver driver;
	private String baseUrl;
	private TC065_SaveProductAndLogoutPOM TC065;
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
        TC065 = new TC065_SaveProductAndLogoutPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get("http://uniform.upskills.in/admin/");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException, AWTException {
		
		//login as admin     
		TC065.sendUserName("admin");
		TC065.sendPassword("admin@123");
		TC065.clickLoginBtn(); 
		
		//select the product and save it   
		TC065.menu();
		TC065.catalog();
		TC065.products();
		TC065.add();
		TC065.prdct_name("Blazer Girls(7-8)");
		TC065.meta("Blazer for girls");
		TC065.data();
		TC065.model("BLG-112");
		TC065.price("3000");
		TC065.quantity("100");
		TC065.links();
		TC065.setCategory("Blazers(4-5)");
		
		//add discount
		TC065.discount();
		TC065.add_discount();
		TC065.disc_qnty("5");
		TC065.disc_price("200");
		TC065.start_date("2019-02-26");
		TC065.end_date("2019-02-29");
		
		//give rewards
		TC065.reward();
		TC065.points("20");
		Thread.sleep(5000);
		
		//set default values for the below values 
		TC065.Attribute();
		Thread.sleep(2000);
		TC065.option();
		Thread.sleep(2000);
		TC065.Recurring();
		Thread.sleep(2000);
		TC065.special();
		Thread.sleep(2000);
		TC065.image();
		Thread.sleep(2000);
		TC065.design();
		Thread.sleep(2000);
		TC065.save();
		
		Thread.sleep(5000);
		TC065.logout();
		
	//compare the actual title of the page with the expected one
		//String Actual="Products";
		//String Expected=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/h1")).getText();
		//Assert.assertEquals(Actual, Expected);
		
		
		//screenShot.captureScreenShot("Tenth");
	}
}
