package com.bite.mobile.screens.android;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.utility.XBy;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Pay extends ScreenBase {
	public Pay(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	// *[@class='android.widget.ProgressBar']

	XBy addpayment = new XBy("//android.widget.Button[@text='ADD PAYMENT METHOD']", "Add Payment method");
	XBy linkcard = new XBy("//*[@text='LINK CARD']", "Link card button");
	XBy cardNumber = new XBy("//android.widget.EditText[@text='Card Number']", "cC number box");
	XBy month = new XBy("//android.widget.Button[@text='MM']", "Expiry month box");
	//*[@id='select_dialog_listview']/*[@id='text1' and @text='05']
	XBy year = new XBy("//android.widget.Button[@text='YYYY']", "Expiry Year box");
	//*[@id='select_dialog_listview']/*[@id='text1' and @text='2024']
	XBy cvv = new XBy("//android.widget.EditText[@text='CVV']", "CVV box");
	XBy zipcode = new XBy("//android.widget.EditText[@text='Zip code']", "");
	XBy setUpPayBtn = new XBy("//*[@text='SET UP BITE PAY']", "Bite Pay setups");
	
	//*[@text='Unable to create Credit Card']
	//*[@class='android.widget.TextView' and @text='Unable to create Credit Card' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[./parent::*[@class='android.widget.ScrollView']]]]
	XBy failCCLinkPopUp = new XBy("//*[@text='Close']", "Fail CC Link PopUp");
	
	public void handleSetUpPay() {
		click(setUpPayBtn);
	}
	
	public void selectMonYr(String expMonYr) {
		click(new XBy("//*[@text='"+expMonYr+"']","Exp month selected: "+expMonYr));
	}
	
	public void verifyCardLinked() {
		XBy notLinkMsg = new XBy ("//*[@class='android.widget.TextView' and @text='Unable to create Credit Card' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[./parent::*[@class='android.widget.ScrollView']]]]", "Card Link not success");
		waitForElementPresent(notLinkMsg);
		if (isElementPresent(notLinkMsg)) {
			test.log(LogStatus.FAIL, "CC Linking", "Unable to create Credit Card");
		} else {
			test.log(LogStatus.PASS, "CC Linking", "CC linked successfully");
		}
	}
	
	public void addPayMethod() {
		click(addpayment);
	}
	
	public void fillCardDetails(String ccNumber, String expMonth, String expYear, String cvv, String zip) {
		type(cardNumber, ccNumber);
		click(month);
		selectMonYr(expMonth);
		click(year);
		selectMonYr(expYear);
		type(this.cvv, cvv);
		type(zipcode, zip);
		click(linkcard);
	}

}
