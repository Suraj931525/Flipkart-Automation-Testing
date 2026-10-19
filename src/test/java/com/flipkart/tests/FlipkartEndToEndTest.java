package com.flipkart.tests;

import org.testng.annotations.Test;

import com.flipkart.base.BaseClass;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.ProductPage;

public class FlipkartEndToEndTest extends BaseClass {

    @Test
    public void loginSearchWishlistBuyNowContinueAndBack() {
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver); // Corrected from 'deriver -> driver'

        // 1. Open Flipkart (Handled automatically in BaseClass @BeforeMethod via config.properties)
        
        // 2. Login with mobile number
        login.loginWithMobileNumber("9119434004");

        // 3. Close optional login popup if it appears post-login
        home.closeLoginPopupIfPresent();

        // 4. Search mobile
        home.searchFor("BOLTT EVO mobile");

        // 5. Open product
        product.selectFirstProductResult();

        // 6. Add to Wishlist
        product.addToWishlist();

        // 7. Click Buy Now
        product.clickBuyNow();

        // 8. Click Continue if available
        product.clickContinueIfAvailable();

        // 9. Go back
        product.goBack();

        System.out.println("Test flow completed successfully.");
    }
}