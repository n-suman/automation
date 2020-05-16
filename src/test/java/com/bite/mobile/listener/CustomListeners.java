package com.bite.mobile.listener;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.bite.mobile.utility.TestUtil;

public class CustomListeners implements ITestListener, ISuiteListener {

	
	/*
	 * Mails with attachment
	 * 
	 * (non-Javadoc)
	 * @see org.testng.ISuiteListener#onStart(org.testng.ISuite)
	 */
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Starting");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Finishing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Screenshot Captured");
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.takeScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reporter.log("<a target=\"_blank\" href=\""+"screenshots/"+TestUtil.destFile+"\">Screenshot Captured</a>");
		
		Reporter.log("<br><a  target='_blank' href=\""+"screenshots/"+TestUtil.destFile+"\" ><img height=200, width=200, src=\""+"screenshots/"+TestUtil.destFile+"\" alt=\"\"/></img></a>");
	        
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("Starting the test suite");

	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("Ending the test suite");

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

}
