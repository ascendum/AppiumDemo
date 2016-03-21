package com.pack.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.base.Webdriverhelpers;
import com.pack.page.BasePage;
import com.pack.page.CreateAccountPage;
import com.pack.page.SignInPage;
import com.pack.utility.ScreenShots;

public class CreateAnAccounTest extends TestBaseSetup {
	static Logger logger=Logger.getLogger("CreateAnAccounTest");
	private WebDriver driver;
	private SignInPage signInPage;
	private BasePage basePage;
	private CreateAccountPage createAccountPage;
	ScreenShots st;
	//Webdriverhelpers wh;
	/*private By firstNameTxt = By.id("FirstName");
	private By lastNameTxt = By.id("LastName");
	private By mobileNumberTxt = By.id("RecoveryPhoneNumber");*/

		@BeforeClass
		public void setUp() {
			PropertyConfigurator.configure("Log4j.properties");
			driver=getDriver();
		}
		
		@Test(dataProvider="createAccount")
		public void CreateAnAccounPage(String firstName, String lastName,String Mobile) {
			//System.out.println("Create An Account page test...");
			logger.info("Create An Account page test...");
			basePage = new BasePage(driver);
			//wh.waitForPageToLoad();
			signInPage = basePage.clickSignInBtn();
			createAccountPage = signInPage.clickonCreateAnAccount();
			//.waitForPageToLoad();
			driver.findElement(signInPage.firstNameTxt).sendKeys(firstName);
			driver.findElement(signInPage.lastNameTxt).sendKeys(lastName);
			driver.findElement(signInPage.mobileNumberTxt).sendKeys(Mobile);
			Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
			Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");
		}
		
		@DataProvider(name="createAccount")
		public Object[][] createAccData() {
			Object[][] arrayObject = getExcelData("D:\\TestData\\CreateAccount.xls","Sheet1");
			return arrayObject;
		}

		/**
		 * @param File Name
		 * @param Sheet Name
		 * @return
		 */
		public String[][] getExcelData(String fileName, String sheetName) {
			String[][] arrayExcelData = null;
			try {
				FileInputStream fs = new FileInputStream(fileName);
				Workbook wb = Workbook.getWorkbook(fs);
				Sheet sh = wb.getSheet(sheetName);

				int totalNoOfCols = sh.getColumns();
				int totalNoOfRows = sh.getRows();
				
				arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
				
				for (int i= 1 ; i < totalNoOfRows; i++) {

					for (int j=0; j < totalNoOfCols; j++) {
						arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
					}

				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				e.printStackTrace();
			} catch (BiffException e) {
				e.printStackTrace();
			}
			return arrayExcelData;
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
		public void verifySignInFunction() {
			
		}

}