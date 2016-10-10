package com.united.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.united.tests.components.MyTripsComponent;
import com.united.tests.framework.PageBase;

public class MainPage extends PageBase {
    
    private static final By MY_TRIP_TILE_LOCATOR = By.id("tile-mytrips");
    private final MyTripsComponent myTripsTile;

    public MainPage(WebDriver driver) {
        super(driver);
        this.myTripsTile = new MyTripsComponent(driver);
    }

    @Override
    public boolean isLoaded() {
        return isElementVisible(MY_TRIP_TILE_LOCATOR);
    }
    
    public void selectMyTrips() {
        driver.findElement(MY_TRIP_TILE_LOCATOR).click();
        myTripsTile.waitUntilLoaded();
    }
    
    public MyTripsComponent getMyTripsTile() {
        return myTripsTile;
    }

}
