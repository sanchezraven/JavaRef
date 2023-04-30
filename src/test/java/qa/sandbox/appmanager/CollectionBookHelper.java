package qa.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CollectionBookHelper extends HelperBase{

    public CollectionBookHelper(WebDriver driver) {
        super(driver);
    }

    public void addBookToCollection(JavascriptExecutor js) {
        jsClick(js, By.xpath("//div[@class='text-right fullButton']/button"));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void goToBookStore(JavascriptExecutor js) {
        jsClick(js, By.xpath("//li[span[text()='Book Store']]"));
    }

    public void deleteBook(int index) {
        driver.findElements(By.id("delete-record-undefined")).get(index).click();
        click(By.id("closeSmallModal-ok"));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until((ExpectedConditions.alertIsPresent()));
        driver.switchTo().alert().accept();
    }

    public void goToBookProfile(int index) {
        driver.findElements(By.xpath("//span[@class='mr-2']/a")).get(index).click();
    }

    public void goToProfile(JavascriptExecutor js) {
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Profile']")));
    }

    public void addBook(JavascriptExecutor js) {
        goToBookStore(js);
        goToBookProfile(0);
        addBookToCollection(js);
        goToProfile(js);
    }

    public boolean isThereABook() {
        return isElementPresent(By.xpath("//div[@class='rt-td']/img"));
    }

    public int getBookCount() {
        return driver.findElements(By.xpath("//div[@role='rowgroup']//img")).size();
    }

    public List<WebElement> getBookList() {
        List<WebElement> books = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='mr-2']/a"));
        books.addAll(elements);
        return books;
    }
}
