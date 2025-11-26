package org.saucedemo.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowserDriver implements BaseBrowserDriver {
    public WebDriver createDriver() {
        return new EdgeDriver();
    }
}