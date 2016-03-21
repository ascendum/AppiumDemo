package com.pack.utility;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;

import com.pack.utility.ExtentManage;

import com.relevantcodes.extentreports.ExtentReports;

public abstract class ParallelClassBase extends ExtentManage{
    //protected ExtentReports extent;
	ExtentReports  extent;
	DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
	Date date = new Date();
	String ConvDate=dateFormat.format(date).toString();
    protected final String filePath = "D:\\Report\\ParallelClassesTest_"+ConvDate+".html";
    
    @BeforeClass
    public void beforeClass() {
        //extent = ExtentManager.getReporter(filePath);
    	extent=	ExtentManage.getReporter(filePath);
    }
    
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
}
