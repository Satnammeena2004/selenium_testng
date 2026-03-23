package tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowTests {

    private WebDriver driver;
    private String windowHandle;

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/iframes.html");
        windowHandle = driver.getWindowHandle();
    }

    @Test
    void openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    void openNewWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://youtube.com");
        Assert.assertEquals(driver.getTitle(), "YouTube");
    }

    @Test

    void swithBackToTheMain() {
        Set<String> windows = driver.getWindowHandles();

        for (String wins : windows) {
            if (!wins.equals(windowHandle)) {
                driver.switchTo().window(wins);
                break;
            }
        }
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

}
