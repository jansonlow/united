package com.united.tests.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public abstract class ComponentBase {

    protected WebDriver driver;

    public abstract boolean isLoaded();

    public ComponentBase(WebDriver driver) {
        this.driver = driver;
    }

    protected boolean doesElementExist(By locator) {
        try {
            driver.findElement(locator);
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
        return true;
    }

    protected boolean isElementVisible(By locator) {
        if (doesElementExist(locator)) {
            return driver.findElement(locator).isDisplayed();
        } else {
            return false;
        }
    }

    protected WebElement waitUntilVisible(final By by) {
        List<Class<? extends Throwable>> classes = new ArrayList<Class<? extends Throwable>>();
        classes.add(StaleElementReferenceException.class);
        classes.add(NoSuchElementException.class);
        classes.add(NoSuchFrameException.class);
        classes.add(ElementNotVisibleException.class);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(250, TimeUnit.MILLISECONDS).ignoreAll(classes);
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(by).isDisplayed()) {
                    return driver.findElement(by);
                }
                return null;
            }
        });
    }

}
