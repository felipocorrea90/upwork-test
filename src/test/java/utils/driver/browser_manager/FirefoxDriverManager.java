package utils.driver.browser_manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.driver.Factory;

import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class FirefoxDriverManager  implements Factory {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(FIREFOX).setup();
        return new FirefoxDriver();
    }
}
