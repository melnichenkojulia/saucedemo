package org.saucedemo.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.saucedemo.enums.Browser;
import org.saucedemo.enums.LoginMode;
import org.saucedemo.factory.UserFactory;
import org.saucedemo.pages.LoginPage;
import org.saucedemo.factory.WebDriverFactory;
import org.saucedemo.tests.dto.TestData;

import java.util.logging.Logger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTests extends BaseTest {
    private static final Logger log = Logger.getLogger(LoginTests.class.getName());;

    static Stream<TestData> testDataProvider() {
        return Stream.of(
                new TestData("UC-1", UserFactory.invalidUser(), LoginMode.CLEAR_ALL, "Username is required", "Swag Labs"),
                new TestData("UC-2", UserFactory.userWithInvalidPassword(), LoginMode.CLEAR_PASSWORD, "Password is required", "Swag Labs"),
                new TestData("UC-3", UserFactory.validUser(), LoginMode.DEFAULT, null, "Swag Labs")
        );
    }

    @ParameterizedTest(name = "{0} on {3}")
    @MethodSource("testDataProvider")
    @DisplayName("Saucedemo Login Test Scenarios")
    public void runUC(TestData data) {
        log.info("Running UC: " + data.id());
        LoginPage page = new LoginPage(this.driver);
        page.open(baseUrl);
        page.login(data.user(), data.loginMode());

        if (data.error() != null) {
            assertTrue(page.getErrorMessage().contains(data.error()));
        }

        assertEquals(data.title(), page.getTitle());
    }

}
