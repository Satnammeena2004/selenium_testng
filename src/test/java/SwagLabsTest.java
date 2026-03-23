import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLabsTest {
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    // WebDriver d;

    @BeforeMethod
    void setup() {
        WebDriver d = new ChromeDriver();
        d.get("https://www.saucedemo.com/");
        driver.set(d);
    }

    @Test
    void wrongLogin() {
        WebElement username = driver.get().findElement(By.id("user-name"));
        WebElement password = driver.get().findElement(By.id("password"));
        WebElement loginButton = driver.get().findElement(By.id("login-button"));
        username.sendKeys("standard_useeer");
        password.sendKeys("secret_sauce");
        loginButton.click();
        WebElement errorH3 = driver.get().findElement(By.cssSelector(".error-message-container > h3"));
        Assert.assertTrue(errorH3.isDisplayed());

    }

    @Test
    void Login() {
        WebElement username = driver.get().findElement(By.id("user-name"));
        WebElement password = driver.get().findElement(By.id("password"));
        WebElement loginButton = driver.get().findElement(By.id("login-button"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
        WebElement appLogo = driver.get().findElement(By.xpath("//div[@class='app_logo']"));

        Assert.assertTrue(appLogo.isDisplayed());

    }

    @Test
    void addToCart() {
        WebElement username = driver.get().findElement(By.id("user-name"));
        WebElement password = driver.get().findElement(By.id("password"));
        WebElement loginButton = driver.get().findElement(By.id("login-button"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
        WebElement addToCart = driver.get().findElement(By.id("add-to-cart-sauce-labs-backpack"));

        if (!addToCart.isDisplayed()) {
            Assert.assertTrue(false);
        }

        addToCart.click();
        WebElement badge = driver.get().findElement(By.className("shopping_cart_badge"));
        Assert.assertTrue(badge.isDisplayed());

    }

    @AfterMethod
    void cleanup() {
        driver.get().quit();
        driver.remove();
    }

}
