package com.bite.mobile.screens.android;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.utility.XBy;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

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
	}

	public XBy createAnaccountlbl = new XBy("//android.widget.TextView[@text='Create an Account']", "Create an Account");
	public XBy emailtxt = new XBy("//android.widget.EditText[@content-desc='UITestEnterEmail']", "Email address box");
	public XBy nextbtn = new XBy("//android.widget.Button[@content-desc='UITestNext']", "Button Next");
	public XBy guestSignIn = new XBy("//android.widget.Button[@content-desc='UITestGuestSignIn']", "Continue as Guest link");
	public XBy nextletscreateanaccountlbl = new XBy("//android.widget.TextView[@text='Next, let’s create an account:']", "Next, Let's create an Account");
	
	//*[@text='Sign Up'] --page title
	//*[@text='Next, let’s create an account:'] --form title
	public XBy editboxes = new XBy("//android.widget.EditText", "Edit boxes");
	//---(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]]/*/*[@class='android.widget.EditText'])[1]
	//*[@contentDescription='UITestFirstName']
	public XBy firstnametxt = new XBy("//android.widget.EditText[@content-desc='UITestFirstName']", "First Name Box");
	//*[@contentDescription='UITestLastName']
	public XBy lastnametxt = new XBy("//android.widget.EditText[@content-desc='UITestLastName']", "Last Name Box");
	//*[@contentDescription='UITestPassword']
	public XBy passwordtxt = new XBy("//android.widget.EditText[@content-desc='UITestPassword']", "Password Box");
	//*[@contentDescription='UITestVerification']
	public XBy verifypasswordtxt = new XBy("//android.widget.EditText[@content-desc='UITestVerification']", "Repeat Password Box");
	//*[@contentDescription='UITestAcceptTerms']
	public XBy termsconditionchkbox = new XBy("//android.widget.Button[@content-desc='UITestAcceptTerms']", "Accept T&C Check");
	//*[@text='privacy policy']
	public XBy privacypolicylink = new XBy("//android.widget.Button[@text='privacy policy']", "Privacy policy link");
	//*[@text='SIGN UP']
	//*[@contentDescription='UITestSignUp']
	public XBy signupbtn = new XBy("//android.widget.Button[@content-desc='UITestSignUp']", "SignUp Button");
	
	//*[@text='My Information'] -- page title
	
	public XBy monthbtn = new XBy("//android.widget.Button[@text='Month']", "Date Month button");
	//*[@contentDescription='UITestYearPicker']
	public XBy yearbtn = new XBy("//android.widget.Button[@text='Year']", "Date Year button");
	//*[@contentDescription='UITestGenderPicker']
	public XBy genderbtn = new XBy("//android.widget.Button[@text='Gender']", "Gender selection button");
	//*[@contentDescription='UITestPhoneNumber']
	public XBy mobilenotxt = new XBy("//android.widget.EditText[@text='Mobile Number']", "Mobile number box");
	//*[@contentDescription='UITestDoneButton']
	public XBy alldonebtn = new XBy("//android.widget.Button[@content-desc='UITestDoneButton']", "All Done! button");
	//--(//*[@id='select_dialog_listview']/*[@id='text1'])[5] --month
			//*[@text='May']
	public XBy popupoptions = new XBy("//android.widget.TextView[@resource-id='android:id/text1']", "PopUp options");
	//*[@id='button2'] --cancel button on Month picker
	//*[@id='button2'] -- cancel on year picker
	//---(//*[@id='select_dialog_listview']/*[@id='text1'])[4] --year
			//*[@text='2005']
			
			//*[@text='Male']
		//----	(//*[@id='select_dialog_listview']/*[@id='text1'])[1]
	//*[@id='loadingProgressBar']
	
	//*[@text='SET UP BITE PAY']
	//----((//*[@class='android.widget.Button' and @text='SET UP BITE PAY'] ))
	//---((//*[@class='android.widget.Button' and @text='Not now'] ))
	
	public XBy notnowlink = new XBy("//android.widget.Button[@text='Not now']", "Not Now! button");
	
	@Override
	public String generateRandomEmailAddr() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);  
		return "bitetest"+ randomInt +"@gmail.com";
	}
	
	@Override
	public void selectValueFromPopUp(String value) {
		selectValueFromPopUp(value, popupoptions.description);
	}

	@Override
	public void selectValueFromPopUp(String value, String name) {
		try {
			waitForAllElementsPresent(popupoptions);
			List<MobileElement> options = driver.findElements(popupoptions);
			for (MobileElement opt : options) {
				if (opt.getText().equalsIgnoreCase(value)) {
					click(opt);
					test.log(LogStatus.PASS, "User to select option from" + name, opt.getText() + " :selected");
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.ERROR, "User to select option from " + name,
					"Exception selecting option: "+value+". Message: " + e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	
	public void enterBirthDetails(String month, String year, String gender) {
		click(monthbtn);
		click(By.xpath("//*[@text='"+month+"']"), "Month selected: "+month);
		click(yearbtn);
		click(By.xpath("//*[@text='"+year+"']"), "Month selected: "+year);
	    click(genderbtn);
	    click(By.xpath("//*[@text='"+gender+"']"), "Month selected: "+gender);
	}



}
