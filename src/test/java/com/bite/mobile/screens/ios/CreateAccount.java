package com.bite.mobile.screens.ios;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Purpose of this screen is to have all the controls properties and functions of Create An Account Screen for Android
 * @author Ramesh Kudikala
 *
 */
public class CreateAccountScreen_iOS extends ScreenBase {
	
	/**
	 * Constructor of Create An Account Screen.
	 * @param driver
	 */
	public CreateAccountScreen_iOS(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 60, TimeUnit.SECONDS), this);
	}
	
	public static By createAnaccountlbl;
	public static By emailtxt;
	public static By nextbtn;
	public static By guestSignIn;
	public static By nextletscreateanaccountlbl;
	public static By editboxes;
	public static By firstnametxt;
	public static By lastnametxt;
	public static By passwordtxt;
	public static By verifypasswordtxt;
	public static By termsconditionchkbox;
	public static By privacypolicylink;
	public static By signupbtn;
	
	public static By Monthbtn;
	public static By yearbtn;
	public static By genderbtn;
	public static By mobilenotxt;
	public static By alldonebtn;
	public static By popupoptions;
	public static By notnowlink;
	
	
	static {
		
		createAnaccountlbl = By.xpath("//[@text='Create an Account']");
		emailtxt = By.xpath("//*[@placeholder='Email']");
		nextbtn = By.xpath("//*[@name='UITestNext']");
		guestSignIn = By.xpath("//[@name='UITestGuestSignIn']");
		nextletscreateanaccountlbl = By.xpath("/[@text='Next, let’s create an account:']");
		editboxes = By.xpath("//android.widget.EditText");
		firstnametxt = By.xpath("//*[@placeholder='First Name']");
		lastnametxt = By.xpath("//*[@placeholder='Last Name']");
		passwordtxt = By.xpath("//*[@placeholder='Password']");
		verifypasswordtxt = By.xpath("//*[@placeholder='Verify Password']");
		termsconditionchkbox = By.xpath("//*[@name='UITestAcceptTerms']");
		privacypolicylink = By.xpath("//[@text='privacy policy']");
		signupbtn = By.xpath("//*[@label='SIGN UP']");
		
		Monthbtn = By.xpath("//*[@placeholder='Month']");
		yearbtn = By.xpath("//*[@placeholder='Year']");
		genderbtn = By.xpath("//*[@name='UITestGenderPicker']");
		mobilenotxt = By.xpath("//[@text='Mobile Number']");
		alldonebtn = By.xpath("//*[@label='ALL DONE!']");
		
		popupoptions = By.xpath("//android.widget.TextView[@resource-id='android:id/text1']");
		notnowlink = By.xpath("//android.widget.Button[@text='Not now']");

	}
	
	public static String RandomEmail() {
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		return "bitetest"+ randomInt +"@gmail.com";
	}

	public static void selectValueFromPopUp(String value, String name) {
		try {
			Thread.sleep(2000);
			TouchAction TA = new TouchAction(driver);
			List<MobileElement> options = driver.findElements(popupoptions);
			int count = options.size();
			if (count>=1) {
				for (MobileElement mobileElement : options) {
					Thread.sleep(500);
					if (mobileElement.getText().equals(value)) {
						TA.tap(mobileElement).waitAction(2500).release().perform();
						Thread.sleep(500);
						test.log(LogStatus.PASS, "To Verify is User able to click on " + name, mobileElement.getText() + " clicked successfully");
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.ERROR, "To verify " + value + " is clickable with in provided time ",
					"An exception occurred waiting for " + value + " to enter text" + e.getMessage());
		}
		
	}



}
