package com.bite.mobile.lib.android;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.MenusScreen_android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MenusScreenLib_android extends ScreenBase{

	public static String backImageButtonFromLogout ="Back Arrow";
	public static String backImageFromProfile ="Back Arrow";
	public static String newstab ="NEWS Tab";
	public static String menustab= "MENUS tab";
	public static  String rewardstab =" REWARDS tab";
	public static String ordertab ="ORDER tab";
	public static String paytab="PAY tab";
	
	public MenusScreenLib_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	public  void selectMenu(String menuType) throws InterruptedException {
		Thread.sleep(2000);
//		click(MenusScreen.backImageButtonFromLogout, backImageButtonFromLogout);
//		Thread.sleep(2000);
//		click(MenusScreen.backImageFromProfile, backImageFromProfile);
//		Thread.sleep(2000);
		LongPressButton(MenusScreen_android.menustab);
		Thread.sleep(3500);
		MenusScreen_android.selectMenuItem(menuType);
	}
	public void selectDateAndItem(String itemName) throws InterruptedException {
		Thread.sleep(2000);
		LongPressButton(MenusScreen_android.date);
		Thread.sleep(2000);
		MenusScreen_android.selectMenuItem(itemName);
		Thread.sleep(2000);
		LongPressButton(MenusScreen_android.reviewbtn);
	}

	
	
}
