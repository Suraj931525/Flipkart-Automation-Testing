package com.flipkart.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cartLink = By.xpath(
        "//a[contains(@href,'viewcart') or contains(translate(.,'CART','cart'),'cart')]");
    private final By placeOrder = By.xpath(
        "//button[contains(translate(.,'PLACE ORDER','place order'),'place order')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    public void openCart() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
        } catch (Exception e) {
            driver.get("https://www.flipkart.com/viewcart");
        }
    }

    public boolean cartPageLoaded() {
        try {
            wait.until(d -> d.getCurrentUrl().toLowerCase().contains("cart")
                    || d.getPageSource().toLowerCase().contains("place order"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void openCheckoutIfAvailable() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}