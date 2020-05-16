package com.bite.mobile.base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.bite.mobile.screens.android.MenusScreen.Tabs;
import com.bite.mobile.screens.android.Review.Emoji;
import com.bite.mobile.utility.CommonUtils;
import com.bite.mobile.utility.XBy;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class ScreenBase extends TestBase {

	public static AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;
	public long startTimer;
	public long endTimer;

	public ScreenBase(AppiumDriver<MobileElement> driver) {
		ScreenBase.driver = driver;
		wait = new WebDriverWait(driver, CommonUtils.EXPLICIT_WAIT_TIME);
	}

	public void startTimer() {
		startTimer = System.nanoTime();
	}

	public long stopTimer() {
		endTimer = System.nanoTime();
		return ((endTimer - startTimer) / 1000000) / 1000;
	}

	public void waitForElementPresent(XBy ele) {
		waitForElementPresent(ele.xpath());
	}

	public void waitForElementPresent(By ele) {
		wait.until(ExpectedConditions.presenceOfElementLocated(ele));
	}
	
	public void waitForAllElementsPresent(XBy ele) {
		waitForAllElementsPresent(ele.xpath());
	}
	
	public void waitForAllElementsPresent(By ele) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ele));
	}

	public void waitForElementNotPresent(By ele) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));
	}

	public void waitForElementNotPresent(XBy ele) {
		waitForElementNotPresent(ele.xpath());
	}

	public void waitForElementClickable(By ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void waitForElementClickable(XBy ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele.xpath()));
	}

	public void assertEquals(String actual, String expected) {
		test.log(LogStatus.INFO, "actual text on screen: " + actual);
		Assert.assertEquals(actual, expected);
	}
	
	public Boolean isElementPresent(XBy ele) {
		return isElementPresent(ele.xpath());
	}
	
	public Boolean isElementPresent(By ele) {
		try {
			driver.findElement(ele);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public void assertElementPresent(XBy ele) {
		assertElementPresent(ele.xpath(), ele.description);
	}
	
	public void assertElementPresent(By ele, String desc) {
		if (isElementPresent(ele))
			test.log(LogStatus.PASS, "Assert element present: " + desc, desc + " is present");
		else
			test.log(LogStatus.FAIL, "Assert element present: " + desc, desc + " is NOT present");
	}
	
	public void hideKeyboard() {
		driver.hideKeyboard();
	}

	public void click(XBy eleLoc) {
		click(eleLoc.xpath(), eleLoc.description);
	}

	public void click(By elementLocator, String name) {
		try {
			waitForElementPresent(elementLocator);
			waitForElementClickable(elementLocator);
			driver.findElement(elementLocator).click();
			test.log(LogStatus.PASS, "User to click " + name, name + " clicked successfully");
		} catch (Exception e) {
			test.log(LogStatus.ERROR, "User to click " + name, "An exception occurred: " + e.getStackTrace());
		}
	}

	public void click(MobileElement mobEle) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(mobEle));
			mobEle.click();
			test.log(LogStatus.PASS, "User to click " + mobEle.getTagName(), "Clicked successfully");
		} catch (Exception e) {
			test.log(LogStatus.ERROR, "User to click " + mobEle.getTagName(),
					"An exception occurred: " + e.getStackTrace());
		}
	}

	public void type(XBy eleLoc, String value) {
		type(eleLoc.xpath(), value, eleLoc.description);
	}

	public void type(By elementLocator, String value, String name) {
		try {
			waitForElementPresent(elementLocator);
			MobileElement ele = driver.findElement(elementLocator);
			ele.click();
			hideKeyboard();
			ele.sendKeys(value);
			test.log(LogStatus.PASS, "User to type in " + name, value + " entered successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "User to type in " + name, "An exception occurred: " + e.getStackTrace());
		}
	}

	public void keyBoardSendKeys(String value) {
		driver.switchTo().activeElement();
		driver.getKeyboard().sendKeys(value);
	}

	public void Tap(int x, int y, String name) {
		try {
			(new TouchAction(driver)).tap(x, y).release().perform();
			test.log(LogStatus.PASS, "To Verify is User able to Tap on " + name, name + " Tapped successfully");
		} catch (Exception e) {
//			test.log(LogStatus.ERROR, "To verify " + name + " is clickable with in provided time ",
//					"An exception occurred waiting for " + name + " to enter text" + e.getMessage());
		}
	}
	
	public void swipe(int x, int y, int newX, int newY, int ms) {
		driver.swipe(x, y, newX, newY, ms);
	}

	public String getText(XBy elementLocator) {
		return getText(elementLocator.xpath(), elementLocator.description);
	}

	public String getText(By elementLocator, String desc) {
		String text = null;
		try {
			waitForElementPresent(elementLocator);
			text = driver.findElement(elementLocator).getText();
			test.log(LogStatus.PASS, "Get Text from " + desc, "Text read is: " + text);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Get Text from " + desc, "Exception occured: " + e.getStackTrace());
		}
		return text;
	}

	public String getAttribute(XBy elementLocator, String attribute) {
		waitForElementPresent(elementLocator);
		return getAttribute(elementLocator.xpath(), attribute, elementLocator.description);
	}

	public String getAttribute(By elementLocator, String attribute, String desc) {
		String attr = null;
		try {
			waitForElementPresent(elementLocator);
			attr = driver.findElement(elementLocator).getAttribute(attribute);
			test.log(LogStatus.PASS, "Get Attribute from " + desc, "Attribute read is: " + attr);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Get Attribute from " + desc, "Exception occured: " + e.getStackTrace());
		}
		return attr;
	}

	public void verifyProgressFlash(XBy ele) {
		verifyProgressFlash(ele.xpath(), ele.description);
	}

	public void verifyProgressFlash(By ele, String desc) {
		try {
			waitForElementPresent(ele);
			startTimer();
			waitForElementNotPresent(ele);
			test.log(LogStatus.PASS, "Verify Element " + desc + " Flashed",
					"The element flashed for a brief " + stopTimer() + " seconds");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Verify Element " + desc + " Flashed", "Exception occured: " + e.getStackTrace());
		}
	}

	public void longPress(By elementLocator) throws InterruptedException {
		waitForElementPresent(elementLocator);
		waitForElementClickable(elementLocator);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(driver.findElement(elementLocator), 2500).release().perform();
	}

	public static void longPressWithText(MobileElement element) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(element, 3000).release().perform();
	}

	public static void press(By elementLocator) throws InterruptedException {
		Thread.sleep(2000);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(driver.findElement(elementLocator)).waitAction(1500).release().perform();
	}

	public static void longPressbuttonWithCooridinates(By elementLocator, int x, int y) throws InterruptedException {
		Thread.sleep(2000);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(driver.findElement(elementLocator), x, y).waitAction(2000).release().perform();
	}

