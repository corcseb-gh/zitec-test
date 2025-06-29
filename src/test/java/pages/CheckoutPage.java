package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Selectors
    private static final By EMAIL = By.id("customer-email");
    private static final By FIRST_NAME = By.name("firstname");
    private static final By LAST_NAME = By.name("lastname");
    private static final By STREET = By.name("street[0]");
    private static final By CITY = By.name("city");
    private static final By STATE = By.id("FO6CO1D");
    private static final By REGION = By.name("region_id");
    private static final By POSTCODE = By.name("postcode");
    private static final By COUNTRY = By.name("country_id");
    private static final By TELEPHONE = By.name("telephone");
    private static final By SHIPPING_METHOD = By.cssSelector("input[type='radio'][name*='ko_unique']");
    private static final By NEXT_BUTTON = By.cssSelector(".button.action.continue.primary");

    private static final By PLACE_ORDER_BUTTON = By.cssSelector(".action.primary.checkout");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillShippingInfo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME)).sendKeys("Seb");
        driver.findElement(LAST_NAME).sendKeys("Corc");
        driver.findElement(EMAIL).sendKeys("test@yahoo.com");
        driver.findElement(STREET).sendKeys("Testing Street");
        driver.findElement(CITY).sendKeys("Bucharest");
        driver.findElement(POSTCODE).sendKeys("333333");
        driver.findElement(COUNTRY).sendKeys("Romania");
        driver.findElement(REGION).sendKeys("Prahova");
        driver.findElement(TELEPHONE).sendKeys("1234567890");
    }

    public void selectShippingMethodAndContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(SHIPPING_METHOD)).click();
        driver.findElement(NEXT_BUTTON).click();
    }

    public void placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(PLACE_ORDER_BUTTON)).click();
    }
}
