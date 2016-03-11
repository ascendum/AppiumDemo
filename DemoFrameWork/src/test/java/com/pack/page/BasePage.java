package com.pack.page;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	protected WebDriver driver;
	static Logger logger=Logger.getLogger("BasePage");
	private By signInButton = By.linkText("Sign in");
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	public SignInPage clickSignInBtn() {
		 logger.info("clicking on sign in button");
		//System.out.println("clicking on sign in button");
		WebElement signInBtnElement=driver.findElement(signInButton);
		if(signInBtnElement.isDisplayed()||signInBtnElement.isEnabled())
			signInBtnElement.click();
		else //System.out.println("Element not found");
			logger.info("Element not found");
		return new SignInPage(driver);
	}
	
	public void clickImagesLink() {
		//It should have a logic to click on images link
		//And it should navigate to google images page
	}
	
	public String getPageTitle(){
		String title = driver.getTitle();
		logger.info("title captured1");
		return title;
	}
	
	public boolean verifyBasePageTitle() {
		String expectedPageTitle="Google";
		return getPageTitle().contains(expectedPageTitle);
	}
}
