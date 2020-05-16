package com.bite.mobile.tests;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.bite.mobile.base.TestBase;
import com.bite.mobile.lib.*; 
import com.bite.mobile.utility.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class E2E extends TestBase{
		
	CommonDeviceLib common;
		
	@BeforeTest
	public void init(ITestContext context){
	   common = new CommonDeviceLib(driver);
	   test = extent.startTest(context.getName());
	   test.log(LogStatus.INFO, "new test started: "+context.getName());
	}
	
	@Test(priority = 0, dataProvider="launch", testName="Launch App and search")
	public void LaunchBiteApp(String location) throws InterruptedException{
			try {
			common.launchAndSearchLoc(location);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}
	
	@Test(priority = 1, dataProvider = "CreateAccountData", testName = "Create Account" )
	public void CreateAnAccount(String email, String createAnAccountlbl,  String nextletscreateaccountlbl, String firstName, String  lastName, String password, String verifyPwd, String  monthoption, String yearoption, String genderoption, String phoneoption ) throws Throwable
	{    
		try {
			common.CreateAnAccount(createAnAccountlbl, nextletscreateaccountlbl, firstName, lastName, password, verifyPwd, monthoption, yearoption, genderoption, phoneoption);       	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2, testName = "Review Order", dataProvider = "menuData")
	public void reviewOrder(String menuType, String	MenuItemReview, String cafeName, String	MenuItem, String ReviewComment) {
		try {
			common.reviewDish(menuType, MenuItemReview,ReviewComment);
			common.backToOrderMenu();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3, testName = "Order items", dataProvider = "menuData")
	public void Order(String menuType, String	MenuItemReview, String cafeName, String	MenuItem, String ReviewComment) throws InterruptedException {
		common.orderItemFrom(cafeName, MenuItem, 2);
	}
		
	@Test(priority = 4, testName = "Link card", dataProvider = "paySetup")
	public void LinkCard(String CCNumber, String ExpMonth, String ExpYear, String Cvv, String Zip) throws InterruptedException {
		common.AddPaymentMethod(CCNumber, ExpMonth, ExpYear, Cvv, Zip);
	}

	@DataProvider(name = "launch")
	public static Object[][] launchData() {
		return TestUtil.getData("launch");
	}

	@DataProvider(name = "login")
	public static Object[][] login() {
		return TestUtil.getData("login");
	}

	@DataProvider(name = "CreateAccountData")
	public static Object[][] CreateAccountData() {
		return TestUtil.getData("createanaccount");
	}

	@DataProvider(name = "menuData")
	public static Object[][] menuData() {
		return TestUtil.getData("menuData");
	}
	
	@DataProvider(name = "paySetup")
	public static Object[][] paySetup() {
		return TestUtil.getData("paySetup");
	}
	
	@AfterTest
	public void quit() {
		extent.endTest(test);
		extent.flush();
		extent.close();
		driver.close();
		System.out.println("Ending Script....");
	}

}
