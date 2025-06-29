package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import util.AdCloser;

public class Order {
    private WebDriver driver;
    private HomePage home;
    private Jackets jackets;
    private ProductPage product;
    private CartPage cart;
    private CheckoutPage checkout;
    private ConfirmationPage confirmation;
    private AdCloser adCloser;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        home = new HomePage(driver);
        home.acceptConsent();
        jackets = new Jackets(driver);
        product = new ProductPage(driver);
        cart = new CartPage(driver);
        checkout = new CheckoutPage(driver);
        confirmation = new ConfirmationPage(driver);
        adCloser = new AdCloser(driver);
    }

    @Test
    void buyMenJacket() throws InterruptedException {
        home.navigateToMensJackets();
        jackets.selectJacket();
//        driver.navigate().refresh();
        adCloser.closeAds(driver);
//        jackets.selectJacket();

        product.selectXsSize();
        Thread.sleep(3000);
        product.selectBlackColor();
        Thread.sleep(3000);
        product.addToCart();
        Thread.sleep(3000);
        cart.openCart();
        cart.proceedToCheckout();
        checkout.fillShippingInfo();
        Thread.sleep(3000);
        checkout.selectShippingMethodAndContinue();
        Thread.sleep(3000);
        checkout.placeOrder();
        Thread.sleep(3000);
        Assertions.assertTrue(confirmation.isThankYouDisplayed());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
