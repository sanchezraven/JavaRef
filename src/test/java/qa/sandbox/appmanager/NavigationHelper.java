package qa.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver driver) {
        super (driver);
    }

    public void Profile(JavascriptExecutor js) {
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Profile']")));
    }

    public void goToRegForm() {
        click(By.xpath("//div[text()='Forms']"));
        click(By.xpath("//span[text()='Practice Form']"));
    }

}
