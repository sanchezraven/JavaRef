package qa.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected void jsClick(JavascriptExecutor js, By locator) {
        js.executeScript("arguments[0].click();", driver.findElement(locator));
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }
}
