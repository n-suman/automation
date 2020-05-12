package com.bite.mobile.screens.ios;

import java.util.List;
import java.util.concurrent.TimeUnit;
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
	
	public XBy LetsStart = new XBy("//[@name='UITestStartButton']",  "Let's Start button");
	public XBy LetsStartbtn = new XBy("//*[@text=concat('LET', \\\"'\\\", 'S START')]",  "Let's Start button");
	public XBy allowbtn = new XBy("//[@text='Allow']", "Allow GPS Permission");
	public XBy searchlocationnametext = new XBy("//*[@text='Search location name']", "Location search box");
	public XBy searchButton = new XBy("//*[@name='UITestSearchButton']", "Location search button");
	public XBy springvaleoption = new XBy("//*[@name='UITestLocationsList']", "First Option in Search Loc List");
	public XBy okbtn = new XBy("//*[@text='OK']", "Location selection OK button");
	public XBy locationList =new XBy("//*[@text='Empty list']", "List of Locations");

	public void selectLocation() throws InterruptedException{
		System.out.println("Started clicking for location list");
		String getText11=null;
		try {
			Thread.sleep(1000);
		List<MobileElement> locationsList = driver.findElementsByXPath("//[@name='UITestLocationsList']");
		System.out.println("finding one location");
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
