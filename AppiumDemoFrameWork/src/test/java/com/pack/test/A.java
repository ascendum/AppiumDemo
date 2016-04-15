package com.pack.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.pack.base.AppiumServer;

public class A extends AppiumTestBase{

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		AppiumServer as=new AppiumServer();
		AppiumTestBase ab=new AppiumTestBase();
		A a=new A();
		as.appiumStart();
		//a.initializeAndroidDriver();
		ab.initializeAndroidDriver();
		ad.findElement(By.id("net.one97.paytm:id/edit_no")).sendKeys("9740172751");
		ad.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String s=ad.findElement(By.id("net.one97.paytm:id/text_mob_op")).getText();
		ad.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println("The operator is : " + s);
		ad.findElement(By.name("Browse Plans")).click();
		ad.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Plan is Browsed");
		ad.findElement(By.name("Special Recharge")).click();
		ad.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//net.one97.paytm:id/row_container[@index='0']")).click();
		ad.findElement(By.id("net.one97.paytm:id/row_container")).click();
		ad.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String s1=ad.findElement(By.id("net.one97.paytm:id/edit_amount")).getText();
		System.out.println("Ur selected Recharge amount is: "+ s1);
		ad.findElement(By.name("Proceed to Recharge")).click();
		ad.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//driver.findElement(By.id("net.one97.paytm:id/btn_pay_now")).click();
		ad.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
		ad.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
Thread.sleep(5000);
		//ad.quit();

	}

}
