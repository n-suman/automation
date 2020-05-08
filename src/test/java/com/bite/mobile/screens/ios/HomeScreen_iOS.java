package com.bite.mobile.screens.ios;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen_iOS extends ScreenBase {
	public HomeScreen_iOS(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 60, TimeUnit.SECONDS), this);

	}
	public static By LetsStart;
	public static By LetsStartbtn;
	public static By allowbtn;
	public static By allowbtn_1;
	public static By searchlocationnametext;
	public static By searchButton;
	public static By springvaleoption;
	public static By okbtn;
	public static By locationList;


	static {
		
		LetsStart = By.xpath("//[@name='UITestStartButton']");
		LetsStartbtn = By.xpath("//*[@text=concat('LET', \\\"'\\\", 'S START')]");
		allowbtn = By.xpath("//[@text='Allow']");
		searchlocationnametext = By.xpath("//*[@text='Search location name']");
		searchButton = By.xpath("//*[@name='UITestSearchButton']");
        springvaleoption = By.xpath("//*[@name='UITestLocationsList']");
		okbtn = By.xpath("//*[@text='OK']");
		locationList =By.xpath("//*[@text='Empty list']");
	}
	

	public static void selectLocation() throws InterruptedException{
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
