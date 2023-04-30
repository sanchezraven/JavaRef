package qa.sandbox.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteBookTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        JavascriptExecutor js = (JavascriptExecutor) app.getDriver();
        app.goTo().Profile(js);
        if (app.collectionBook().list().size() == 0) {
            app.collectionBook().add(js);
        }
    }

    @Test
    public void deleteBookTest() {
        List<WebElement> before = app.collectionBook().list();
        int index = before.size() - 1;
        app.collectionBook().delete(0);
        List<WebElement> after = app.collectionBook().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        for (int i = 0; i < index; i++){
            Assert.assertEquals(before.get(i).getText(), after.get(i).getText());
        }

    }


}
