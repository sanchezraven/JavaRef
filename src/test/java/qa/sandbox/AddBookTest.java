package qa.sandbox;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class AddBookTest extends TestBase {

    @Test
    public void addBookTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        goToBookStore(js);
        goToBookProfile();
        addBookToCollection(js);
        goToProfile(js);
    }

}
