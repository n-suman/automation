package com.bite.mobile.screens.android;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.utility.XBy;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class Review extends ScreenBase {
	public Review(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public enum Emoji {
		SAD("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup' and ./*[@text='Please rate your experience:']]]]/*/*[@class='android.widget.Button'])[1]"),
		NEUTRAL("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup' and ./*[@text='Please rate your experience:']]]]/*/*[@class='android.widget.Button'])[2]"),
		HAPPY("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup' and ./*[@text='Please rate your experience:']]]]/*/*[@class='android.widget.Button'])[3]"),
		V_HAPPY("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup' and ./*[@text='Please rate your experience:']]]]/*/*[@class='android.widget.Button'])[4]")
		;
		private final String xpathExp;
		
		Emoji(String xpathExp) {
			this.xpathExp = xpathExp;
		}
		
		public String getLoc() {
			return this.xpathExp;
		}
		
	}
	
	//*[@class='android.widget.TextView' and ./parent::*[@id='toolbar' and @text='American Bounty Vegetable Soup']] --title of the dish being reviewed
	public XBy pleaserateyourexp = new XBy("//android.widget.TextView[@text='Please rate your experience:']", "Experience rating");
		
		//------emoji_sad --(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup' and ./*[@text='Please rate your experience:']]]]/*/*[@class='android.widget.Button'])[1]
		//---emoji neutral -- (//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup' and ./*[@text='Please rate your experience:']]]]/*/*[@class='android.widget.Button'])[2]
			//--happy	(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup' and ./*[@text='Please rate your experience:']]]]/*/*[@class='android.widget.Button'])[3]
			//-- very happy			(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup' and ./*[@text='Please rate your experience:']]]]/*/*[@class='android.widget.Button'])[4]
		//*[@class='android.widget.EditText']
	public XBy commentstxt =  new XBy("//*[@text='Describe your experience']", "Feedback text");
		//*[@contentDescription='UITestSubmitSurvey']
	public XBy submitbtn =  new XBy("//android.widget.Button[@content-desc='UITestSubmitSurvey']", "Review Submit button");
	public XBy tellusabout =  new XBy("//android.widget.TextView[@text='Tell us about your experience']","Feedback text");
		//*[@class='android.widget.ImageButton'] --back button on Review dish page
	public XBy backbtn =  new XBy("//android.widget.ImageButton", "Go back navigation");
	public XBy backbntn1 =  new XBy("//android.widget.ImageView", "Go back Nav image");
		
	public XBy slider1 = new XBy("//*[@contentDescription='UITestSlider' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Did you enjoy this dish?']]]]]", "Did you enjoy this dish?");
		//*[@text='5/10' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Did you enjoy this dish?']]]]]
		
		//*[@contentDescription='UITestSlider' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Was it a good value?']]]]]
		//*[@text='5/10' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Was it a good value?']]]]]
		
		//*[@contentDescription='UITestSlider' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Would you eat it again?']]]]]
		//*[@text='5/10' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Would you eat it again?']]]]]
		
		//*[@contentDescription='UITestSlider' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='How likely are you to recommend this dish to a friend or colleague?']]]]]
		//*[@text='5/10' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='How likely are you to recommend this dish to a friend or colleague?']]]]]
	
		//*[@text='Thank you! Your feedback helps us serve you better.'] ---Feedback Response
		XBy closeFBBtn = new XBy("//*[@text='Close']", "Feedback Response close");
		//*[@contentDescription='UITestClosePopup']	
	
	@Override
	public void swipeSlider(XBy slider) {
		swipeSlider(slider.xpath(), slider.description);
	}
	
	public void swipeSlider(By slider, String desc) {
		test.log(LogStatus.INFO, "Attempting slider");
		waitForElementPresent(slider);
		waitForElementClickable(slider);
		WebElement el = driver.findElement(slider);
		  String orientation = driver.getOrientation().value();

		  // get the X coordinate of the upper left corner of the element, then add the element's width to get the rightmost X value of the element
		  int leftX = el.getLocation().getX();
		  int rightX = leftX + el.getSize().getWidth();

		  // get the Y coordinate of the upper left corner of the element, then subtract the height to get the lowest Y value of the element
		  int upperY = el.getLocation().getY();
		  int lowerY = upperY - el.getSize().getHeight();
		  int middleY = (upperY - lowerY) / 2;
		  
		  System.out.println("leftX "+leftX);
		  System.out.println("rightX "+rightX);
		  System.out.println("upperY "+upperY);
		  System.out.println("lowerY "+lowerY);
		  System.out.println("middleY "+middleY);
		  
		  if (orientation.equals("portrait")) {
		    // Swipe from just inside the left-middle to just inside the right-middle of the element over 500ms
		      driver.swipe(leftX + 5, middleY, rightX - 5, middleY, 500);
		  } else if (orientation.equals("landscape")) {
		    // Swipe from just inside the right-middle to just inside the left-middle of the element over 500ms
		    driver.swipe(rightX - 5, middleY, leftX + 5, middleY, 500);
		  }
		 // new TouchAction(driver).press(432, 671).waitAction(Duration.ofMillis(2406).getNano()).moveTo(771, 657).release().perform();
		}
	
	@Override
	public void selectEmoji(Emoji emo) {
		XBy emoO = new XBy(emo.xpathExp, "Emoji selected: "+emo.name().toString());
		click(emoO);
	}
	
	@Override
	public void fillSubmitReview(String comment) throws InterruptedException {
		type(commentstxt, comment);
		click(submitbtn);
		click(closeFBBtn);
	}
}
