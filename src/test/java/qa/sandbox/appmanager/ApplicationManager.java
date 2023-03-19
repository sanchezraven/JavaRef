package qa.sandbox.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private CollectionBookHelper collectionBookHelper;

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        setDriver(WebDriverManager.chromedriver().capabilities(options).create());
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(getDriver());
        collectionBookHelper = new CollectionBookHelper(getDriver());
        navigationHelper = new NavigationHelper(getDriver());
        sessionHelper.login("johny", "Qwerty1!");
    }

    public void stop() {
        getDriver().quit();
    }

    public CollectionBookHelper getCollectionBookHelper() {
        return collectionBookHelper;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }


}
