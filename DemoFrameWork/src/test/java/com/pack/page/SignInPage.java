package com.pack.page;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInPage {

	private WebDriver driver;
	static Logger logger=Logger.getLogger("SignInPage");
	private By headerPageText = By.cssSelector(".hidden-small");
	private By createAccountLink = By.id("link-signup");
	private By emailTextBox = By.id("Email");
	private By passwordTextBox = By.id("Passwd");
	private By loginBtn = By.id("signIn");
	private By errorMsgTxt = By.id("errormsg_0_Passwd");
	private By nextBtn = By.id("next");

	public By firstNameTxt = By.id("FirstName");
	public By lastNameTxt = By.id("LastName");
	public By mobileNumberTxt = By.id("RecoveryPhoneNumber");
	
		
		public SignInPage(WebDriver driver) {
			PropertyConfigurator.configure("Log4j.properties");
			this.driver=driver;
		}
		
		public String getSignInPageTitle() {
			String pageTitle = driver.getTitle();
			return pageTitle;
		}
		
		public boolean verifySignInPageTitle() {
			String expectedTitle = "Sign in - Google Accounts";
			return getSignInPageTitle().contains(expectedTitle);
		}
		
		public boolean verifySignInPageText() {
			WebElement element = driver.findElement(headerPageText);
			String pageText = element.getText();
			String expectedPageText = "Sign in with your Google Account";
			return pageText.contains(expectedPageText);
		}
		

			public CreateAccountPage clickonCreateAnAccount() {
				WebElement element=driver.findElement(createAccountLink);
				if(element.isDisplayed()||element.isEnabled())
					element.click();
				logger.info("CreateAnAccount link clicked");
				return new CreateAccountPage(driver);
		}
		
		


			
			public boolean verifySignIn() {
				enterUserName("mrsatapathy3");
				//System.out.println("UserName Entered Sucessfully");
				logger.info("UserName Entered Sucessfully");
				clickOnNext();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//System.out.println("Next button is clicked");
				logger.info("Next button is clicked");
				enterPassword("pass");
				logger.info("Passwod is Entered Sucessfully");
				//System.out.println("Passwod is Entered Sucessfully");
				clickOnSignIn();
				logger.info("SignIn button clicked");
				return getErrorMessage().contains("email and password you entered don't match.");
			}
			
			public void enterUserName(String userName) {
				WebElement emailTxtBox = driver.findElement(emailTextBox);
				if(emailTxtBox.isDisplayed())
					emailTxtBox.sendKeys(userName);
				//logger.info("UserName Entered");
			}
			
			public void enterPassword(String password) {
				WebElement passwordTxtBox = driver.findElement(passwordTextBox);
				if(passwordTxtBox.isDisplayed())
					passwordTxtBox.sendKeys(password);
				//logger.info("Password Entered");
			}
			
			public void clickOnSignIn() {
				WebElement signInBtn = driver.findElement(loginBtn);
				if(signInBtn.isDisplayed())
					signInBtn.click();
				
			}
			
			public void clickOnNext() {
				WebElement nextBttn = driver.findElement(nextBtn);
				if(nextBttn.isDisplayed())
					nextBttn.click();
				logger.info("Next button clicked");
			}

			public String getErrorMessage() {
				String strErrorMsg = null;
				WebElement errorMsg = driver.findElement(errorMsgTxt);
				if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
					strErrorMsg = errorMsg.getText();
				return strErrorMsg;
			}
}
