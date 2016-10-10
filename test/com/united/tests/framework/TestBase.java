package com.united.tests.framework;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.united.tests.pages.MainPage;
import com.united.tests.utils.PropProvider;


/**
 * This base class is inherited by all test classes. Holds
 * common things such as driver, configurations, etc. Common
 * executions across all test classes before class, after class,
 * before test and after test can be put in here.
 */

public abstract class TestBase {
    
    private static String browser,url;
    private static Long implicitWaitTimeInSeconds,pageLoadTimeInSeconds;
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeClass
    public static void beforeEachTestClass() {
        initConfig();
    }
    
    @AfterClass
    public static void afterEachTestClass() {
        
    }
    
    @Before
    public void testSetup() {
        initBrowser();
        driver.get(url);
        mainPage = new MainPage(driver);
        assertTrue("United main page must be loaded successfully.", mainPage.isLoaded());
    }
    
    @After
    public void testTearDown() {
//        driver.close();
//        driver.quit();
    }
    
    private static void initConfig() {
        browser = PropProvider.getInstance().getBrowser();
        url = PropProvider.getInstance().getUrl();
        implicitWaitTimeInSeconds = Long.parseLong(PropProvider.getInstance().getImplicitWaitTimeInSecs());
        pageLoadTimeInSeconds = Long.parseLong(PropProvider.getInstance().getpageLoadTimeInSecs());
    }
    
    private void initBrowser() {
        switch(browser) {
            case "Firefox":
                driver = new FirefoxDriver(new FirefoxBinary(new File("/Applications/Firefox45.app/Contents/MacOS/firefox-bin")), new FirefoxProfile());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser <" + browser + ">.");
        }
        driver.manage().timeouts().implicitlyWait(implicitWaitTimeInSeconds, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeInSeconds, TimeUnit.SECONDS);
    }
    
}
