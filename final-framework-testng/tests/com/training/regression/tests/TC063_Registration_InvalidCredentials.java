package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.TC0063_Registration_InvalidCredentialsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC063_Registration_InvalidCredentials {
	private WebDriver driver;
	private String baseUrl;
	private TC0063_Registration_InvalidCredentialsPOM TC063;
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
		TC063 = new TC0063_Registration_InvalidCredentialsPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String firstname, String lastname, String email, String telephone,String address1,String address2,String city,String postcode,String Country,String Region,String password,String confirm) throws InterruptedException {
	    TC063.MyAccount();
		TC063.register();
		TC063.Firstname(firstname);
		TC063.Lastname(lastname);
		TC063.Email(email);
		TC063.Telephone(telephone);
		TC063.Address1(address1);
		TC063.Address2(address2);
		Thread.sleep(2000);
		TC063.City(city);
		TC063.Postcode(postcode);
		Select dropdown= new Select(driver.findElement(By.id("input-country")));
		dropdown.selectByVisibleText(Country);
		
		Select dropdown1= new Select(driver.findElement(By.id("input-zone")));
		dropdown1.selectByVisibleText(Region);
		
		Thread.sleep(2000);
		TC063.Password(password);
		TC063.Confirm(confirm);
		
		TC063.radio();
		TC063.checkbox();
		TC063.ContinueBtn();
		Thread.sleep(2000);
	    screenShot.captureScreenShot();
		
	}

}