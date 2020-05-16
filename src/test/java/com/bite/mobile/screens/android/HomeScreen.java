package com.bite.mobile.screens.android;

import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.utility.XBy;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomeScreen extends ScreenBase {
	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	//public XBy LetsStart = new XBy("//android.widget.Button[@content-desc=\"UITestStartButton\"]", "Let's Start button");
	//*[@text=concat('LET', "'", 'S START')]
	//*[@text=concat('LET', "'", 'S START')]
	public XBy letsStartbtn = new XBy("//*[@text=concat('LET', \"'\", 'S START')]", "Let's Start button");
	//*[@text='Allow only while using the app']
	public XBy allowFgOnly = new XBy("//*[@id='permission_allow_foreground_only_button']", "Allow GPS Permission Foreground only");
	public XBy allowAlways = new XBy("//*[@id='permission_allow_always_button']", "Allow GPS Permission Always");
	public XBy deny = new XBy("//*[@id='permission_deny_button']", "Deny GPS Permission");

	//*[@text=concat('We can', "'", 't find locations near you. Please search by name.')]
	//*[@contentDescription='UITestClosePopup']
	//*[@text='OK'] -- close popup cannot find locations
	public XBy searchlocationnametext = new XBy("//android.widget.EditText[@content-desc='UITestSearchLocation']", "Location search box");
	
	//*[@text='Select your location'] --location screen title
	//*[@contentDescription='UITestSearchLocation'] --
	//*[@contentDescription='UITestSearchButton'] --
	public XBy searchButton = new XBy("//android.widget.Button[@content-desc='UITestSearchButton']", "Location search button");
	public XBy searchLocList = new XBy("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.LinearLayout']]]/*/*[@class='android.widget.TextView' and ./parent::*[@class='android.view.ViewGroup']])", "Search Loc List");
	public XBy searchListItem1 = new XBy("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.LinearLayout']]]/*/*[@class='android.widget.TextView' and ./parent::*[@class='android.view.ViewGroup']])[1]", "Search Loc List Item 1");
	public XBy okbtn = new XBy("//*[@text='OK']", "Location selection OK button");	
	
	//*[@id='loadingProgressBar']

	@Override
	public void selectFirstLocation() {
		try {
			List<MobileElement> locationsList = getAllLocSearchList();
			int count = locationsList.size();
			//for (int i = 1; i < count; i++) {
				click(locationsList.get(0));
				test.log(LogStatus.PASS, "User to select first location in search results", "First location selected");
				//break;
			//}
		} catch (Exception e) {
			test.log(LogStatus.ERROR, "User to select first location in search results", "Exception occurred: "+ e.getStackTrace());
		}
	}
	
	public List<MobileElement> getAllLocSearchList() {
		waitForElementPresent(searchLocList);
		waitForElementClickable(searchLocList);
		return driver.findElements(searchLocList.xpath());
	}
	
	@Override
	public void handleLetsStartButton() throws Throwable{
		click(letsStartbtn);
		if (isElementPresent(letsStartbtn)) {
			click(letsStartbtn);
		}
	}
}
