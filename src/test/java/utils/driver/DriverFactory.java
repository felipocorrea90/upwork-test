package utils.driver;

import org.openqa.selenium.WebDriver;
import utils.driver.browser_manager.ChromeDriverManager;
import utils.driver.browser_manager.FirefoxDriverManager;

public class DriverFactory {

    public WebDriver setupDriver(String browser) {
        WebDriver wd = null;
        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

        switch (browserType) {
            case CHROME:
                wd = new ChromeDriverManager().createDriver();
                break;
            case FIREFOX:
                wd = new FirefoxDriverManager().createDriver();
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
