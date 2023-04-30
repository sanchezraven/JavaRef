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
        app.getCollectionBookHelper().goToProfile(js);
        if (! app.getCollectionBookHelper().isThereABook()) {
            app.getCollectionBookHelper().addBook(js);
        }
    }

    @Test
    public void deleteBookTest() {
        List<WebElement> before = app.getCollectionBookHelper().getBookList();
        int index = before.size() - 1;
        app.getCollectionBookHelper().deleteBook(0);
        List<WebElement> after = app.getCollectionBookHelper().getBookList();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        for (int i = 0; i < index; i++){
            Assert.assertEquals(before.get(i).getText(), after.get(i).getText());
        }

    }


}
