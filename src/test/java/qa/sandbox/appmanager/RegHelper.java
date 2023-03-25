package qa.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import qa.sandbox.model.RegData;

public class RegHelper extends HelperBase{

    public RegHelper(WebDriver driver) {
        super(driver);
    }

    public void fillForm(RegData regData) {
        type(By.id("firstName"), regData.firstName());
        type(By.id("lastName"), regData.lastName());
        type(By.id("userNumber"), regData.phone());
    }

    public void checkGender(JavascriptExecutor js) {
        jsClick(js, By.id("gender-radio-1"));
    }

    public void submitRegistration(JavascriptExecutor js) {
        jsClick(js, By.id("submit"));
    }

}
