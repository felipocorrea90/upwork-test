package utils.driver;

import org.openqa.selenium.WebDriver;
import utils.driver.browser_manager.ChromeDriverManager;
import utils.driver.browser_manager.FirefoxDriverManager;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver setupDriver(String browser) {
        WebDriver wd = null;
        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

        switch (browserType) {
            case CHROME:
                wd = new ChromeDriverManager().createDriver();
                wd.manage().deleteAllCookies();
                wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            case FIREFOX:
                wd = new FirefoxDriverManager().createDriver();
                wd.manage().deleteAllCookies();
                wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            default:
                System.out.println("Browser not supported");
        }
        return wd;
    }

    public enum BrowserList {
        CHROME, FIREFOX
    }
}
