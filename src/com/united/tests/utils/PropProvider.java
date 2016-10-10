package com.united.tests.utils;

import java.io.IOException;
import java.util.Properties;

public class PropProvider {
    
    private final String browser;
    private final String url;
    private final String implicitWaitTimeInSeconds,pageLoadTimeInSeconds;
    private static PropProvider instance;
    
    private PropProvider() {

        Properties testProperties = new Properties();
        try {
            testProperties.load(getClass().getResourceAsStream("config.prop"));
        } catch (IOException e) {
            throw new RuntimeException("Could not read properties in config.prop!", e);
        }
        if (testProperties.isEmpty()) {
            throw new RuntimeException("config.prop is empty.");
        }
        
        browser = testProperties.getProperty("browser");
        url = testProperties.getProperty("url");
        implicitWaitTimeInSeconds = testProperties.getProperty("implicitWaitTimeInSeconds");
        pageLoadTimeInSeconds = testProperties.getProperty("pageLoadTimeInSeconds");
    }
    
    public static PropProvider getInstance() {
        if (instance == null) {
            instance = new PropProvider();
        }
        return instance;
    }
    
    public String getBrowser() {
        return browser;
    }
    
    public String getUrl() {
        return url;
    }
    
    public String getImplicitWaitTimeInSecs() {
        return implicitWaitTimeInSeconds;
    }
    
    public String getpageLoadTimeInSecs() {
        return pageLoadTimeInSeconds;
    }
}
