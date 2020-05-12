package com.bite.mobile.lib;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.utility.CommonUtils;
import com.bite.mobile.utility.XBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonDeviceLib extends ScreenBase{

	public ScreenBase ca, hs, ls, ms; //base class objects to be created based on device platform
	public  Map<Object, Map<String, XBy>> allPageObjs = new HashMap<Object, Map<String, XBy>>();
		
	public CommonDeviceLib(AppiumDriver<MobileElement> driver) {
		super(driver);
		String platform = driver.getCapabilities().getCapability(MobileCapabilityType.PLATFORM_NAME).toString();
		System.out.println("In CommonDeviceLib "+platform+ " and equals Android "+platform.equalsIgnoreCase("Android"));
		if (platform.equalsIgnoreCase("Android")) {
			com.bite.mobile.screens.android.CreateAccount ca1 = new com.bite.mobile.screens.android.CreateAccount(driver);
			com.bite.mobile.screens.android.HomeScreen hs1 = new com.bite.mobile.screens.android.HomeScreen(driver);
			com.bite.mobile.screens.android.LoginScreen ls1 = new com.bite.mobile.screens.android.LoginScreen(driver);
			com.bite.mobile.screens.android.MenusScreen ms1 = new com.bite.mobile.screens.android.MenusScreen(driver);
			ca = ca1;
			hs = hs1;
			ls = ls1;
			ms = ms1;
			ScreenBase[] sb = {ca, hs, ls, ms};
			allPageObjs = CommonUtils.getAllFieldsOfAll(sb);						
		} else if (platform.equalsIgnoreCase("IOS")) {
			com.bite.mobile.screens.ios.CreateAccount ca1 = new com.bite.mobile.screens.ios.CreateAccount(driver);
			com.bite.mobile.screens.ios.HomeScreen hs1 = new com.bite.mobile.screens.ios.HomeScreen(driver);
			com.bite.mobile.screens.ios.LoginScreen ls1 = new com.bite.mobile.screens.ios.LoginScreen(driver);
			com.bite.mobile.screens.ios.MenusScreen ms1 = new com.bite.mobile.screens.ios.MenusScreen(driver);
			ca = ca1;
			hs = hs1;
			ls = ls1;
			ms = ms1;
			ScreenBase[] sb = {ca, hs, ls, ms};
			allPageObjs = CommonUtils.getAllFieldsOfAll(sb);
		}
	}
	
	public XBy getLoc(Object page, String ele) {
		return CommonUtils.getElemLoc(allPageObjs, page, ele);
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
			System.out.println(getLoc(hs, "LetsStartbtn").description);
			System.out.println(getLoc(hs, "LetsStartbtn").xpath());
			click(getLoc(hs, "LetsStartbtn"));
			click(getLoc(hs, "allowbtn"));
			Thread.sleep(1000);
			click(getLoc(hs, "okbtn"));
			Thread.sleep(1000);
			Type(getLoc(hs, "searchlocationnametext"), location);
			click(getLoc(hs, "searchButton"));
			driver.getPageSource();
			hs.selectLocation();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void CreateAnAccount(String email, String createAnAccountlbl, String nextletscreateaccountlbl, String firstName, String lastName,
			String password, String verifyPwd, String monthoption, String yearoption, String genderoption, String phoneoption) throws Throwable {
		try {
			   Thread.sleep(2500);
			String actualText = getText(getLoc(ca, "createAnaccountlbl"));
			System.out.println(actualText +" Create Account lable");
		     Assert.assertEquals(actualText, createAnAccountlbl);
		     Type(getLoc(ca, "emailtxt"), email);
		     click(ca.nextbtn);
		     Thread.sleep(2500);
		     String text = getText(getLoc(ca, "nextletscreateanaccountlbl"));
		     System.out.println(text +"next lets create ");
		     Assert.assertEquals(text, nextletscreateaccountlbl);
		     Type(ca.firstnametxt, firstName);
		     Type(ca.lastnametxt, lastName);
		     Type(ca.passwordtxt, password);
		     Type(ca.verifypasswordtxt, verifyPwd);
		     click(ca.termsconditionchkbox);
		     click(ca.signupbtn);
		     Thread.sleep(2500);
		     LongPressButton(ca.Monthbtn);
		     
		     ca.selectValueFromPopUp(monthoption);
		    // LongPressButton(CreateAccountScreen.yearbtn);
		     Tap(799, 907, "year");
		     ca.selectValueFromPopUp(yearoption);
		     Tap(248, 1113, "gender");
//		     LongPressButton(CreateAccountScreen.genderbtn);
		     ca.selectValueFromPopUp(genderoption);
		     Tap(154, 1290, "phonenumber");
		     Type(ca.mobilenotxt, "+1 301-987-4772");
		     click(ca.alldonebtn);
		     click(ca.notnowlink);
		} catch(Exception e) {
			e.printStackTrace();	
		}
	}
	
	public String SetEmail() {
		return ca.RandomEmail();
	}
	
	public void Login(String email, String password) throws Throwable {
		try {

            click(ls.SigninSignupbtn);
            Thread.sleep(3000);
            Tap(505, 1702, "email txt");
            keyBoardSendKeys(email);
            Thread.sleep(3000);
            Tap(379, 1683, "password txt");
            keyBoardSendKeys(password);
            Thread.sleep(3000);
           // Type(LoginScreen.emailtxt, email, emailtxt);
           // Type(LoginScreen.passwordtxt, password, passwordtxt);
            click(ls.signinbtn);
            Thread.sleep(3000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public  void selectMenu(String menuType) throws InterruptedException {
		Thread.sleep(2000);
//		click(MenusScreen.backImageButtonFromLogout, backImageButtonFromLogout);
//		Thread.sleep(2000);
//		click(MenusScreen.backImageFromProfile, backImageFromProfile);
//		Thread.sleep(2000);
		LongPressButton(ms.menustab);
		Thread.sleep(3500);
		ms.selectMenuItem(menuType);
	}
	
	public void selectDateAndItem(String itemName) throws InterruptedException {
		Thread.sleep(2000);
		LongPressButton(ms.date);
		Thread.sleep(2000);
		ms.selectMenuItem(itemName);
		Thread.sleep(2000);
		LongPressButton(ms.reviewbtn);
	}
}

