package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectPage {
    WebDriver driver;
    WebDriverWait wait;
    private By dropdown = By.cssSelector(".select_container select.product_sort_container");

    public SelectPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectValueLowToHigh() {
        new Select(driver.findElement(dropdown)).selectByValue("lohi");
    }

    public void selectValueAZ() {
        new Select(driver.findElement(dropdown)).selectByValue("az");
    }
    public void selectValueZA() {
        new Select(driver.findElement(dropdown)).selectByValue("za");
    }

    public String getSelectedSort() {
        return new Select(driver.findElement(dropdown)).getFirstSelectedOption().getText();
    }
}
