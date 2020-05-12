package com.bite.mobile.screens.ios;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.utility.XBy;
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
public class CreateAccount extends ScreenBase {
	
	/**
	 * Constructor of Create An Account Screen.
	 * @param driver
	 */
	public CreateAccount(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 60, TimeUnit.SECONDS), this);
	}

	public XBy createAnaccountlbl = new XBy("//[@text='Create an Account']", "Create an Account");
	public XBy emailtxt = new XBy("//*[@placeholder='Email']", "Email address box");
	public XBy nextbtn = new XBy("//*[@name='UITestNext']", "Button Next");
	public XBy guestSignIn = new XBy("//[@name='UITestGuestSignIn']", "Continue as Guest link");
	public XBy nextletscreateanaccountlbl = new XBy("/[@text='Next, let’s create an account:']", "Next, Let's create an Account");
	public XBy editboxes = new XBy("//android.widget.EditText", "Edit boxes");
	public XBy firstnametxt = new XBy("//*[@placeholder='First Name']", "First Name box");
	public XBy lastnametxt = new XBy("//*[@placeholder='Last Name']", "Last Name box");
	public XBy passwordtxt = new XBy("//*[@placeholder='Password']", "Password box");
	public XBy verifypasswordtxt = new XBy("//*[@placeholder='Verify Password']", "Repeat Password box");
	public XBy termsconditionchkbox = new XBy("//*[@name='UITestAcceptTerms']", "Accept T&C Check");
	public XBy privacypolicylink = new XBy("//[@text='privacy policy']", "Privacy policy link");
	public XBy signupbtn = new XBy("//*[@label='SIGN UP']", "SignUp Button");
		
	public XBy Monthbtn = new XBy("//*[@placeholder='Month']", "Date Month button");
	public XBy yearbtn = new XBy("//*[@placeholder='Year']", "Date Year button");
	public XBy genderbtn = new XBy("//*[@name='UITestGenderPicker']", "Gender selection button");
	public XBy mobilenotxt = new XBy("//[@text='Mobile Number']", "Mobile number box");
	public XBy alldonebtn = new XBy("//*[@label='ALL DONE!']",  "All Done! button");
		
	public XBy popupoptions = new XBy("//android.widget.TextView[@resource-id='android:id/text1']", "PopUp options");
	public XBy notnowlink = new XBy("//android.widget.Button[@text='Not now']", "Not Now! button");
	
	public String RandomEmail() {
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		return "bitetest"+ randomInt +"@gmail.com";
	}

	public void selectValueFromPopUp(String value, String name) {
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
