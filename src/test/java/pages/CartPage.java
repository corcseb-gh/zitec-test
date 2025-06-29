package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    private static final By CART_ICON = By.cssSelector(".showcart");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.id("top-cart-btn-checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(CART_ICON).click();
    }

    public void proceedToCheckout() {
        driver.findElement(PROCEED_TO_CHECKOUT_BUTTON).click();
    }
}
