package com.bite.mobile.lib;

import java.util.HashMap;
import java.util.Map;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.MenusScreen.Tabs;
import com.bite.mobile.screens.android.Review.Emoji;
import com.bite.mobile.utility.CommonUtils;
import com.bite.mobile.utility.XBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonDeviceLib extends ScreenBase {

	public ScreenBase ca, hs, ls, ms, o, p, r; // base class objects to be created based on device platform
	public Map<Object, Map<String, XBy>> allPageObjs = new HashMap<Object, Map<String, XBy>>();

	public CommonDeviceLib(AppiumDriver<MobileElement> driver) {
		super(driver);
		String platform = driver.getCapabilities().getCapability(MobileCapabilityType.PLATFORM_NAME).toString();
		System.out.println(
				"In CommonDeviceLib " + platform + " and equals Android " + platform.equalsIgnoreCase("Android"));
		if (platform.equalsIgnoreCase("Android")) {
			com.bite.mobile.screens.android.CreateAccount ca1 = new com.bite.mobile.screens.android.CreateAccount(driver);
			com.bite.mobile.screens.android.HomeScreen hs1 = new com.bite.mobile.screens.android.HomeScreen(driver);
			com.bite.mobile.screens.android.LoginScreen ls1 = new com.bite.mobile.screens.android.LoginScreen(driver);
			com.bite.mobile.screens.android.MenusScreen ms1 = new com.bite.mobile.screens.android.MenusScreen(driver);
			com.bite.mobile.screens.android.Order o1 = new com.bite.mobile.screens.android.Order(driver);
			com.bite.mobile.screens.android.Pay p1 = new com.bite.mobile.screens.android.Pay(driver);
			com.bite.mobile.screens.android.Review r1 = new com.bite.mobile.screens.android.Review(driver);
			ca = ca1;
			hs = hs1;
			ls = ls1;
			ms = ms1;
			o = o1;
			p = p1;
			r = r1;
			ScreenBase[] sb = { ca, hs, ls, ms, o, p, r };
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
			ScreenBase[] sb = { ca, hs, ls, ms };
			allPageObjs = CommonUtils.getAllFieldsOfAll(sb);
		}
	}

	public XBy getLoc(Object page, String ele) {
		return CommonUtils.getElemLoc(allPageObjs, page, ele);
	}

	public void continueAsGuest() {
		click(ca.guestSignIn);
	}

	public void launchAndSearchLoc(String loc) throws Throwable {
		try {
			hs.handleLetsStartButton();
			click(getLoc(hs, "allowFgOnly"));
			click(getLoc(hs, "okbtn"));
			type(getLoc(hs, "searchlocationnametext"), loc);
			click(getLoc(hs, "searchButton"));
			driver.getPageSource();
			click(getLoc(hs, "searchListItem1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CreateAnAccount(String createAnAccountlbl, String nextletscreateaccountlbl,
			String firstName, String lastName, String password, String verifyPwd, String monthoption, String yearoption,
			String genderoption, String phoneoption) throws Throwable {
		String email = ca.generateRandomEmailAddr();
		try {
			assertEquals(getText(getLoc(ca, "createAnaccountlbl")), createAnAccountlbl);
			type(getLoc(ca, "emailtxt"), email);
			click(getLoc(ca, "nextbtn"));
			assertEquals(getText(getLoc(ca, "nextletscreateanaccountlbl")), nextletscreateaccountlbl);
			type(getLoc(ca, "firstnametxt"), firstName);
			type(getLoc(ca, "lastnametxt"), lastName);
			type(getLoc(ca, "passwordtxt"), password);
			type(getLoc(ca, "verifypasswordtxt"), verifyPwd);
			click(getLoc(ca, "termsconditionchkbox"));
			click(getLoc(ca, "signupbtn"));
			ca.enterBirthDetails(monthoption, yearoption, genderoption);
			type(getLoc(ca, "mobilenotxt"), phoneoption);
			click(getLoc(ca, "alldonebtn"));
			click(getLoc(ca, "notnowlink"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getEmail() {
		return ca.generateRandomEmailAddr();
	}

	public void reviewDish(String menuType, String MenuItemReview, String revComment) {
		try {
			ms.selectMenu(Tabs.MENUS);
			o.selectRestaurant(menuType);
			o.selectDishFromMenu(MenuItemReview);
			click(getLoc(ms, "reviewbtn"));
			r.selectEmoji(Emoji.NEUTRAL);
			r.swipeSlider(getLoc(r, "slider1"));
			r.fillSubmitReview(revComment);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void orderItemFrom(String cafe, String item, int qty) {
		try {
			String finalPrice;
			ms.selectMenu(Tabs.ORDER);
			o.handleLetsOrder();
			o.selectRestaurant(cafe);
			o.selectDishFromMenu(item);
			finalPrice = o.changeItemQty(qty);
			o.addToMyOrder(finalPrice);
			o.reviewOrder();
			o.goBackMenuFromOrdReview();
		} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();			
		}
	}
	
	public void login(String email, String password) throws Throwable {
		try {
			click(getLoc(ls, "signInUpBtn"));
			click(getLoc(ls, "emailtxt"));
			keyBoardSendKeys(email);
			click(getLoc(ls, "passwordtxt"));
			keyBoardSendKeys(password);
			click(getLoc(ls, "signinbtn"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AddPaymentMethod(String ccNumber, String expMonth, String expYear, String cvv, String zip) throws InterruptedException {
		ms.selectMenu(Tabs.PAY);
		p.addPayMethod();
		p.fillCardDetails(ccNumber, expMonth, expYear, cvv, zip);
		p.verifyCardLinked();
	}

	public void backToOrderMenu() {
		click(getLoc(r, "backbntn1"));
		click(getLoc(r, "backbntn1"));
	}
}
