package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Jackets {
    private WebDriver driver;

    private static final By PROTEUS_FITNESS_JACKSHIRT = By.xpath("//a[contains(text(), 'Proteus Fitness Jackshirt')]");

    public Jackets(WebDriver driver) {
        this.driver = driver;
    }

    public void selectJacket() throws InterruptedException {
        WebElement product = driver.findElement(PROTEUS_FITNESS_JACKSHIRT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
        Thread.sleep(1000);
        product.click();
    }
}
