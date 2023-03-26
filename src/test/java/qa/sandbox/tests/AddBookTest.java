package qa.sandbox.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddBookTest extends TestBase {

    @Test
    public void addBookTest() {
        JavascriptExecutor js = (JavascriptExecutor) app.getDriver();
        app.getCollectionBookHelper().addBook(js);
        Assert.assertTrue(app.getRegHelper().isElementPresent(By.xpath("//div[@class='rt-td']/img")));
    }

}
