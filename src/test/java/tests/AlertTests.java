package tests;

import static base.BaseTest.getDriver;

import java.security.AllPermission;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AlertPage;

public class AlertTests {

    WebDriverWait wait;
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

    @Test
    public void handleSimpleAlert() {
        ((JavascriptExecutor) d).executeScript("alert('Hello world')");
        AlertPage alertPage = new AlertPage(d);
        Assert.assertEquals(alertPage.getAlertText(), "Hello world");
        alertPage.acceptAlert();
    }

    @Test
    public void handleSimpleConfirm() {
        ((JavascriptExecutor) d).executeScript("confirm('Proceed?')");
        AlertPage alertPage = new AlertPage(d);
        Assert.assertEquals(alertPage.getAlertText(), "Proceed?");
        alertPage.dismisConfirm();
    }

    @Test
    public void handlePromptAlert() {
        ((JavascriptExecutor) d).executeScript("prompt('Enter your name:')");

        AlertPage alertPage = new AlertPage(d);
        alertPage.handlePrompt("STNAM");
        Assert.assertEquals(alertPage.getAlertText(), "STNAM");
        

    }

    @AfterMethod
    void tearDown() {
        d.quit();
    }
}
