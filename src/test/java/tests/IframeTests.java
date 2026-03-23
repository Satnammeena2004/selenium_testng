package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.IframePage;

public class IframeTests {

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
        d.get("https://www.selenium.dev/selenium/web/iframes.html");
    }

    @Test
    public void firstTest() {
        IframePage frame = new IframePage(d);
        frame.fillTheValueOfEmailAndAgeAndClick("stnam@gmail.com", 12);
        Assert.assertTrue(frame.isGreetingDisabled());
    }

    @AfterMethod
    void tearDown() {
        d.quit();
    }
}
