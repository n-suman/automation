package com.bite.mobile.scrap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestCareAppIOS {
	
	
	
	public static IOSDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6.4-beta");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.1");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7 Plus");
		
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		
		capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.care.enterprise");
		
		
		capabilities.setCapability(MobileCapabilityType.UDID, "a842e662828955e2555b2274b1d04547c755f369");
		

		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		driver.findElementByAccessibilityId("Sign up with Email").click();
		driver.findElementByAccessibilityId("Hire a Caregiver").click();
		
		
		driver.findElement(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeStaticText")).click();
		
		driver.findElement(By.xpath("//XCUIElementTypeTextField[@value='Email']")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@value='Password (must be at least 6 char)']")).sendKeys("skldjfhsdfs");
		driver.findElement(By.xpath("//XCUIElementTypeTextField[@value='First Name']")).sendKeys("Rahul");
		driver.findElement(By.xpath("//XCUIElementTypeTextField[@value='Last Name']")).sendKeys("Arora");
		driver.findElement(By.xpath("//XCUIElementTypeTextField[@value='Birthday']")).click();
		
		driver.findElement(By.xpath("//XCUIElementTypePickerWheel[1]")).setValue("January");
		driver.findElement(By.xpath("//XCUIElementTypePickerWheel[2]")).setValue("14");
		driver.findElement(By.xpath("//XCUIElementTypePickerWheel[3]")).setValue("1985");
		
		driver.findElementByAccessibilityId("Done").click();

		driver.findElementByAccessibilityId("NEXT").click();
		
		
		Thread.sleep(4000);
		driver.quit();
	}

}
