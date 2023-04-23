package qa.sandbox.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBookTest extends TestBase{

    @Test
    public void deleteBookTest() {
        JavascriptExecutor js = (JavascriptExecutor) app.getDriver();
        app.getCollectionBookHelper().goToProfile(js);
        if (! app.getCollectionBookHelper().isThereABook()) {
            app.getCollectionBookHelper().addBook(js);
        }
        int before = app.getCollectionBookHelper().getBookCount();
        app.getCollectionBookHelper().deleteBook();
        int after = app.getCollectionBookHelper().getBookCount();
        Assert.assertEquals(after, before - 1);
    }


}
