package qa.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver driver;

    public NavigationHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void goToProfile(JavascriptExecutor js) {
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Profile']")));
    }

    public void goToBookProfile() {
        driver.findElement(By.xpath("//span[@id='see-book-Git Pocket Guide']/a")).click();
    }

    public void goToRegForm() {
        driver.findElement(By.xpath("//div[text()='Forms']")).click();
        driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
    }
}
