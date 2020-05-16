package com.bite.mobile.screens.android;

import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.utility.XBy;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class Order extends ScreenBase {
	public Order(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	// *[@text='CROSSROADS CAFE AT RIO']
	// *[@text='Rio Cafe (with SubConnection)']
	// *[@text='Turkey'] ----menu item to be selected
	// *[@text='Roasted
	// Chicken']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView
	// price box for the given menu item

	public XBy letsorder = new XBy("//*[@class='android.widget.Button']", "Lets order button");
	public XBy orderItems = new XBy("//*[android.widget.TextView]", "All menu items"); /// all text items on
																						/// the menu order
																						/// screen

	// item details screen
	public XBy incOrder = new XBy("//*[@text='+']", "increase item qty");
	// *[@text='+']/parent::android.view.ViewGroup/preceding-sibling::android.view.ViewGroup/android.widget.TextView
	// ---increment value
	// *[@text='-'] =---decrease item qty
	//*[@text='+']/parent::android.view.ViewGroup/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView
	// ---final price
	// *[@text='Bread']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup//android.widget.ImageView/following-sibling::android.view.ViewGroup/*[@text='White']
	// --bread selection
	public XBy addtomyorder = new XBy("//android.widget.Button[@text='ADD TO MY ORDER']", "Add to my order button");
	public XBy ordAddConfirm = null;// = new XBy("//*[@text='2 items added to order!\nTotal items in basket: 2']
									// ---items added
	// message

	public XBy revieworder = new XBy("//android.widget.Button[@text='REVIEW ORDER']", "Review button");
	// *[@class='android.widget.ProgressBar']

	public XBy pleaseloginlbl = new XBy("//*[@text='Please login if you want to submit an order.']",
			"Please login label");
	public XBy loginbtn = new XBy("//android.widget.Button[@text='LOGIN']", "Login button");
	public XBy phonenumber = new XBy("//android.widget.EditText[@text='Phone number']", "Phone number text box");
	public XBy timeslot = new XBy("android.widget.Button", "Timeslot button");
	public XBy pickuplbl = new XBy("//android.widget.TextView[@text='PICKUP TIME']", "Pickup time lable");
	public XBy orderlbl = new XBy("//android.widget.TextView[@text='ORDER']", "Order label");
	public XBy placeorderbtn = new XBy("//android.widget.Button[@text='PLACE ORDER']", "Place order button");
	public XBy totalamt = new XBy("//android.widget.TextView[@text='ORDER']", "Total amount of order");
	public XBy enterspecialinstructiontxt = new XBy(
			"//android.widget.EditText[@text='Enter Special Instructions Here']", "Special Instructions text box");
	public XBy addpaymentMethod = new XBy("//android.widget.Button[@text='ADD PAYMENT METHOD']", "Add payment method");
	public XBy addpaymentMethod1 = new XBy("android:id/button1", "Add payment method", "ID");
	public XBy priceCalcProgress = new XBy("//*[@class='android.widget.ProgressBar']/parent::android.view.ViewGroup/following-sibling::*/*[@text='Price calculating...']", "Progress Bar, Price calculating");
	public XBy goBackOrderReview = new XBy("//*[@class='android.widget.ImageButton']", "Go Back from Order review");
	public XBy goBackItemDetails = new XBy("//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup' and ./*[@text='Item Details']]]]","Go Back on Item details");
	public XBy goBackMenuPage = new XBy("//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]", "Go Back on Menu page");
	
	
	public static void selectTimeSlot() throws InterruptedException {
		List<MobileElement> btn = driver.findElementsByXPath("android.widget.Button");
		List<MobileElement> text = driver.findElementsByXPath("android.widget.TextView");
		btn.get(0).click();
		text.get(5).click();
	}

	// qty to for total orders
	@Override
	public String changeItemQty(int qty) {
		String finalPrice = null;
		for (int i = 0; i < qty - 1; i++) {
			click(incOrder);
		}
		finalPrice = getFinalPriceOfOrder();
		ordAddConfirm = new XBy("//*[@text='" + qty + " items added to order!\nTotal items in basket: " + qty + "']",
				"Qty order confirmation flash screen");
		return finalPrice;
	}

	public String getFinalPriceOfOrder() {
		XBy price = new XBy("//*[@text='+']/parent::android.view.ViewGroup/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView",
				"Final Price of Order");
		return getText(price);
	}

	@Override
	public void addToMyOrder(String price) throws Throwable {
		click(addtomyorder);
		verifyProgressFlash(ordAddConfirm);
	}

	public void selectRestaurant(String restName) throws InterruptedException {
		test.log(LogStatus.INFO, "Attempting to select Restaurant");
		XBy rest = new XBy("//*[@text='"+restName+"']", "Restaurant to select menu: "+restName);
		click(rest);
	}

	public void handleLetsOrder() {
			click(letsorder);
	}

//	public void selectDishFromMenu(String dishName) {
//	XBy dishList = new XBy("(//*[@contentDescription='UITestMenuItemsList']//*[@class='android.widget.LinearLayout']//*[@class='android.view.ViewGroup']/*[@class='android.widget.TextView'])",
//			"List of all items in menu");
//	List<MobileElement> dishes = driver.findElements(dishList.xpath());
//	for (MobileElement dish:dishes) {
//		if(dish.getText().equalsIgnoreCase(dishName))
//			click(dish);
//	}
//}

	@Override
	public void selectDishFromMenu(String dishName) {
		test.log(LogStatus.INFO, "Attempting to select dish to order");
		XBy dish = new XBy("//*[@text='"+dishName+"']", "dish selected: " + dishName);
		click(dish);
	}

	public void reviewOrder() {
		click(revieworder);
		waitForElementNotPresent(priceCalcProgress);
		swipe(538, 1707, 634, 915, 550);
		assertElementPresent(placeorderbtn);
	}
	
	public void goBackMenuFromOrdReview() {
		click(goBackOrderReview);
		click(goBackItemDetails);
		click(goBackMenuPage);
	}

	public static void AddPaymentDetails() {
		MobileElement el1 = driver.findElementById("android:id/button1");
		el1.click();
	}
}
