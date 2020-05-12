package com.bite.mobile.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {

	public static int IMPLICIT_WAIT_TIME;
	public static int EXPLICIT_WAIT_TIME;
	public static String BASE_PKG;
	public static String APP_PATH;
	public static String APP_ACTIVITY;
	public static String BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static String APPIUM_PORT;
	public static URL serverUrl;
	public static String UDID;
	public static String BUNDLE_ID;
	public static String APP;
	public static String AUTOMATION_INSTRUMENTATION;
	public static String DATE_FORMAT;
	public static String ANDROID_PROP_FILE;
	public static String IOS_PROP_FILE;

	private static Properties prop = new Properties();
	private static DesiredCapabilities capabilities = new DesiredCapabilities();

	private static AppiumDriver<MobileElement> driver;

	public static void loadGenericProperties(String propFileName) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/properties/" + propFileName);
		prop.load(fis);

		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("wait.implicit"));
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("wait.explicit"));
		DATE_FORMAT = prop.getProperty("date.format");

		ANDROID_PROP_FILE = prop.getProperty("android.propfile");
		IOS_PROP_FILE = prop.getProperty("ios.propfile");

		APPIUM_PORT = prop.getProperty("appium.server.port");
	}

	public static void loadAndroidConfProp() throws IOException {
		System.out.println("loading android configuration..");
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/properties/" + ANDROID_PROP_FILE);
		prop.load(fis);
		APP_PATH = prop.getProperty("application.path");
		BASE_PKG = prop.getProperty("base.pkg");
		APP_ACTIVITY = prop.getProperty("application.activity");
		// BROWSER_NAME = prop.getProperty("browser.name");
		PLATFORM_NAME = prop.getProperty("platform.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		UDID = prop.getProperty("device.udid");
		System.out.println("android configuration..loaded");
	}

	public static void loadIOSConfProp() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/properties/" + IOS_PROP_FILE);
		prop.load(fis);

		// APPLICATION_NAME = prop.getProperty("application.path");
		UDID = prop.getProperty("udid");
		APP = prop.getProperty("application.app");
		AUTOMATION_INSTRUMENTATION = prop.getProperty("automation.instumentation");
		DEVICE_NAME = prop.getProperty("device.name");
		// BROWSER_NAME=prop.getProperty("browser.name");
		PLATFORM_NAME = prop.getProperty("platform.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		BUNDLE_ID = prop.getProperty("bundle.id");

	}

	public static void setIOSCapabilities() {
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, CommonUtils.BROWSER_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, CommonUtils.PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, CommonUtils.PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, CommonUtils.DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, CommonUtils.AUTOMATION_INSTRUMENTATION);
		capabilities.setCapability("ios.native", false);
		capabilities.setCapability("applicationClearData", true);
		capabilities.setCapability("dataReset", true);
		capabilities.setCapability("instrumentApp", false);
		capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, CommonUtils.BUNDLE_ID);
		capabilities.setCapability(MobileCapabilityType.UDID, CommonUtils.UDID);
	}

	public static void setAndroidCapabilities() {
		System.out.println("Setting Android capabilities..");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.UDID, UDID);
		capabilities.setCapability("noReset", "false");
		capabilities.setCapability("takesScreenshot", true);
		capabilities.setCapability("dataReset", true);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PKG);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
		System.out.println("Setting Android capabilities..done");
	}

	public static AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException {
		serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
		driver = new AndroidDriver<MobileElement>(serverUrl, capabilities);
		System.out.println("driver created..");
		return driver;
	}

	public static AppiumDriver<MobileElement> getIOSDriver() throws MalformedURLException {
		serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
		driver = new IOSDriver<MobileElement>(serverUrl, capabilities);
		System.out.println("driver created..");
		return driver;
	}
	
	public static Map<String, XBy> getAllFieldsOf(Object o) {
		Map<String, XBy> allFields = new HashMap<String, XBy>();
		Class cls = o.getClass();
		Field[] fields = cls.getFields();
		try {
			for (Field field:fields) {
				if (field.getDeclaringClass().equals(cls))
					allFields.put(field.getName(), (XBy) field.get(o));
			}
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return allFields;
	}
	
	public static Map<Object, Map<String, XBy>> getAllFieldsOfAll(Object[] allPageObjs) {
		Map<Object, Map<String, XBy>> pageObjsCollection = new HashMap<Object, Map<String, XBy>>();
		for (Object o:allPageObjs) {
			pageObjsCollection.put(o, getAllFieldsOf(o));
		}
		return pageObjsCollection;
	}
	
	public static XBy getElemLoc(Map<Object, Map<String, XBy>> map, Object page, String elem) {
		Map<String, XBy> inMap = map.get(page);
		return inMap.get(elem);
	}

}
