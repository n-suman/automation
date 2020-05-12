package com.bite.mobile.tests;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.bite.mobile.base.TestBase;
import com.bite.mobile.lib.*; 
import com.bite.mobile.utility.TestUtil;

public class E2E extends TestBase{
		
	CommonDeviceLib common;
		
	@BeforeTest
	public void init(ITestContext context){
	   common = new CommonDeviceLib(driver);
	   test = extent.startTest(context.getName());
	}
	
	@Test(priority = 0, dataProvider="launch", testName="Launch App and search")
	public void LaunchBiteApp(String location) throws InterruptedException{
			//test = extent.startTest("TS01_Bite App: Launch App and Search For Location");
			try {
			common.LaunchApp(location);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}
	
//	@Test(priority =1, dataProvider = "CreateAccountData", testName = "Create Account" )
//	public void CreateAnAccount(String email, String createAnAccountlbl,  String nextletscreateaccountlbl, String firstName, String  lastName, String password, String verifyPwd, String  monthoption, String yearoption, String genderoption, String phoneoption ) throws Throwable
//	{
//		//test = extent.startTest("TS02_Bite App: Create an Account");
//         email = common.SetEmail();
//      
//		try {
//			common.CreateAnAccount(email, createAnAccountlbl, nextletscreateaccountlbl, firstName, lastName, password, verifyPwd, monthoption, yearoption, genderoption, phoneoption);       	
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test(priority = 2, testName = "Navigate Menu")
//	public void SelectingItem() {
//		test = extent.startTest("TS03_Bite App: Selecting menu and item");
//		
//       	try {
//			Thread.sleep(1500);
//			common.selectMenu("Corporate Master Menu");
//		   	common.selectDateAndItem("Roast Turkey");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    
//	}
//	@Test(priority = 3)
//	public void ReviewOrder() {
//		test = extent.startTest("TS04_Bite App: Review Order with Rating");
//		
//       	try {
//			Thread.sleep(1500);
//			menus.selectMenu("Corporate Master Menu");
//		   	menus.selectDateAndItem("Roast Turkey");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    
//	}
	
	@DataProvider(name="launch")
	public static Object[][] launchData() {
		return TestUtil.getData("launch");
	}
	
	@DataProvider(name="CreateAccountData")
	public static Object[][] CreateAccountData() {
		return TestUtil.getData("createanaccount");
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
