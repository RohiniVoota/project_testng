package com.training.sanity.tests;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.training.generics.ScreenShot;
    import com.training.pom.UserRegistrationPOM;
    import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	public class Registration {

		private WebDriver driver;
		private String baseUrl;
		private UserRegistrationPOM UserRegistrationPOM;
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
			UserRegistrationPOM = new UserRegistrationPOM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(7000);
			driver.quit();
		}
    
		@Test
		public void validLoginTest() throws InterruptedException {
			UserRegistrationPOM.MyAccount();
			UserRegistrationPOM.register();
			UserRegistrationPOM.Firstname("Rohini");
			UserRegistrationPOM.Lastname("Voota");
			UserRegistrationPOM.Email("welcome6@gmail.com"); 
			UserRegistrationPOM.Telephone("6787903239");
			UserRegistrationPOM.Address("madhapur");
			UserRegistrationPOM.City("Hyderabad");
			UserRegistrationPOM.Postcode("533005");
			
			Select dropdown= new Select(driver.findElement(By.id("input-zone")));
			dropdown.selectByVisibleText("Andhra Pradesh");
		
			
			UserRegistrationPOM.Password("Rohini123");
			UserRegistrationPOM.Confirm("Rohini123");
			
			UserRegistrationPOM.radio();
		    UserRegistrationPOM.checkbox();
		    UserRegistrationPOM.ContinueBtn();
		    
		    Thread.sleep(2000);
		    
		    
		    String Actual="YOUR ACCOUNT HAS BEEN CREATED!";
		    String Expected1=driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		    Assert.assertEquals(Actual,Expected1);

			
			screenShot.captureScreenShot("First");
		}
	}

	
