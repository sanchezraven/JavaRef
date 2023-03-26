package qa.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver driver) {
        super (driver);
    }

    public void goToRegForm() {
        click(By.xpath("//div[text()='Forms']"));
        click(By.xpath("//span[text()='Practice Form']"));
    }

}
