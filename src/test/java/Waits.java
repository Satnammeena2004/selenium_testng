import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Waits {

    WebDriver driver;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    void waitTillVisible() {
        WebElement elem = driver.findElement(By.name("search"));
        boolean isDisplayed = elem.isDisplayed();

        Assert.assertTrue(isDisplayed);
    }

    @AfterClass
    void cleanup() {
        driver.close();
        driver.quit();
    }

}
