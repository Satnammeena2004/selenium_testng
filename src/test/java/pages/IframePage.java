package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IframePage {

    private WebDriver driver;
    private WebDriverWait wait;
    By iframe = By.id("iframe1");
    By email = By.id("email");
    By age = By.id("age");
    By submitButton = By.id("submitButton");
    By greeting = By.id("greeting");

    public IframePage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(d, Duration.ofSeconds(10));
    }

    public void switchToIframe() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }

    public void greetingVisibleOrNot() {
        wait.until(ExpectedConditions.presenceOfElementLocated(greeting));
    }

    public boolean isGreetingDisabled() {
        greetingVisibleOrNot();
        return driver.findElement(greeting).isDisplayed();
    }

    public void enterEmail(String str) {
        driver.findElement(email).sendKeys(str);

    }

    public void enterAge(int a) {
        driver.findElement(age).sendKeys(String.valueOf(a));

    }

    public void fillTheValueOfEmailAndAgeAndClick(String filledEmail, int filledAge) {
        switchToIframe();
        enterEmail(filledEmail);
        enterAge(filledAge);
        driver.findElement(submitButton).click();

    }

}
