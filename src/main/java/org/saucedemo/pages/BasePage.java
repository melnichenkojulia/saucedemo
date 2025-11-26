package org.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void type(By locator, String text) {
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    void clear(By locator) {
        WebElement input = find(locator);
        input.click();
        int length = input.getAttribute("value").length();
        for (int i = 0; i < length; i++) {
            input.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void open(String url) {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

}