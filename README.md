# Flipkart Automation Testing Project

## Project Overview
This project automates selected user interactions on the Flipkart e-commerce website using Selenium WebDriver, Java, and TestNG. It follows the Page Object Model (POM) design pattern to improve code reusability and maintainability.

## Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Chrome Browser
- Eclipse IDE

## Test Scenarios
- Launch the Flipkart website
- Handle the login flow
- Close the login popup when available
- Search for a mobile phone
- Select the first product from the search results
- Add the product to the wishlist
- Click Buy Now
- Handle the Continue action when available
- Navigate back to the previous page

## Project Structure
```text
FlipkartAutomation/
├── pom.xml
├── README.md
├── src/
│   ├── main/java/com/flipkart/
│   │   ├── base/
│   │   │   └── BaseClass.java
│   │   └── pages/
│   │       ├── HomePage.java
│   │       ├── LoginPage.java
│   │       ├── ProductPage.java
│   │       └── CartPage.java
│   └── test/
│       ├── java/com/flipkart/tests/
│       │   └── FlipkartEndToEndTest.java
│       └── resources/
│           ├── config.properties
│           └── testng.xml
└── .gitignore
```

## Prerequisites
- JDK 17 or later
- Maven
- Google Chrome
- Eclipse IDE or IntelliJ IDEA
- Internet connection

## How to Run
1. Clone or download this repository.
2. Import the project as an existing Maven project.
3. Update the configuration in `src/test/resources/config.properties` if required.
4. Allow Maven to download the dependencies.
5. Run `src/test/resources/testng.xml` as a TestNG suite, or execute `mvn test` from the project directory.

## Framework Design
- **BaseClass:** Browser setup and common test configuration.
- **HomePage:** Homepage actions and product search.
- **LoginPage:** Login-related interactions.
- **ProductPage:** Product selection and wishlist/Buy Now actions.
- **CartPage:** Cart-related page interactions.
- **TestNG:** Test execution and test management.
- **Maven:** Dependency management and build automation.

## Important Notes
- Flipkart may require OTP or CAPTCHA verification. Complete permitted verification manually; this project does not bypass security checks.
- Website locators and flows may need updates as the website changes.
- The test attempts selected shopping interactions. It does not intentionally submit an order or make a payment.
- Use only authorized test accounts and never commit personal phone numbers, passwords, OTPs, or other secrets.

## Author
Suraj Patil

## Disclaimer
This project is intended for educational and automation-testing practice. It is not affiliated with or endorsed by Flipkart.
