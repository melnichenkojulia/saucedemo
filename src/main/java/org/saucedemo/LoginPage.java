package org.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    private void clearInput(WebElement input) {
        input.click();
        int length = input.getAttribute("value").length();
        for (int i = 0; i < length; i++) {
            input.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void clearUsername() {
        clearInput(driver.findElement(usernameInput));
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clearPassword() {
        clearInput(driver.findElement(passwordInput));
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorText() {
        return driver.findElement(errorMsg).getText();
    }
}
