package org.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameInput = By.xpath("//input[@id='user-name']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@id='login-button']");
    private By errorMsg = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void clearUsername() {
        driver.findElement(usernameInput).clear();
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clearPassword() {
        driver.findElement(passwordInput).clear();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorText() {
        return driver.findElement(errorMsg).getText();
    }
}
