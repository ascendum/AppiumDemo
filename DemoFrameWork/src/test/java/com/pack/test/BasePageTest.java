package com.pack.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.page.BasePage;

public class BasePageTest extends TestBaseSetup{
	
	private WebDriver driver;
	static Logger logger=Logger.getLogger("CreateAccountPage");
	@BeforeClass
	public void setUp() {
		driver=getDriver();
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@Test
	public void verifyHomePage() {
		//System.out.println("Home page test...");
		logger.info("Home page test...");
		BasePage basePage = new BasePage(driver);
		Assert.assertTrue(basePage.verifyBasePageTitle(), "Home page title doesn't match");
	}

}