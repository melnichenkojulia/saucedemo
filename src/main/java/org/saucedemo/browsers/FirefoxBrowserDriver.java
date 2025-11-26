package org.saucedemo.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowserDriver implements BaseBrowserDriver {
    public WebDriver createDriver() {
        return new FirefoxDriver();
    }
}