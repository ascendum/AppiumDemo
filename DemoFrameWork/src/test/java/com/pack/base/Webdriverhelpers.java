package com.pack.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriverhelpers {
	/*Webdriverhelpers(){
		PropertyConfigurator.configure("Log4j.properties");
	}*/
	static Logger logger=Logger.getLogger("TestBaseSetup");
	

boolean flag = false;
	
	public void waitForPageToLoad(){	
		TestBaseSetup.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Waiting for page to load");
	}
	
	public void waitForLinkPrasent(String linkName){
		WebDriverWait wait = new WebDriverWait(TestBaseSetup.getDriver(), 20);
		wait.until(ExpectedConditions.
				presenceOfElementLocated(By.linkText(linkName)));	
		logger.info("Wait for link present");
	}
	
	
	public void waitForXpathPrasent(String wbXpath){
		WebDriverWait wait = new WebDriverWait(TestBaseSetup.getDriver(), 20);
		wait.until(ExpectedConditions.
				presenceOfElementLocated(By.xpath(wbXpath)));
		logger.info("Wait for xpath to be present ");
	}

	public boolean verifyText(String wbXpath , String expectedText){
		flag = false;
		String actPage = TestBaseSetup.getDriver().findElement(By.xpath(wbXpath)).getText();
		if(expectedText.equals(actPage)){
			flag=true;
			System.out.println(expectedText + " page is verified");
			logger.info("text is verified");
		}else{
			logger.info("Text is not verified");
			System.out.println(expectedText + " page is not verified");
		}
	return flag;
	}
	
	public boolean verifyTextPrasent(String expectedText){
	   flag = false;
	String htmlDoc = TestBaseSetup.getDriver().getPageSource();	 
	 if(htmlDoc.contains(expectedText)){
		 flag=true;
		 System.out.println(expectedText + " text is verified");
		 logger.info("Text present");
	 }else{
		 logger.info("Text is not present");
		 System.out.println(expectedText + " text is not verified");
	 }
	 return flag;
	}
	
	
	public void select(String selWbName , String value){
		Select sel = new Select(TestBaseSetup.getDriver().findElement(By.name(selWbName)));
		sel.selectByVisibleText(value);	
		logger.info("Value selected from select box");
	}
	
	public void select(String selWbName, int index){
		Select sel = new Select(TestBaseSetup.getDriver().findElement(By.name(selWbName)));
		sel.selectByIndex(index);	
		logger.info("index base selection from text box");
	}
	
	public void select(WebElement selBoxWb, String value){
		Select sel = new Select(selBoxWb);
		sel.selectByVisibleText(value);	
		logger.info("selected by visible text from select box");
	}
	
	public void aceptAlert(){
		Alert alt = TestBaseSetup.getDriver().switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		logger.info("Alert accepted");
	}
	
	public void cancelAlert(){
		Alert alt = TestBaseSetup.getDriver().switchTo().alert();
		System.out.println(alt.getText());
		alt.dismiss();
		logger.info("Cancelled allert");
	}
	
	
	
	
	

}
