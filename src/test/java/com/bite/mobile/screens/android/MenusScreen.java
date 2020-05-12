package com.bite.mobile.screens.android;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.utility.XBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenusScreen extends ScreenBase {
	public MenusScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
	}
	
	public By backImageButton = new XBy("//android.widget.ImageButton", "Navigate Back image");
	
	public By newstab = new XBy("//android.widget.TextView[@text='NEWS']", "Tab: News");
	public By menustab = new XBy("//android.widget.TextView[@text='MENUS']", "Tab: Menu");
	public By rewardstab = new XBy("//android.widget.TextView[@text='REWARDS']", "Tab: Rewards");
	public By ordertab = new XBy("//android.widget.TextView[@text='ORDER']", "Tab: Order");
	public By paytab = new XBy("//android.widget.TextView[@text='PAY']", "Tab: Pay");
	public By menuitems = new XBy("//android.widget.TextView[@text='android.widget.TextView']", "Menu Items");
	public By date = new XBy("//android.widget.TextView[@text='Sat']", "Date selection: Saturday");
	public By item = new XBy("//android.widget.TextView", "Item on menu");
	public By reviewbtn = new XBy("//android.widget.Button[@text='REVIEW']", "Review button");
	
	public void selectMenuItem(String menuType) throws InterruptedException {
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
