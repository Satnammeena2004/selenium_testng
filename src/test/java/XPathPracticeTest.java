import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class XPathPracticeTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://localhost:3000");
        // driver.manage().window().maximize();
    }

    @Test(enabled = false)
    public void testContainsXpath() {
        WebElement elem = driver.findElement(By.xpath("//input[contains(@id,'user')]"));
        elem.sendKeys("satnam");
        String value = driver.findElement(By.xpath("//input[contains(@id,'user')]")).getAttribute("value");

        Assert.assertEquals(value, "satnam");
    }

    @Test(enabled = false)
    public void testStartWithXpath() {
        WebElement elem = driver.findElement(By.id("emailInput"));
        elem.sendKeys("test@gmail.com");
        String value = driver.findElement(By.id("emailInput")).getAttribute("value");
        Assert.assertEquals("test@gmail.com", value);
    }

    @Test(enabled = false)
    public void clickButton() {
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        String str = driver.findElement(By.xpath("//button[text()='Login']")).getText();
        Assert.assertEquals(str, "Login");

    }

    @Test(enabled = false)
    public void parentExists() {
        WebElement elem = driver.findElement(By.xpath("//input[@id='usernameInput']/.."));
        System.out.println(elem.getTagName());
        Assert.assertEquals(elem.getTagName(), "div");
    }


    @Test
    public void cssSelectors(){
        WebElement elem = driver.findElement(By.cssSelector(""));
    }
    
    @AfterClass
    void tearDown() {
        driver.quit();
    }

}
