package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class AlertPage {

    WebDriverWait wait;
    WebDriver d;

    public AlertPage(WebDriver driver) {
        this.d = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private Alert waitForAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        waitForAlert().accept();
    }

    public void acceptConfirm() {
        waitForAlert().accept();
    }

    public void dismisConfirm() {
        waitForAlert().dismiss();
    }

    public void handlePrompt(String str) {
        Alert alert = waitForAlert();
        alert.sendKeys(str);
        alert.accept();
    }

    public String getAlertText() {
        return waitForAlert().getText();
    }

    @AfterClass
    void tearDown() {
        d.quit();
    }

}
