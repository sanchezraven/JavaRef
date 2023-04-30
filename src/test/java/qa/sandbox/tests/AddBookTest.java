package qa.sandbox.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddBookTest extends TestBase {

    @Test
    public void addBookTest() {

        List<WebElement> before = app.getCollectionBookHelper().getBookList();
        JavascriptExecutor js = (JavascriptExecutor) app.getDriver();
        app.getCollectionBookHelper().addBook(js);
        List<WebElement> after = app.getCollectionBookHelper().getBookList();
        Assert.assertEquals(after.size(), before.size() + 1);
        Assert.assertTrue(app.getRegHelper().isElementPresent(By.xpath("//div[@class='rt-td']/img")));
    }

}
