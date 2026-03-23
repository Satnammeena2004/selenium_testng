package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SelectPage;

public class SelectTest {

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
    public void sortByAtoZ() {
        LoginPage lp = new LoginPage(d);
        SelectPage sp = new SelectPage(d);
        boolean isLoggedIn = lp.loginAs("standard_user", "secret_sauce");
        if (!isLoggedIn) {
            Assert.assertTrue(isLoggedIn);
        }
        sp.selectValueAZ();
        Assert.assertEquals(sp.getSelectedSort(), "Name (A to Z)");

    }

    @Test
    public void sortByZtoA() {
        // LoginPage lp = new LoginPage(d);
        SelectPage sp = new SelectPage(d);
        // boolean isLoggedIn = lp.loginAs("standard_user", "secret_sauce");
        // if (!isLoggedIn) {
        // Assert.assertTrue(isLoggedIn);
        // }
        sp.selectValueZA();
        Assert.assertEquals(sp.getSelectedSort(), "Name (Z to A)");

    }
    @Test
    public void sortByLowtoHigh() {
        // LoginPage lp = new LoginPage(d);
        SelectPage sp = new SelectPage(d);
        // boolean isLoggedIn = lp.loginAs("standard_user", "secret_sauce");
        // if (!isLoggedIn) {
        // Assert.assertTrue(isLoggedIn);
        // }
        sp.selectValueLowToHigh();
        Assert.assertEquals(sp.getSelectedSort(), "Price (low to high)");

    }

    @AfterMethod
    void tearDown() {
        d.quit();
    }
}
