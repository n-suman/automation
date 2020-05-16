package com.bite.mobile.screens.android;

import java.util.List;
import org.openqa.selenium.By;
import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.utility.XBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MenusScreen extends ScreenBase {
	public MenusScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public enum Tabs{
		NEWS,
		MENUS,
		REWARDS,
		ORDER,
		PAY
	}
		
	//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup']]
	public XBy backImageButton = new XBy("//android.widget.ImageButton", "Navigate Back image");

	//*[@contentDescription='NEWS' and @selected='true'] ----default selection
	//*[@text='Corporate Master Menu'] --restaurant to select menu

	//*[@class='android.view.ViewGroup']//*[@text='Corporate Master Menu'] -- Page title of menu screen
	//-----(//*[@contentDescription='UITestMenuItemsList']//*[@class='android.widget.LinearLayout']//*[@class='android.view.ViewGroup']/*[@class='android.widget.TextView'])
	// list of all menu items
	public By menuitems = new XBy("//android.widget.TextView[@text='android.widget.TextView']", "Menu Items");
	public By date = new XBy("//android.widget.TextView[@text='12']", "Date selection: given date");
	public By item = new XBy("//android.widget.TextView", "Item on menu");
	
	//*[@text='Recipe details'] -- Page title of Recipe details
	//*[@text='American Bounty Vegetable Soup'] --dish title
	//*[@text='Nutrition Facts'] --Nutrition facts title
	public XBy reviewbtn = new XBy("//android.widget.Button[@text='REVIEW']", "Review button");	
	public XBy nomenutxt = new XBy("//android.widget.TextView[@text='No menu for this day']", "No menu for the day message");

	

	
	@Override
	public void selectMenu(Tabs tab) throws InterruptedException {
		XBy menu;
		switch (tab) {
			case NEWS:
				menu = new XBy("//android.widget.TextView[@text='NEWS']", "Tab: News");
				break;
			case MENUS:
				menu = new XBy("//android.widget.TextView[@text='MENUS']", "Tab: Menus");
				break;
			case REWARDS:
				menu = new XBy("//android.widget.TextView[@text='REWARDS']", "Tab: Rewards");
				break;
			case ORDER:
				menu = new XBy("//android.widget.TextView[@text='ORDER']", "Tab: Order");
				break;
			case PAY:
				menu = new XBy("//android.widget.TextView[@text='PAY']", "Tab: Pay");
				break;
			default:
				menu = new XBy("//android.widget.TextView[@text='NEWS']", "Tab: News");
		}
		
		waitForElementPresent(menu);
		waitForElementClickable(menu);
		click(menu);
	}
	
	public boolean getnomenutext(String value) {
		String text = driver.findElement(nomenutxt.xpath()).getText();
		if (text.contains(value)) {
			return true;
		}
		return true;
	}

	public void selectDate(int day) throws InterruptedException {
		Thread.sleep(2000);
		List<MobileElement> days = driver.findElementsByXPath("//*[@class='android.view.ViewGroup' and ./*[@text='"+day+"']]");
		Thread.sleep(2000);
		System.out.println(days);
		days.get(0).click();
	}
	
}
