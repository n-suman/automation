package com.bite.mobile.base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.bite.mobile.utility.CommonUtils;
import com.bite.mobile.utility.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestBase {
	
	
	public static AppiumDriver<MobileElement> driver;
	//public static String androidPropFile = "bite.android.properties";
	//public static String iosPropFile = "bite.ios.properties";
	public static String genericPropFile = "bite.general.properties";
	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"/src/test/resources/testdata//testdata.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	@BeforeSuite
	public void setUp(ITestContext context) throws IOException{
		System.out.println("starting in @BeforeSuite..");
		CommonUtils.loadGenericProperties(genericPropFile);
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat(CommonUtils.DATE_FORMAT);

		extent = new ExtentReports(System.getProperty("user.dir") + "\\testReports\\biteReport"
				+ formater.format(calendar.getTime()) + ".html", false);
		
		String currentSuiteName = context.getSuite().getName();
		System.out.println("current suite name is "+currentSuiteName);
		if(driver==null){
			if(currentSuiteName.startsWith("Android")){
				System.out.println("attempting to create android driver.");
				CommonUtils.loadAndroidConfProp();
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();
			}else if(currentSuiteName.startsWith("iOS")){
				CommonUtils.loadIOSConfProp();
				CommonUtils.setIOSCapabilities();
				driver = CommonUtils.getIOSDriver();
			}
		}
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException{
		driver.closeApp();
		driver.quit();
		System.out.println("App closed and driver object destroyed..");
	}
	
}
