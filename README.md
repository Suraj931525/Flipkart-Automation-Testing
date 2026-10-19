# Flipkart Automation (Selenium + Java + TestNG)

A starter Page Object Model (POM) project demonstrating a Flipkart shopping flow:
open site → optional manual login → search mobile → select result → add to cart → verify cart → open checkout.

## Requirements
- JDK 17 or newer
- Maven
- Chrome browser
- Internet access

Selenium Manager normally resolves the matching ChromeDriver automatically.

## Run
1. Extract the ZIP.
2. Open the folder as a Maven project in Eclipse/IntelliJ.
3. Edit `src/test/resources/config.properties`.
4. Run `src/test/resources/testng.xml` as a TestNG suite, or run `mvn test`.

## Login note
Flipkart may require OTP/CAPTCHA. This starter deliberately does not automate or bypass OTP/CAPTCHA. Run `LoginTest` and complete verification manually if prompted. For an authorized test account, you can enter credentials manually in the browser. Avoid storing passwords in source control.

## Important
Retail websites change frequently and may show different locators, login dialogs, regional content, or bot checks. Locators are examples and may need updating after inspecting the current DOM. Checkout test only opens/verifies the checkout flow; it does not submit an order, payment, or purchase.

The end-to-end test uses one browser session for the flow. If Flipkart blocks automation or requires additional verification, stop and complete any permitted checks manually.
