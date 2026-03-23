
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigatesTest {

    WebDriver driver;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://google.com");

    }

    @Test(priority = 1)
    void checkTitleOfGoogle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");

    }

    @Test(priority = 2)
    void navigateToTheYoutube() {
        driver.navigate().to("https://youtube.com");
        String title = driver.getTitle();
        Assert.assertEquals(title, "YouTube");

    }

    @Test(priority = 3)
    void navigateToTheGithub() {
        driver.navigate().to("https://github.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("GitHub"));

    }

    @Test(priority = 4)
    void goBackToYoutube() {
        driver.navigate().back();
        String title = driver.getTitle();
        Assert.assertEquals(title, "YouTube");

    }

    @Test(priority = 5)
    void goBackToGoogle() {
        driver.navigate().back();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");

    }

    @AfterClass

    void cleanup() {
        driver.close();
        driver.quit();
    }
}
