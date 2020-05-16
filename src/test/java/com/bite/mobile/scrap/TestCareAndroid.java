package com.bite.mobile.scrap;

public class TestCareAndroid {
//    private String reportDirectory = "reports";
//    private String reportFormat = "xml";
//    private String testName = "Untitled";
//    protected AndroidDriver<AndroidElement> driver = null;
//
//    DesiredCapabilities dc = new DesiredCapabilities();
//    
//    @BeforeMethod
//    public void setUp() throws MalformedURLException {
//        dc.setCapability("reportDirectory", reportDirectory);
//        dc.setCapability("reportFormat", reportFormat);
//        dc.setCapability("testName", testName);
//        dc.setCapability(MobileCapabilityType.UDID, "");
//        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
//        driver.setLogLevel(Level.INFO);
//    }
//
//    @Test
//    public void testUntitled() {
//        driver.findElement(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@id='toolbar']]]/*/*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup']])[1]")).click();
//        driver.findElement(By.xpath("//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]")).click();
//        driver.findElement(By.xpath("//*[@contentDescription='UITestLocationsList']")).click();
//        driver.findElement(By.xpath("//*[@contentDescription='UITestSearchLocation']")).sendKeys("Rio");
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@contentDescription='UITestSearchButton']")));
//        driver.findElement(By.xpath("//*[@contentDescription='UITestSearchButton']")).click();
//        driver.findElement(By.xpath("//*[@text=concat('CROSSROADS CAFE', \"'\", ' AT RIO')]")).click();
//        
//        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='MENUS']")));
//        driver.findElement(By.xpath("//*[@text='MENUS']")).click();
//        driver.findElement(By.xpath("//*[@text='Corporate Master Menu']")).click();
//        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Split Pea With Smoked Ham']")));
//        driver.findElement(By.xpath("//*[@text='Split Pea With Smoked Ham']")).click();
//        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='REVIEW']")));
//        driver.findElement(By.xpath("//*[@text='REVIEW']")).click();
//        driver.findElement(By.xpath("//*[@contentDescription='UITestEmojiControl']")).click();
//        new TouchAction(driver).press(457, 678).waitAction(Duration.ofMillis(807)).moveTo(632, 664).release().perform();
//        new TouchAction(driver).press(453, 878).waitAction(Duration.ofMillis(1469)).moveTo(817, 871).release().perform();
//        driver.findElement(By.xpath("//*[@contentDescription='UITestSlider' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='5/10']] and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Would you eat it again?']]]]]")).click();
//        driver.findElement(By.xpath("//*[@contentDescription='UITestSlider' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='5/10']]]]")).click();
//        driver.findElement(By.xpath("//*[@contentDescription='UITestSlider' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='9/10']] and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='How likely are you to recommend this dish to a friend or colleague?']]]]]")).click();
//        driver.findElement(By.xpath("//*[@text='SUBMIT']")).click();
//        driver.findElement(By.xpath("//*[@text='How likely are you to recommend this dish to a friend or colleague?']")).click();
//        
// 
//        driver.findElement(By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup']]")).click();
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]")));
//        driver.findElement(By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]")).click();
//        driver.findElement(By.xpath("//*[@text='ORDER']")).click();
//        driver.findElement(By.xpath("//*[@text='CROSSROADS CAFE AT RIO']")).click();
//        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Chicken Teriyaki']")));
//        driver.findElement(By.xpath("//*[@text='Chicken Teriyaki']")).click();
//        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='+']")));
//        driver.findElement(By.xpath("//*[@text='+']")).click();
//        new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='ADD TO MY ORDER']")));
//        driver.findElement(By.xpath("//*[@text='ADD TO MY ORDER']")).click();
//        driver.findElement(By.xpath("//*[@text='2 items added to order!Total items in basket: 2']")).click();
//        driver.findElement(By.xpath("//*[@text='REVIEW ORDER']")).click();
//        driver.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
//        driver.findElement(By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup']]")).click();
//        driver.findElement(By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]")).click();
//        driver.findElement(By.xpath("//*[@class='android.view.ViewGroup' and ./*[@class='android.view.ViewGroup' and ./*[@text='Rio Cafe (with SubConnection)']]]")).click();
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Turkey']")));
//        driver.findElement(By.xpath("//*[@text='Turkey']")).click();
//        driver.findElement(By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup' and ./*[@text='White']]]")).click();
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='+']")));
//        driver.findElement(By.xpath("//*[@text='+']")).click();
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='$15.38']")));
//        driver.findElement(By.xpath("//*[@text='$15.38']")).click();
//        driver.findElement(By.xpath("//*[@text='ADD TO MY ORDER']")).click();
//        driver.findElement(By.xpath("//*[@text='2 items added to order!Total items in basket: 2']")).click();
//        driver.findElement(By.xpath("//*[@text='REVIEW ORDER']")).click();
//        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='PICKUP TIME']")));
//        driver.findElement(By.xpath("//*[@text='PICKUP TIME']")).click();
//        driver.findElement(By.xpath("//*[@text='Time is not available yet']")).click();
//        driver.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
//        driver.findElement(By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Item Details']]]]")).click();
//        driver.findElement(By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]")).click();
//        driver.findElement(By.xpath("//*[@text='PAY']")).click();
//        driver.findElement(By.xpath("//*[@text='ADD PAYMENT METHOD']")).click();
//        driver.findElement(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]]/*/*[@class='android.widget.EditText'])[1]")).click();
//        driver.findElement(By.xpath("//*[@id='keyboard_view' and @class='android.widget.RelativeLayout']")).click();
//        driver.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
//    }
//    
//    public void tearDown() {
//        driver.quit();
//    }
}