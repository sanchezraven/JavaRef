package qa.sandbox.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private CollectionBookHelper collectionBookHelper;
    private RegHelper regHelper;
    private Browser browser;

    public ApplicationManager(Browser browser) {

        this.browser = browser;
    }

    public void init() {
        if (browser.equals(Browser.CHROME)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--incognito");
            setDriver(WebDriverManager.chromedriver().capabilities(options).create());
        } else if (browser.equals(Browser.FIREFOX)) {
            setDriver(WebDriverManager.firefoxdriver().create());
        } else if (browser.equals(Browser.EDGE)) {
            setDriver(WebDriverManager.edgedriver().create());
        }

        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(getDriver());
        regHelper = new RegHelper(getDriver());
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

    public RegHelper getRegHelper() {
        return regHelper;
    }
}
