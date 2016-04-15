package com.pack.page;

import static com.pack.test.AppiumTestBase.getAndroidDriver;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pack.SeleniumHelpers.SeleniumBusiness;

public class Recharge extends SeleniumBusiness{
	static Logger log=Logger.getLogger("Recharge");
	private By phoneNumberText = By.id("net.one97.paytm:id/edit_no");
	private By operatorText = By.id("net.one97.paytm:id/text_mob_op");
	private By BrowsePlans = By.name("Browse Plans");
	private By SpecialRecharge = By.name("Special Recharge");
	private By firstEntry = By.id("net.one97.paytm:id/row_container");
	private By rechargeAmount = By.id("net.one97.paytm:id/edit_amount");
	private By proceedToRecharge = By.name("Proceed to Recharge");
	private By proceedToPay = By.xpath(("//android.widget.Button[@index='2']"));

	public Recharge() {
		log.info("In Recharge Page");
		PropertyConfigurator.configure("Log4j.properties");
	}
	public void enterPhoneNumber(String phoneNumber) {

	    log.info("Phone Number Entered");
	    enterTextField(phoneNumberText, phoneNumber);	
		
	
	}
/*public void operatorName(){
	 
	System.out.println("Operator selected is " +getTextFromElement(operatorText));
}*/
	public String getOperatorName(){
		 
		System.out.println("Operator selected is " +getTextFromElement(operatorText));
		return getTextFromElement(operatorText);
	}	

	public void VerifyOperatorName(){
		if(getOperatorName().equals("AIRTEL")){
			System.out.println("Phone Operator displayed is: AIRTEL");
		}
		else{
			System.out.println("Phone Operator is not: AIRTEL");
		}
	}
public void clickOnBrowsePlans(){
	 log.info("PlanBrowsed");
	clickButtonOrLink(BrowsePlans);
}

public void clickOnSpecial(){
	 log.info("Clicked on Special");
	 waitForElementToBeClickable(SpecialRecharge);
	clickButtonOrLink(SpecialRecharge);
	waitForElementToBeClickable(firstEntry);
	clickButtonOrLink(firstEntry);

}
/*public void rechargeAmount(){
	waitFindElement(rechargeAmount);
	System.out.println("It's a recharge of total " +getTextFromElement(rechargeAmount));
}*/

public String getRechargeAmount(){
	waitFindElement(rechargeAmount);
	System.out.println("It's a recharge of total " +getTextFromElement(rechargeAmount));
	return getTextFromElement(rechargeAmount);
}

public void verifyRechargeAmount(){
	if(getOperatorName().equals("AIRTEL")){
		System.out.println("Phone Operator displayed is: AIRTEL");
	}
	else{
		System.out.println("Phone Operator is not: AIRTEL");
	}
}
	
public void clickOnProcedToRecharge(){
	 log.info("Clicked on ProcedToRecharge");
	
	waitForElementToBeClickable(proceedToRecharge);
	clickButtonOrLink(proceedToRecharge);
	sleep(1000);

}
public void clickOnProcedToPay(){
	 log.info("Clicked on ProcedToPay");
	
	waitForElementToBeClickable(proceedToPay);
	clickButtonOrLink(proceedToPay);
	sleep(6000);

}

}
