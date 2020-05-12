package com.bite.mobile.screens.android;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen_android extends ScreenBase {
	public HomeScreen_android(AppiumDriver<MobileElement> driver) {
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


	static {
		
		LetsStart = By.xpath("//android.widget.Button[@content-desc=\"UITestStartButton\"]");
		LetsStartbtn = By.xpath("//*[@text=concat('LET', \\\"'\\\", 'S START')]");
		allowbtn = By.xpath("//android.widget.Button[@text='Allow']");
		allowbtn_1 = By.xpath("com.android.packageinstaller:id/permission_allow_button");
		searchlocationnametext = By.xpath("//android.widget.EditText[@content-desc='UITestSearchLocation']");
		searchButton = By.xpath("//android.widget.Button[@content-desc='UITestSearchButton']");
        springvaleoption = By.xpath("//android.widget.ListView[@content-desc=\"UITestLocationsList\"]/android.widget.LinearLayout[1]/android.view.ViewGroup/android.view.ViewGroup");
		okbtn = By.xpath("//*[@text='OK']");
	}
	

	public static void selectLocation() throws InterruptedException{
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
