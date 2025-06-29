package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {
        driver.findElement(By.linkText("Sign In")).click();
    }

    public void login(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(password);
        WebElement signIn = driver.findElement(By.id("send2"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signIn);
        signIn.click();
    }
}
