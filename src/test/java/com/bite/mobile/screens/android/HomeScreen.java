package com.bite.mobile.screens.android;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.utility.XBy;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends ScreenBase {
	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 60, TimeUnit.SECONDS), this);
	}
	public By LetsStart = new XBy("//android.widget.Button[@content-desc=\"UITestStartButton\"]", "Let's Start button");
	public By LetsStartbtn = new XBy("//*[@text=concat('LET', \"'\", 'S START')]", "Let's Start button");
	public By allowbtn = new XBy("//android.widget.Button[@text='Allow']", "Allow GPS Permission");
	public By allowbtn_1 = new XBy("com.android.packageinstaller:id/permission_allow_button", "Allow GPS Permission");
	public By searchlocationnametext = new XBy("//android.widget.EditText[@content-desc='UITestSearchLocation']", "Location search box");
	public By searchButton = new XBy("//android.widget.Button[@content-desc='UITestSearchButton']", "Location search button");
	public By firstOptLocList = new XBy("//android.widget.ListView[@content-desc=\"UITestLocationsList\"]/android.widget.LinearLayout[1]/android.view.ViewGroup/android.view.ViewGroup", "First Option in Search Loc List");
	public By okbtn = new XBy("//*[@text='OK']", "Location selection OK button");	

	public void selectLocation() throws InterruptedException{
		String getText11=null;
		try {
			Thread.sleep(1000);
		List<MobileElement> locationsList = driver.findElementsByXPath("//android.widget.ListView[@content-desc='UITestLocationsList']/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup");
		int count = locationsList.size();
		for (int i = 1; i < count; i++) {
			if (i>=1) {
//				getText11 = locationsList.get(0).getTagName();
				Thread.sleep(1000);
				locationsList.get(0).click();
				//test.log(LogStatus.PASS, "To Verify is User able to click on " + getText11, getText11 + " clicked successfully");
				break;
			}
		}
		} catch (Exception e) {
			test.log(LogStatus.ERROR, "To verify " + getText11 + " is clickable with in provided time ",
					"An exception occurred waiting for " + getText11 + " to enter text" + e.getMessage());
		}
	}
}
