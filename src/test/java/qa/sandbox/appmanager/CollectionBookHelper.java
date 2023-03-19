package qa.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CollectionBookHelper {

    private WebDriver driver;

    public CollectionBookHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void addBookToCollection(JavascriptExecutor js) {
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@class='text-right fullButton']")));
    }

    public void goToBookStore(JavascriptExecutor js) {
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//li[span[text()='Book Store']]")));
    }
}
