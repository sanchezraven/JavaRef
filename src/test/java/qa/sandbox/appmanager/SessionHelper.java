package qa.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        driver.get("https://demoqa.com/login");
        type(By.id("userName"), username);
        type(By.id("password"), password);
        click(By.id("login"));
        new WebDriverWait(driver,
                Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Log out']"))));
    }
}
