package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTests {

    // (driver instance) IT SHOULD BE COME FROM BASE TEST !!!!

    WebDriver d;

    @BeforeMethod
    @Parameters({ "browser" })
    void setup(@Optional("chrome") String browser) {
        switch (browser) {
            case "chrome" -> d = new ChromeDriver();
            case "firefox" -> d = new FirefoxDriver();
            default -> d = new ChromeDriver();

        }
        d.get("https://www.saucedemo.com/");
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    void tearDown() {
        d.quit();
    }

    @Test
    public void validLoginShouldGoInventory() {
        LoginPage loginPage = new LoginPage(d);
        Assert.assertTrue(loginPage.loginAs("standard_user", "secret_sauce"));
    }

}
