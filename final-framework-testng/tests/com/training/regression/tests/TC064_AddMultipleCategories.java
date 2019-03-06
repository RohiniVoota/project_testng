package com.training.regression.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import com.training.pom.TC064_AddCategoriesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC064_AddMultipleCategories {
	private WebDriver driver;
	private String baseUrl;
	private TC064_AddCategoriesPOM TC064;
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
		TC064 = new TC064_AddCategoriesPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get("http://uniform.upskills.in/admin/");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String name, String description, String meta, String meta_desc ) throws InterruptedException, AWTException {
		TC064.sendUserName("admin");
		TC064.sendPassword("admin@123");
		TC064.clickLoginBtn(); 
		
		//select the product and save it   
		TC064.menu();
		TC064.catalog();
		TC064.categories();		
		TC064.add();
		TC064.Category_name(name);
		TC064.Description(description);
		TC064.meta(meta);
		TC064.meta_desc(meta_desc);
		Thread.sleep(3000);
		TC064.Data();
		Thread.sleep(3000);
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(3000);
		TC064.Design();
		Thread.sleep(3000);
		TC064.Save();
		Thread.sleep(3000);
		
		//screenShot.captureScreenShot(userName)
		
	}

}