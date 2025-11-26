package org.saucedemo.factory;

import org.saucedemo.drivers.*;
import org.saucedemo.enums.Browser;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public static WebDriver createDriver(Browser browser) {
        BaseBrowserDriver browserDriver;
        switch (browser) {
            case FIREFOX -> browserDriver = new FirefoxBrowserDriver();
            case EDGE -> browserDriver = new EdgeBrowserDriver();
            case CHROME -> browserDriver = new ChromeBrowserDriver();
            default -> throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        WebDriver driver = browserDriver.createDriver();
        driver.manage().window().maximize();
        return driver;
    }
}