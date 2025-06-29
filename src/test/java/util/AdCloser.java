package util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdCloser {
    WebDriver driver;

    public AdCloser(WebDriver driver) {
        this.driver = driver;
    }

    private static final String[] CLOSE_BUTTON_XPATHS = {
            "//*[contains(@aria-label, 'Close ad')]",
            "//div[@id='dismiss-button']//span[contains(text(), 'Close')]",
            "//*[contains(@aria-label, 'Close')]",
            "//*[@id='dismiss-button']",
            "//button[contains(text(), 'Close')]"
    };

    public static void closeAds(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        List<WebElement> adIframes;
        try {
            adIframes = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("/html/ins/div/iframe"))
            );
        } catch (TimeoutException e) {
            System.out.println("No ad iframes found.");
            adIframes = List.of();
        }

        for (WebElement iframe : adIframes) {
            try {
                driver.switchTo().frame(iframe);

                boolean adClosed = false;
                for (String xpath : CLOSE_BUTTON_XPATHS) {
                    List<WebElement> closeButtons = driver.findElements(By.xpath(xpath));
                    if (!closeButtons.isEmpty()) {
                        closeButtons.get(0).click();
                        System.out.println("Ad closed using: " + xpath);
                        adClosed = true;
                        break;
                    }
                }

                driver.switchTo().defaultContent();

                if (!adClosed) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", iframe);
                    System.out.println("Ad iframe hidden via JS.");
                }
//
            } catch (Exception e) {
                System.out.println("Error handling ad iframe: " + e.getMessage());
                driver.switchTo().defaultContent();
            }
        }

        try {
            List<WebElement> adHosts = driver.findElements(By.xpath("//*[contains(@id, '_host')]"));
            for (WebElement host : adHosts) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", host);
            }
            System.out.println("Overlay containers hidden.");
        } catch (Exception e) {
            System.out.println("Failed to hide overlay containers: " + e.getMessage());
        }
    }
}