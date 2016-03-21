package com.pack.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {
	public static String captureScreenShot(WebDriver driver,String ScreenShotName){
		try{
			DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
			Date date = new Date();

			TakesScreenshot ts=(TakesScreenshot)driver;
			File Source=ts.getScreenshotAs(OutputType.FILE);
			String dest="C:\\Users\\chinmayas\\git1\\DemoFrameWork\\ScreenShot"+ScreenShotName+dateFormat.format(date)+".png";
			File destination=new File(dest);
			FileUtils.copyFile(Source, destination);
			System.out.println("ScreenShot Taken");
			return dest;
		}	
		
		catch(Exception e){
			System.out.println("Exception while ScreenShot"+e.getMessage());
		
		return e.getMessage();
		}
		

}
}
