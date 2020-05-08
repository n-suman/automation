package com.bite.mobile.scrap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestSafariBrowser {
	
	
	
	public static IOSDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		/*
		 * 
		 * brew install ios-webkit-debug-proxy
		 * 
		 * ios_webkit_debug_proxy -c a842e662828955e2555b2274b1d04547c755f369:27753

		 * 
		 */
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6.4-beta");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.1");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7 Plus");
		
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		
		capabilities.setCapability(MobileCapabilityType.UDID, "a842e662828955e2555b2274b1d04547c755f369");
		

		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("lst-ib")).sendKeys("Hello Appium !!!");
		
		Thread.sleep(4000);
		driver.quit();
	}

}
