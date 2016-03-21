package com.pack.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.base.Webdriverhelpers;
import com.pack.page.BasePage;
import com.pack.page.SignInPage;
import com.pack.utility.ScreenShots;

public class SignInPageTest extends TestBaseSetup{
private WebDriver driver;
private SignInPage signInPage;
private BasePage basePage;
ScreenShots st;
Webdriverhelpers wh;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
		
	@Test
	public void verifySignInFunction() {
		System.out.println("Sign In functionality details...");
		basePage = new BasePage(driver);
		wh.waitForPageToLoad();
		signInPage = basePage.clickSignInBtn();
		wh.waitForPageToLoad();
		Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
		Assert.assertTrue(signInPage.verifySignInPageText(), "Page text not matching");
		Assert.assertTrue(signInPage.verifySignIn(), "Unable to sign in");

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