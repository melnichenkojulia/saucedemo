package org.saucedemo;

import org.openqa.selenium.WebDriver;
import org.saucedemo.enums.Browser;
import org.saucedemo.factory.WebDriverFactory;

public class DriverManager {

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver(Browser browser) {
        if (threadDriver.get() == null) {
            threadDriver.set(WebDriverFactory.createDriver(browser));
        }
        return threadDriver.get();
    }

    public static void quitDriver() {
        WebDriver driver = threadDriver.get();
        if (driver != null) {
            driver.quit();
            threadDriver.remove();
        }
    }
}
