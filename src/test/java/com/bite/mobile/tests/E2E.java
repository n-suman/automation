package com.bite.mobile.testScripts.android;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.bite.mobile.base.TestBase;
import com.bite.mobile.lib.android.CreateanAccountLib_android;
import com.bite.mobile.lib.android.HomeScreenLib_android;
import com.bite.mobile.lib.android.LoginScreenLib_android;
import com.bite.mobile.lib.android.MenusScreenLib_android;
import com.bite.mobile.utility.TestUtil;

public class EndToEndScript_android extends TestBase{
	
	
	HomeScreenLib_android home;
	LoginScreenLib_android login;
	CreateanAccountLib_android signup;
	MenusScreenLib_android menus;
	@BeforeTest
	public void init(){
	
	   home = new HomeScreenLib_android(driver);
	   login = new LoginScreenLib_android(driver);
	   signup = new CreateanAccountLib_android(driver);
	   menus = new MenusScreenLib_android(driver);
	}
	
	
	@Test(priority = 0, dataProvider="launch")
	public void LaunchBiteApp(String location) throws InterruptedException{
		Thread.sleep(2000);
			test = extent.startTest("TS01_Bite App: Launch App and Search For Location");
			try {
				Thread.sleep(4000);
			home.LaunchApp(location);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}
	
	@Test(priority =1, dataProvider = "CreateAccountData" )
	public void CreateAnAccount(String email, String createAnAccountlbl,  String nextletscreateaccountlbl, String firstName, String  lastName, String password, String verifyPwd, String  monthoption, String yearoption, String genderoption, String phoneoption ) throws Throwable
	{
		test = extent.startTest("TS02_Bite App: Create an Account");
         email = signup.SetEmail();
      
		try {
			signup.CreateAnAccount(email, createAnAccountlbl, nextletscreateaccountlbl, firstName, lastName, password, verifyPwd, monthoption, yearoption, genderoption, phoneoption);
	       
	       	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void SelectingItem() {
		test = extent.startTest("TS03_Bite App: Selecting menu and item");
		
       	try {
			Thread.sleep(1500);
			menus.selectMenu("Corporate Master Menu");
		   	menus.selectDateAndItem("Roast Turkey");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	}
	@Test(priority = 3)
	public void ReviewOrder() {
		test = extent.startTest("TS04_Bite App: Review Order with Rating");
		
       	try {
			Thread.sleep(1500);
			menus.selectMenu("Corporate Master Menu");
		   	menus.selectDateAndItem("Roast Turkey");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	}
	
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
