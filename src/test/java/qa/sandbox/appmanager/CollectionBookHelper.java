package qa.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public void deleteBook() {
        click(By.id("delete-record-undefined"));
        click(By.id("closeSmallModal-ok"));
    }

    public void goToBookProfile() {
        click(By.xpath("//span[@id='see-book-Git Pocket Guide']/a"));
    }

    public void goToProfile(JavascriptExecutor js) {
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Profile']")));
    }

    public void addBook(JavascriptExecutor js) {
        goToBookStore(js);
        goToBookProfile();
        addBookToCollection(js);
        goToProfile(js);

    }

    public boolean isThereABook() {
        return isElementPresent(By.xpath("//div[@class='rt-td']/img"));
    }
}
