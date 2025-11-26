package org.saucedemo.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.saucedemo.ConfigReader;
import org.saucedemo.DriverManager;
import org.saucedemo.enums.Browser;

public abstract class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;

    @BeforeEach
    void setUp() {
        driver = DriverManager.getDriver(Browser.valueOf(ConfigReader.get("browser")));
        baseUrl = ConfigReader.get("baseUrl");
    }

    @AfterEach
    void tearDown() {
        DriverManager.quitDriver();
    }
}
