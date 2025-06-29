package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private Actions actions;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    private static final By WHATS_NEW_LINK = By.linkText("What's New");
    private static final By FIRST_PRODUCT = By.cssSelector(".product-item-info");
    private static final By MEN_MENU = By.id("ui-id-5");
    private static final By MEN_TOPS = By.id("ui-id-17");
    private static final By MEN_JACKETS = By.id("ui-id-19");
    private static final By CONSENT = By.xpath("//*[contains(@class, 'fc-button-label') and contains(text(), 'Consent')]");

    public void goToWhatsNew() {
        driver.findElement(WHATS_NEW_LINK).click();
    }

    public void selectFirstProduct() {
        driver.findElement(FIRST_PRODUCT).click();
    }

    public void acceptConsent() {
        driver.findElement(CONSENT).click();
    }

    public void navigateToMensJackets() {
        WebElement menMenu = driver.findElement(MEN_MENU);
        WebElement topsMenu = driver.findElement(MEN_TOPS);
        WebElement jacketsLink = driver.findElement(MEN_JACKETS);

        actions.moveToElement(menMenu)
                .moveToElement(topsMenu)
                .moveToElement(jacketsLink)
                .click()
                .build()
                .perform();
    }
}
