package org.saucedemo.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserDriver implements BaseBrowserDriver {
    public WebDriver createDriver() {
        return new ChromeDriver();
    }
}