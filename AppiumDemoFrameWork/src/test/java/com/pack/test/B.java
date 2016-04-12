package com.pack.test;

import static com.pack.test.AppiumTestBase.getAndroidDriver;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pack.base.AppiumServer;
import com.pack.page.Recharge;
public class B extends Recharge{
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
	ab.initializeAndroidDriver();

}
    @Parameters({ "phoneNumber"})
	@Test
	public void rechargePayTM(String phoneNumber){
		System.out.println("Phone Number is " + phoneNumber );
		enterUserName(phoneNumber);
		operatorName();
		clickOnBrowsePlans();
		clickOnSpecial();
		rechargeAmount();
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