//	public boolean clicked(By locator, String locatorName) throws Throwable {
//		boolean status = false;
//		try {
//			LOG.info("Click on the element:" + ""+locatorName+"");
//			if (this.testParameters.platform.equalsIgnoreCase(IFrameworkConstant.OS.ANDROID) || this.testParameters.platform.equalsIgnoreCase(IFrameworkConstant.OS.IOS)) {
//				WebDriverWait wait = new WebDriverWait(this.appiumDriver, IFrameworkConstant.EXPLICIT_WAIT_TIME);
//				wait.until(ExpectedConditions.elementToBeClickable(locator));
//				Thread.sleep(5000);
//				appiumDriver.findElement(locator).click();
//				LOG.info("Successfully clicked on the element:" + " "+locatorName+" ");
//				this.reporter.SuccessReport("Click : " + locatorName, msgClickSuccess + locatorName);
//				status = true;
//			} else {
//				WebDriverWait wait = new WebDriverWait(this.Driver, IFrameworkConstant.EXPLICIT_WAIT_TIME);
//				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//				appiumDriver.findElement(locator).click();
//				this.reporter.SuccessReport("Click : " + locatorName, msgClickSuccess + locatorName);
//				status = true;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			status = false;
//			LOG.info("Failed to Click on the element:" +""+locatorName+""+"with locator:"+""+locator.toString()+"");
//			LOG.info(e.getMessage());
//			this.reporter.failureReport("Click : " + locatorName, msgClickFailure + locatorName, Driver);
//			throw e;
//		}
//		return status;
//	}

	// base class definitions
	public XBy createAnaccountlbl, emailtxt, nextbtn, guestSignIn, nextletscreateanaccountlbl, editboxes, firstnametxt;
	public XBy lastnametxt, passwordtxt, verifypasswordtxt, termsconditionchkbox, privacypolicylink, signupbtn,
			monthbtn;
	public XBy yearbtn, genderbtn, mobilenotxt, alldonebtn, popupoptions, notnowlink;
	public XBy letsStart, letsStartbtn, allowbtn, allowbtn_1, searchlocationnametext, searchButton, searchListItem1,
			okbtn;
	public XBy SigninSignupbtn, signinbtn;
	public XBy backImageButtonFromLogout, backImageFromProfile, newstab, menustab, rewardstab, ordertab;
	public XBy paytab, menuitems, date, item, reviewbtn, cardNumber, addpayment;
	public XBy cvv, month, year, zipcode, linkcard, setUpPayBtn, failCCLinkPopUp;
	public XBy slider1, backbntn1, backbtn, tellusabout, submitbtn, commentstxt, pleaserateyourexp;

	public void selectMenu(Tabs tab) throws InterruptedException {
	}

	public void selectFirstLocation() {
	}

	public String generateRandomEmailAddr() {
		return null;
	}

	public void selectValueFromPopUp(String value) {
	}

	public void selectValueFromPopUp(String value, String name) {
	}

	public void clickLinkCard() {
	}

	public void selectRestaurant(String restName) throws InterruptedException {
	}

	public void selectDishFromMenu(String string) {
	}

	public void selectEmoji(Emoji emo) {
	}

	public void swipeSlider(XBy loc) {
	}

	public void fillSubmitReview(String revComment) throws InterruptedException {
	}

	public String changeItemQty(int qty) {
		return "";
	}

	public void addToMyOrder(String finalPrice) throws Throwable {
	}

	public void handleLetsStartButton() throws Throwable{
	}

	public void handleLetsOrder() {		
	}

	public void reviewOrder() {}

	public void enterBirthDetails(String monthoption, String yearoption, String genderoption) {}

	public void goBackMenuFromOrdReview() {}

	public void handleSetUpPay() {
		// TODO Auto-generated method stub
		
	}

	public void verifyCardLinked() {
		// TODO Auto-generated method stub
		
	}

	public void selectMonYr(String expMonth) {
		// TODO Auto-generated method stub
		
	}

	public void addPayMethod() {
		// TODO Auto-generated method stub
		
	}

	public void fillCardDetails(String ccNumber, String expMonth, String expYear, String cvv2, String zip) {
		// TODO Auto-generated method stub
		
	}

}
