package com.pack.utility;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtentManage {
	private static ExtentReports extent;
    
  
	public synchronized static ExtentReports getReporter(String filePath) {
        if (extent == null) {
        	extent = new ExtentReports(filePath, true, NetworkMode.ONLINE);
        	//extent.startReporter(ReporterType.DB, (new File(filePath)).getParent() + File.separator + "extent.db");
        	
        	/*extent
                .addSystemInfo("Host Name", "chinmayas")
                .addSystemInfo("Environment", "QA");*/
        	Map sysInfo = new HashMap();
        	sysInfo.put("Selenium Version", "2.48.2");
        	sysInfo.put("Environment", "QA");

        	extent.addSystemInfo(sysInfo);
        }
        
        return extent;
    }
    
    public synchronized static ExtentReports getReporter() {
    	return extent;
    }
}