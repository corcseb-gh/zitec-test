package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver driver;

    private static final By SIZE_OPTION = By.cssSelector("div.swatch-attribute.size .swatch-option");
    private static final By COLOR_OPTION = By.cssSelector("div.swatch-attribute.color .swatch-option");
    private static final By ADD_TO_CART_BUTTON = By.id("product-addtocart-button");
    private static final By CART_ICON = By.cssSelector(".showcart");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.id("top-cart-btn-checkout");
    private static final By XS_SIZE = By.id("option-label-size-143-item-166");
    private static final By BLACK_COLOR = By.id("option-label-color-93-item-49");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSize() {
        driver.findElement(SIZE_OPTION).click();
    }

    public void selectColor() {
        driver.findElement(COLOR_OPTION).click();
    }

    public void addToCart() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public void openCart() {
        driver.findElement(CART_ICON).click();
    }

    public void selectBlackColor() {
        WebElement color = driver.findElement(BLACK_COLOR);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", color);
        color.click();
    }

    public void selectXsSize() {
        WebElement size = driver.findElement(XS_SIZE);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", size);
        size.click();
    }
}
