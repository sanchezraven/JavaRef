package qa.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CollectionBookHelper extends HelperBase{

    public CollectionBookHelper(WebDriver driver) {
        super(driver);
    }

    public void addBookToCollection(JavascriptExecutor js) {
        jsClick(js, By.xpath("//div[@class='text-right fullButton']"));
    }

    public void goToBookStore(JavascriptExecutor js) {
        jsClick(js, By.xpath("//li[span[text()='Book Store']]"));
    }
}
