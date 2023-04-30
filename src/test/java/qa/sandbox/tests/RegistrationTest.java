package qa.sandbox.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import qa.sandbox.model.RegData;

public class RegistrationTest extends TestBase{

    @Test
    public void fillRegistrationForm() {
        JavascriptExecutor js = (JavascriptExecutor) app.getDriver();
        app.goTo().goToRegForm();
        app.getRegHelper().fillForm(new RegData("Al", "Vor", "1111111111"));
        app.getRegHelper().checkGender(js);
        app.getRegHelper().submitRegistration(js);
    }

}
