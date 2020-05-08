package com.bite.mobile.base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.bite.mobile.utility.AppiumServer;
import com.bite.mobile.utility.CommonUtils;
import com.bite.mobile.utility.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestBase {
	
	
	public static AppiumDriver<MobileElement> driver;
//	public static String loadPropertyFile = "Android_biteapp.properties";
	public static String loadPropertyFile = "IOS_biteapp.properties";
	//public static String loadPropertyFile = "ios_careapp.properties";
	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"/src/test/resources/testdata//testdata.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		extent = new ExtentReports(System.getProperty("user.dir") + "\\testReports\\biteReport"
				+ formater.format(calendar.getTime()) + ".html", false);

	}
	
	@BeforeSuite
	public void setUp() throws IOException{
		
		if(driver==null){
			
			if(loadPropertyFile.startsWith("Android")){
				
			//	AppiumServer.start();
				log.debug("Appium server started");
				CommonUtils.loadAndroidConfProp(loadPropertyFile);
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();
				
			}else if(loadPropertyFile.startsWith("IOS")){
				
				CommonUtils.loadIOSConfProp(loadPropertyFile);
				CommonUtils.setIOSCapabilities();
				driver = CommonUtils.getIOSDriver();
			}
		}
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException{
		
		Thread.sleep(3000);
		if(loadPropertyFile.startsWith("Android")){
		driver.quit();
	//	AppiumServer.stop();
		log.debug("Appium server stopped");
		}else{
			
			driver.quit();
		}
		
	}
	
}
