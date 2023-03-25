package qa.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegHelper {

    private WebDriver driver;

    public RegHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(RegData regData) {
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(regData.firstName());
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(regData.lastName());
        driver.findElement(By.id("userNumber")).click();
        driver.findElement(By.id("userNumber")).clear();
        driver.findElement(By.id("userNumber")).sendKeys(regData.phone());
    }

    public void checkGender(JavascriptExecutor js) {
        js.executeScript("arguments[0].click();", driver.findElement(By.id("gender-radio-1")));
    }

    public void submitRegistration(JavascriptExecutor js) {
        js.executeScript("arguments[0].click();", driver.findElement(By.id("submit")));
        //driver.findElement(By.id("submit")).click();
    }
}
