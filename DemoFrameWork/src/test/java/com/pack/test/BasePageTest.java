package com.pack.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.base.Webdriverhelpers;
import com.pack.page.BasePage;
import com.pack.utility.ScreenShots;
import com.thoughtworks.selenium.webdriven.commands.CaptureScreenshotToString;

public class BasePageTest extends TestBaseSetup{
	
	private WebDriver driver;
	Webdriverhelpers wh;
	ScreenShots st;
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
		wh.waitForPageToLoad();
		Assert.assertTrue(basePage.verifyBasePageTitle(), "Home page title doesn't match");
	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	 
	// Here will compare if test is failing then only it will enter into if condition
	if(ITestResult.FAILURE==result.getStatus())
	{
	try 
	{
		st.captureScreenShot(getDriver(), result.getName());
	 
	System.out.println("Screenshot taken");
	} 
	catch (Exception e)
	{
	 
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	 
	 
	 
	}
}
}