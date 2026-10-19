package com.flipkart.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By searchBox = By.name("q");
    private final By closeLoginPopup = By.xpath("//button[contains(text(),'✕') or @aria-label='Close']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    public void closeLoginPopupIfPresent() {
        try {
            WebElement close = new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.elementToBeClickable(closeLoginPopup));
            close.click();
        } catch (Exception ignored) {
            // Popup is optional; continue if not displayed.
        }
    }

    public void searchFor(String product) {
        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        box.clear();
        box.sendKeys(product, Keys.ENTER);
    }
}