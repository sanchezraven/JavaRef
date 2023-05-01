package qa.sandbox.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    WebDriver driver;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private CollectionBookHelper collectionBookHelper;
    private RegHelper regHelper;
    private Browser browser;

    public ApplicationManager(Browser browser){
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

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
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
    }

    public void stop() {
        getDriver().quit();
    }

    public CollectionBookHelper collectionBook() {
        return collectionBookHelper;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public RegHelper getRegHelper() {
        return regHelper;
    }
}
