package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    private WebDriver driver;

    private static final By SUCCESS_TEXT = By.cssSelector(".checkout-success");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isThankYouDisplayed() {
        return driver.findElement(SUCCESS_TEXT).isDisplayed();
    }
}
