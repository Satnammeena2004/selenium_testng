package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector(".error-message-container h3");

    public LoginPage(WebDriver driver) {
        
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUserName(String name) {
        driver.findElement(username).sendKeys(name);

    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);

    }

    public void clickButton() {
        driver.findElement(loginButton).click();

    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    public boolean isErrorPageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean loginAs(String uname, String pass) {
        enterUserName(uname);
        enterPassword(pass);
        clickButton();
        return driver.getCurrentUrl().contains("inventory");
    }
}
