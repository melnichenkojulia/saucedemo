package org.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.saucedemo.enums.LoginMode;
import org.saucedemo.dto.UserDTO;

public class LoginPage extends BasePage {

    private final By usernameInput = By.xpath("//input[@id='user-name']");
    private final By passwordInput = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@id='login-button']");
    private final By errorMsg = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(UserDTO user, LoginMode loginMode) {
        type(usernameInput, user.username());
        type(passwordInput, user.password());
        if (loginMode == LoginMode.CLEAR_PASSWORD) {
            clear(passwordInput);
        } else if (loginMode == LoginMode.CLEAR_ALL) {
            clear(usernameInput);
            clear(passwordInput);
        }
        click(loginButton);
    }

    public String getErrorMessage() {
        return find(errorMsg).getText();
    }
}
