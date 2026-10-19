package com.flipkart.pages;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By loginButton = By.xpath(
        "//*[normalize-space()='Login' or normalize-space()='Log In']"
    );

    private final By phoneInput = By.xpath(
        "//input[@type='text' or @type='tel']"
    );

    private final By continueButton = By.xpath(
        "//button[normalize-space()='Continue' or normalize-space()='CONTINUE']"
    );

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void loginWithMobileNumber(String mobileNumber) {
        boolean phoneVisible = false;

        for (WebElement element : driver.findElements(phoneInput)) {
            if (element.isDisplayed() && element.isEnabled()) {
                phoneVisible = true;
                break;
            }
        }

        if (!phoneVisible) {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        }

        WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        phone.clear();
        phone.sendKeys(mobileNumber);

        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();

        System.out.println("Complete OTP verification manually in the browser.");
        System.out.println("After login, press Enter in the Eclipse Console.");

        try (Scanner scanner = new Scanner(System.in)) {
            scanner.nextLine();
        }
    }
}