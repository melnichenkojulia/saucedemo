package org.saucedemo.tests;

import java.util.concurrent.TimeUnit;

import org.saucedemo.LoginPage;
import org.saucedemo.WebDriverFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.InterruptedException;

import java.util.logging.Logger;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class LoginTests extends BaseTest {
    private static final Logger log = Logger.getLogger(LoginTests.class.getName());

    private final String baseUrl = "https://www.saucedemo.com/";

    static class TestData {
        String id, username, password, expected, browser;

        TestData(String id, String username, String password, String expected, String browser) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.expected = expected;
            this.browser = browser;
        }
    }

    static Stream<TestData> testDataProvider() {
        return Stream.of(
                new TestData("uc1", "anyUser", "anyPassword", "Username is required", "firefox"),
                new TestData("uc2", "standard_user", "anyPassword", "Password is required", "firefox"),
                new TestData("uc3", "standard_user", "secret_sauce", "Swag Labs", "firefox"),
                new TestData("uc1", "anyUser", "anyPassword", "Username is required", "edge"),
                new TestData("uc2", "standard_user", "anyPassword", "Password is required", "edge"),
                new TestData("uc3", "standard_user", "secret_sauce", "Swag Labs", "edge")
        );
    }


    @ParameterizedTest(name = "{0} on {4}")
    @MethodSource("testDataProvider")
    @DisplayName("Saucedemo Login Test Scenarios")
    public void runUC(TestData data) throws InterruptedException {
        log.info("Running UC: " + data.id);
        try {
            driver = WebDriverFactory.createDriver(data.browser);

            LoginPage page = new LoginPage(driver);
            page.open(baseUrl);

            switch (data.id) {
                case "uc1":
                    page.setUsername(data.username);
                    page.setPassword(data.password);
                    page.clearUsername();
                    page.clearPassword();
                    page.clickLogin();
                    assertTrue(page.getErrorText().contains(data.expected), "Expected error " + data.expected + ", but got " + page.getErrorText());
                    break;

                case "uc2":
                    page.setUsername(data.username);
                    page.setPassword(data.password);
                    page.clearPassword();
                    page.clickLogin();
                    assertTrue(page.getErrorText().contains(data.expected), "Expected error " + data.expected + ", but got " + page.getErrorText());
                    break;

                case "uc3":
                    page.setUsername(data.username);
                    page.setPassword(data.password);
                    page.clickLogin();
                    assertEquals(data.expected, driver.getTitle());
                    break;
            }
        } finally {

            driver.quit();
        }

    }

}
