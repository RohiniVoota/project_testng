package com.training.sanity.tests;


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
import com.training.pom.TC0035_SaveProduct_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC0035_SaveProduct {

	private WebDriver driver;
	private String baseUrl;
	private TC0035_SaveProduct_POM tc0035_pom;
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
        tc0035_pom = new TC0035_SaveProduct_POM(driver); 
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
		tc0035_pom.sendUserName("admin");
		tc0035_pom.sendPassword("admin@123");
		tc0035_pom.clickLoginBtn(); 
		
		//select the product and save it   
		tc0035_pom.menu();
		tc0035_pom.catalog();
		tc0035_pom.products();
		tc0035_pom.add();
		tc0035_pom.prdct_name("Blazer Girls(7-8)");
		tc0035_pom.meta("Blazer for girls");
		tc0035_pom.data();
		tc0035_pom.model("BLG-112");
		tc0035_pom.price("3000");
		tc0035_pom.quantity("100");
		tc0035_pom.links();
        tc0035_pom.setCategory("Blazers(4-5)");
		
		//add discount
		tc0035_pom.discount();
		tc0035_pom.add_discount();
		tc0035_pom.disc_qnty("5");
		tc0035_pom.disc_price("200");
		tc0035_pom.start_date("2019-02-26");
		tc0035_pom.end_date("2019-02-29");
		
		//give rewards
		tc0035_pom.reward();
		tc0035_pom.points("20");
		Thread.sleep(5000);
		
		//set default values for the below values 
		tc0035_pom.Attribute();
		Thread.sleep(2000);
		tc0035_pom.option();
		Thread.sleep(2000);
		tc0035_pom.Recurring();
		Thread.sleep(2000);
		tc0035_pom.special();
		Thread.sleep(2000);
		tc0035_pom.image();
		Thread.sleep(2000);
		tc0035_pom.design();
		Thread.sleep(2000);
		tc0035_pom.save();
		
		Thread.sleep(5000);
		
	//compare the actual title of the page with the expected one
		String Actual="Products";
		String Expected=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/h1")).getText();
		Assert.assertEquals(Actual, Expected);
		
		
		screenShot.captureScreenShot("Tenth");
	}
}
