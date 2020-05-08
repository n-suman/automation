package com.bite.mobile.lib.android;

import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.screens.android.HomeScreen_android;
import com.bite.mobile.screens.android.LoginScreen_android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginScreenLib_android extends ScreenBase{

	public String SignSignUpBtn = "SIGN IN / SIGN UP";
	public String emailtxt = "Email address";
	public String passwordtxt = "Password";
	public String signinbtn = "SignIn";
	
	public LoginScreenLib_android(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void Login(String email, String password) throws Throwable {
		try {

            click(LoginScreen_android.SigninSignupbtn, SignSignUpBtn);
            Thread.sleep(3000);
            Tap(505, 1702, emailtxt);
            keyBoardSendKeys(email);
            Thread.sleep(3000);
            Tap(379, 1683, passwordtxt);
            keyBoardSendKeys(password);
            Thread.sleep(3000);
           // Type(LoginScreen.emailtxt, email, emailtxt);
           // Type(LoginScreen.passwordtxt, password, passwordtxt);
            click(LoginScreen_android.signinbtn, signinbtn);
            Thread.sleep(3000);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
