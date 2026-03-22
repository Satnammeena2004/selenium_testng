import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000");
        System.out.println("---------------");
        System.out.println(driver.getTitle());
        WebElement elem   = driver.findElement(By.xpath("//input[contains(@id,'user')]"));
        System.out.println();
        System.out.println("---------------");
        driver.close();
        driver.quit();
    }
}
