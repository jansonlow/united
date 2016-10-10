package com.united.tests.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.united.tests.framework.ComponentBase;

public class MyTripsComponent extends ComponentBase {

    private static final By TILE_LOCATOR = By.id("tile-mytrips");
    private static final By FLIGHT_CONF_NUM_LOCATOR = By.id("flightconfirmationNo");
    private static final By FLIGHT_LAST_NAME_LOCATOR = By.id("flightlastName");
    private static final By FLIGHT_SEARCH_LOCATOR = By.cssSelector("form[id='frm-flight-res'] button");

    public MyTripsComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoaded() {
        return isElementVisible(TILE_LOCATOR) && isElementVisible(FLIGHT_CONF_NUM_LOCATOR)
                && isElementVisible(FLIGHT_LAST_NAME_LOCATOR);
    }
    
    public void search() {
        driver.findElement(FLIGHT_SEARCH_LOCATOR).click();
    }
    
    public void setConfNum(String confNum) {
        driver.findElement(FLIGHT_CONF_NUM_LOCATOR).sendKeys(confNum);
    }
    
    public void setLastName(String lastName) {
        driver.findElement(FLIGHT_LAST_NAME_LOCATOR).sendKeys(lastName);
    }
    
    public void waitUntilLoaded() {
        waitUntilVisible(FLIGHT_CONF_NUM_LOCATOR);
    }
    
}
