package com.bite.mobile.screens.ios;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.bite.mobile.base.ScreenBase;
import com.bite.mobile.utility.XBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends ScreenBase {
	public LoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
	}

	public XBy SigninSignupbtn = new XBy("//android.widget.Button[@text='SIGN IN / SIGN UP']", "Sign In/Up button");
	public XBy emailtxt = new XBy("//*[@id='logonIdentifier']", "Username box");
	public XBy passwordtxt = new XBy("//*[@id='password']", "Password box");
	public XBy signinbtn = new XBy("//*[@text='SIGN IN']", "Sign In button");

}
