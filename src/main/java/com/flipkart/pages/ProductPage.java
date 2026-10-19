package com.flipkart.pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By productLinks = By.xpath("//a[contains(@href,'/p/')]");
    private final By addToCartButton = By.xpath(
        "//button[normalize-space()='Add to cart' or normalize-space()='ADD TO CART' or normalize-space()='Add To Cart']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void selectFirstProductResult() {
        List<WebElement> links = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productLinks));
        for (WebElement link : links) {
            try {
                if (link.isDisplayed() && link.getText().trim().length() > 2) {
                    String original = driver.getWindowHandle();
                    link.click();
                    wait.until(d -> d.getWindowHandles().size() > 1);
                    Set<String> handles = driver.getWindowHandles();
                    for (String handle : handles) {
                        if (!handle.equals(original)) {
                            driver.switchTo().window(handle);
                            break;
                        }
                    }
                    return;
                }
            } catch (Exception ignored) {
                // Try next result link
            }
        }
        throw new IllegalStateException("Could not identify a visible product result.");
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void addToWishlist() {
        By wishlistButton = By.xpath(
            "//*[name()='svg' and (@width='24' or @width='20') and (@height='24' or @height='20')]" +
            "/ancestor::div[1]"
        );
        wait.until(ExpectedConditions.elementToBeClickable(wishlistButton)).click();
        System.out.println("Wishlist icon clicked.");
    }

    public void clickBuyNow() {
        By buyNowButton = By.xpath(
            "//button[normalize-space()='Buy Now' or normalize-space()='BUY NOW']"
        );
        wait.until(ExpectedConditions.elementToBeClickable(buyNowButton)).click();
        System.out.println("Buy Now clicked.");
    }

    public void clickContinueIfAvailable() {
        By continueButton = By.xpath(
            "//button[normalize-space()='Continue' or normalize-space()='CONTINUE']"
        );
        try {
            wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
            System.out.println("Continue clicked.");
        } catch (Exception e) {
            System.out.println("Continue button not found. Proceeding.");
        }
    }

    public void goBack() {
        driver.navigate().back();
        System.out.println("Navigated back.");
    }
}