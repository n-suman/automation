package com.bite.mobile.lib.android;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.HomeScreen_android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomeScreenLib_android extends ScreenBase{

	public String LetsStartbtn = "Lets Start ";
	public String LetsStart = "Lets Start ";
	public String allowbtn = "Allow";
	public String okbtn = "OK";
	public String searchLocationtxt = "Search Location";
	public String searchbtn = "Search Icon";
	public String locationList = "Location List";
	
	public HomeScreenLib_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}

	/**
	 * This function used to launch the Bite Application, Search for Location and Select the Location
	 * @param location
	 * @throws Throwable
	 */
	public void LaunchApp(String location) throws Throwable {
		try {
			Tap(639, 2230, LetsStart);
			Thread.sleep(1000);
			Tap(665, 2434, LetsStart);
			click(HomeScreen_android.allowbtn, allowbtn);
			Thread.sleep(1000);
			click(HomeScreen_android.okbtn, okbtn);
			Thread.sleep(1000);
			Type(HomeScreen_android.searchlocationnametext, location, searchLocationtxt);
			click(HomeScreen_android.searchButton, searchbtn);
			driver.getPageSource();
			HomeScreen_android.selectLocation();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
