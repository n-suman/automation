package com.bite.mobile.lib.iOS;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.HomeScreen_android;
import com.bite.mobile.screens.ios.HomeScreen_iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomeScreenLib_ios extends ScreenBase{

	public String LetsStartbtn = "Lets Start ";
	public String LetsStart = "Lets Start ";
	public String allowbtn = "Allow";
	public String okbtn = "OK";
	public String searchLocationtxt = "Search Location";
	public String searchbtn = "Search Icon";
	public String locationList = "Location List";
	
	public HomeScreenLib_ios(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}

	/**
	 * This function used to launch the Bite Application, Search for Location and Select the Location
	 * @param location
	 * @throws Throwable
	 */
	public void LaunchApp(String location) throws Throwable {
		try {
			//Tap(639, 2230, LetsStart);
			//Tap(665, 2434, LetsStart);
//			click(HomeScreen_iOS.allowbtn, allowbtn);
			Thread.sleep(1000);
			click(HomeScreen_iOS.okbtn, okbtn);
			Thread.sleep(1000);
			Type(HomeScreen_iOS.searchlocationnametext, location, searchLocationtxt);
			Thread.sleep(2000);
			LongPressButton(HomeScreen_iOS.searchButton);
//			click(HomeScreen_iOS.searchButton, searchbtn);
			Thread.sleep(3500);
			LongPressbuttonWithCooridinates(HomeScreen_iOS.locationList, 20, 292);
//			HomeScreen_iOS.selectLocation();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
