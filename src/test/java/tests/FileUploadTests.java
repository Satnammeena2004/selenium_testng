package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadTests {
    private WebDriver driver;
    private WebDriverWait wait;
    By fileUpload = By.id("file-upload");
    By fileSubmit = By.id("file-submit");

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    @Test
    void uploadFile() {
        WebElement input = driver.findElement(fileUpload);
        String filePath = System.getProperty("user.dir")
                + "/src/main/resources/pdf.pdf";
        input.sendKeys(filePath);
        Assert.assertTrue(true);
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
