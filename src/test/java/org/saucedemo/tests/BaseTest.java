package org.saucedemo.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.saucedemo.ConfigReader;
import org.saucedemo.enums.Browser;
import org.saucedemo.factory.WebDriverFactory;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        Browser browser = Browser.valueOf(ConfigReader.get("browser"));
        driver = WebDriverFactory.createDriver(browser);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
