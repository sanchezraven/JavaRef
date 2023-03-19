package qa.sandbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddBookTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void addBookTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com/login");
        driver.findElement(By.id("userName")).sendKeys("johny");
        driver.findElement(By.id("password")).sendKeys("Qwerty1!");
        driver.findElement(By.id("login")).click();
        new WebDriverWait(driver,
                Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Log out']"))));
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//li[@id=\"item-2\"])[5]")));
        driver.findElement(By.xpath("//span[@id='see-book-Git Pocket Guide']/a")).click();
        js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[@class='text-right fullButton']")));
        js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[text()='Profile']")));
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
