package com.bite.mobile.lib.android;
import org.testng.Assert;
import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.CreateAccountScreen_android;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CreateanAccountLib_android extends ScreenBase{

	public String  createAnaccountlable ="Create an Account";
	public String  emailtxt ="Email";
	public String  nextbtn="Next";
	public String  guestSignIn = "Continue as Guest";
	public String  nextletscreateanaccountlbl = "Next, Let's create an Account";
	public String  editboxes="Edit boxes";
	public String  firstnametxt ="First Name";
	public String  lastnametxt ="LastName";
	public String  passwordtx= "Password";
	public String  verifypassword="Verify Password";
	public String  termsconditionchkbox= "Terms check box";
	public String  privacypolicylink = "Privacy policy link";
	public String  signupbtn="SIGN UP";
	
	public String month ="Month";
	public String year ="Year";
	public String gender ="Gender";
	public String phonenumber ="Phone Number";
	public String allDonebtn ="ALL DONE !";
	public String notnowlink ="Not Now link";
	
	public CreateanAccountLib_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}

	public void CreateAnAccount(String email, String createAnAccountlbl, String nextletscreateaccountlbl, String firstName, String lastName,
			String password, String verifyPwd, String monthoption, String yearoption, String genderoption, String phoneoption) throws Throwable {
		try {
			   Thread.sleep(2500);
			String actualText = getText(CreateAccountScreen_android.createAnaccountlbl);
			System.out.println(actualText +" Create Account lable");
		     Assert.assertEquals(actualText, createAnAccountlbl);
		     Type(CreateAccountScreen_android.emailtxt, email, emailtxt);
		     click(CreateAccountScreen_android.nextbtn, nextbtn);
		     Thread.sleep(2500);
		     String text = getText(CreateAccountScreen_android.nextletscreateanaccountlbl);
		     System.out.println(text +"next lets create ");
		     Assert.assertEquals(text, nextletscreateaccountlbl);
		     Type(CreateAccountScreen_android.firstnametxt, firstName, firstnametxt);
		     Type(CreateAccountScreen_android.lastnametxt, lastName, lastnametxt);
		     Type(CreateAccountScreen_android.passwordtxt, password, passwordtx);
		     Type(CreateAccountScreen_android.verifypasswordtxt, verifyPwd, verifypassword);
		     click(CreateAccountScreen_android.termsconditionchkbox, termsconditionchkbox);
		     click(CreateAccountScreen_android.signupbtn, signupbtn);
		     Thread.sleep(2500);
		     LongPressButton(CreateAccountScreen_android.Monthbtn);
		     
		     CreateAccountScreen_android.selectValueFromPopUp(monthoption, month);
		    // LongPressButton(CreateAccountScreen.yearbtn);
		     Tap(799, 907, year);
		     CreateAccountScreen_android.selectValueFromPopUp(yearoption, year);
		     Tap(248, 1113, gender);
//		     LongPressButton(CreateAccountScreen.genderbtn);
		     CreateAccountScreen_android.selectValueFromPopUp(genderoption, gender);
		     Tap(154, 1290, phonenumber);
		     Type(CreateAccountScreen_android.mobilenotxt, "+1 301-987-4772", phonenumber);
		     click(CreateAccountScreen_android.alldonebtn, allDonebtn);
		     click(CreateAccountScreen_android.notnowlink, notnowlink);
		} catch(Exception e) {
			e.printStackTrace();
			
		}
    
	
	}
	public String SetEmail() {
		String email = CreateAccountScreen_android.RandomEmail();
		return email;
	}
	
}
