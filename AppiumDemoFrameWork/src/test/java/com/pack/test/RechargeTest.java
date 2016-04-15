package com.pack.test;

import static com.pack.test.AppiumTestBase.getAndroidDriver;

import java.io.IOException;

import junit.framework.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.pack.base.AppiumServer;
import com.pack.page.Recharge;
public class RechargeTest extends Recharge{
	//String phoneNumber="9740172751";
	AppiumServer as;
	AppiumTestBase ab;
	

@BeforeTest
public void initialize(){
	 as=new AppiumServer();
	 ab=new AppiumTestBase();
	try {
		as.appiumStart();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ab.initializeAndroidDriverPayTM();

}
    @Parameters({ "phoneNumber"})
	@Test
	public void rechargePayTM(String phoneNumber){
		System.out.println("Phone Number is " + phoneNumber );
		enterPhoneNumber(phoneNumber);
		
		//verify operator name returned by the application
		VerifyOperatorName();
	
		//operatorName();
		clickOnBrowsePlans();
		clickOnSpecial();

		//verify Recharge amount returned by the application
		verifyRechargeAmount();
		
		clickOnProcedToRecharge();
		clickOnProcedToPay();
	}
	
	@AfterTest
	public void tearDown(){
		getAndroidDriver().quit();

		try {
			as.appiumStop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

}
