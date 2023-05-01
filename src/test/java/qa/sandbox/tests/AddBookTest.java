package qa.sandbox.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddBookTest extends TestBase {

    @Test
    public void addBookTest() {

        List<WebElement> before = app.collectionBook().list();
        JavascriptExecutor js = (JavascriptExecutor) app.getDriver();
        app.collectionBook().add(js);
        app.goTo().Profile(js);
        assertThat(app.collectionBook().count(), equalTo(before.size() + 1));
        List<WebElement> after = app.collectionBook().list();
        Assert.assertEquals(after.size(), before.size() + 1);
        Assert.assertTrue(app.getRegHelper().isElementPresent(By.xpath("//div[@class='rt-td']/img")));
    }

}
