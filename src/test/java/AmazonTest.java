import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {
    public static void main(String[] args) {
        try {
            WebDriver driver = new ChromeDriver();
            driver.get("http://localhost:3000");
            System.out.println("==================");
            Thread.sleep(1000);
            WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
            System.out.println(input.getAttribute("placeholder"));
            input.sendKeys("mobiles");
            WebElement button = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
            button.click();
            Thread.sleep(2000);

            System.out.println("==================");
            driver.close();
            driver.quit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
