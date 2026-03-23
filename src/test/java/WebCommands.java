import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebCommands {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        try {

            driver = new ChromeDriver();
            driver.get("https://google.com");

            // Page info
            String title = driver.getTitle();

            String url = driver.getCurrentUrl();
            String source = driver.getPageSource();

            System.out.println(title);
            System.out.println(url);

            Thread.sleep(1000);
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.manage().window().minimize();
            Thread.sleep(2000);
            driver.manage().window().fullscreen();
            Thread.sleep(2000);

            driver.quit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
