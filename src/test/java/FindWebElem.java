import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindWebElem {

    WebDriver driver;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com");

    }

    @Test
    void findWebElements() {
        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("mobiles");
        WebElement nav = driver.findElement(By.id("menu"));
        List<WebElement> lists = nav.findElements(By.tagName("a"));
        for (WebElement elem : lists) {
            System.out.println(elem.getText());

        }
        Assert.assertEquals(8, lists.size());

    }


    @AfterClass
    void cleanup() {
        driver.quit();
    }

}
