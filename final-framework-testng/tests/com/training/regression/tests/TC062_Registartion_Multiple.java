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
import com.training.pom.LoginPOM;
import com.training.pom.TC062_Registration_MutliplePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC062_Registartion_Multiple {
	private WebDriver driver;
	private String baseUrl;
	private TC062_Registration_MutliplePOM TC062;
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
		TC062 = new TC062_Registration_MutliplePOM(driver);
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
	public void loginDBTest(String firstname, String lastname, String email, String telephone,String address1,String address2,String city,String postcode,String Country,String Region,String password,String confirm) throws InterruptedException {
	    TC062.MyAccount();
		TC062.register();
		TC062.Firstname(firstname);
		TC062.Lastname(lastname);
		TC062.Email(email);
		TC062.Telephone(telephone);
		TC062.Address1(address1);
		TC062.Address2(address2);
		Thread.sleep(2000);
		TC062.City(city);
		TC062.Postcode(postcode);
		Select dropdown= new Select(driver.findElement(By.id("input-country")));
		dropdown.selectByVisibleText(Country);
		
		Select dropdown1= new Select(driver.findElement(By.id("input-zone")));
		dropdown1.selectByVisibleText(Region);
		
		Thread.sleep(2000);
		TC062.Password(password);
		TC062.Confirm(confirm);
		
		TC062.radio();
		TC062.checkbox();
		TC062.ContinueBtn();
		Thread.sleep(2000);
	    screenShot.captureScreenShot();
		
	}

}