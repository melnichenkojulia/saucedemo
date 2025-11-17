package org.saucedemo.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.saucedemo.WebDriverFactory;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp(TestInfo testInfo) {

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit(); // always quit after each test
        }
    }
}
