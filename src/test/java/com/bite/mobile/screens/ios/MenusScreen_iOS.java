package com.bite.mobile.screens.ios;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenusScreen_iOS extends ScreenBase {
	public MenusScreen_iOS(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);

	}
	public static By backImageButtonFromLogout;
	public static By backImageFromProfile;
	public static By newstab;
	public static By menustab;
	public static By rewardstab;
	public static By ordertab;
	public static By paytab;
	public static By menuitems;
	public static By date;
	public static By item;
	public static By reviewbtn;

	

	static {
		
		backImageButtonFromLogout = By.xpath("//android.widget.ImageButton");
		backImageFromProfile = By.xpath("//android.widget.ImageButton");
		newstab = By.xpath("//android.widget.TextView[@text='NEWS']");
		menustab = By.xpath("//android.widget.TextView[@text='MENUS']");
		rewardstab = By.xpath("//android.widget.TextView[@text='REWARDS']");
		ordertab = By.xpath("//android.widget.TextView[@text='ORDER']");
		paytab = By.xpath("//android.widget.TextView[@text='PAY']");
		menuitems = By.xpath("//android.widget.TextView[@text='android.widget.TextView']");
		date = By.xpath("//android.widget.TextView[@text='Sat']");
		item = By.xpath("//android.widget.TextView[@text='Roast Turkey & Rice Soup']");
		reviewbtn = By.xpath("//android.widget.Button[@text='REVIEW']");

	}
	
	public static  void selectMenuItem(String menuType) throws InterruptedException {
		List<MobileElement> menuitems = driver.findElementsByXPath("//android.widget.TextView");
		Thread.sleep(500);
		int count = menuitems.size();
		if (count>=1) {
			for (MobileElement mobileElement : menuitems) {
				Thread.sleep(500);
				System.out.println("Menu Item is : " + mobileElement.getText());
				if (mobileElement.getText().trim().contains(menuType)) {
					Thread.sleep(500);
				     mobileElement.click();
				     break;
				}
			}
		}
	}

	
	

}
