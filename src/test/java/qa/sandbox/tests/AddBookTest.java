package qa.sandbox.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class AddBookTest extends TestBase {

    @Test
    public void addBookTest() {
        JavascriptExecutor js = (JavascriptExecutor) app.getDriver();
        app.getCollectionBookHelper().goToBookStore(js);
        app.getNavigationHelper().goToBookProfile();
        app.getCollectionBookHelper().addBookToCollection(js);
        app.getNavigationHelper().goToProfile(js);
    }

}
