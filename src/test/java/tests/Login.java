package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import util.ConfigReader;

public class Login {
    private WebDriver driver;
    private HomePage home;
    private LoginPage login;
    String email = ConfigReader.get("user.email");
    String password = ConfigReader.get("user.password");

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        home = new HomePage(driver);
        home.acceptConsent();
        login = new LoginPage(driver);
    }

    @Test
    void logIn() {
        login.goToLoginPage();
        login.login(email, password);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
