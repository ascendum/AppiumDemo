package com.pack.SeleniumHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.pack.test.AppiumTestBase.getAndroidDriver;

public class SeleniumSpecific {
	
    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ignored) {
        }
    }

    
    public static void moveToElement(WebElement whereToGo){
        Actions act = new Actions(getAndroidDriver());
        act.moveToElement(whereToGo).perform();
    }

      
    public static WebDriverWait getWebDriverWait(int timeOut) {
        int timeOutInSeconds = timeOut / 1000;
        int sleepInMillis = 200;
        return new WebDriverWait(getAndroidDriver(), timeOutInSeconds, sleepInMillis);
    }

    //TODO: Review use and document
    public static void windowScrollUpByPixels(int pixels){
        //scroll up N pixels to prevent the scroll-to-top-arrow and invitation prompt receiving the click
        WebDriver driver = getAndroidDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,-" + pixels + ");");
    }

    //TODO: Review use and document
    public static void scrollOneElementToInView(WebElement element){
        ((JavascriptExecutor) getAndroidDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
   
    //TODO: Review use and document
    public static void windowScrollDownByPixels(int pixels){
        //scroll down 350 pixels to prevent the scroll-to-top-arrow and invitation prompt receiving the click
        WebDriver driver = getAndroidDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, " + pixels + ");");
    }
    

    public static void waitForElementToBeVisible(By locator) {
        //getWebDriverWait(TimeoutMSForConditionToExist()).until(visibilityOfElementLocated(locator));
    
    	getWebDriverWait(20).until(ExpectedConditions.visibilityOfElementLocated(locator));

}
    

    public static WebElement waitFindElement(By locator) {
        return getWebDriverWait(20).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForElementToBeClickable(By locator) {
        getWebDriverWait(20).until(ExpectedConditions.elementToBeClickable(locator)); 
    }
    
    public static void waitForElementToBeClickable(final WebElement element) {
        getWebDriverWait(20).until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void waitForElementToBeVisible(final WebElement element) {
        getWebDriverWait(20).until(ExpectedConditions.visibilityOf(element));
    }


    
    
}
