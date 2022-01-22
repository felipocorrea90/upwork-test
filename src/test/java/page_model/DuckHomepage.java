package page_model;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuckHomepage {
    public DuckHomepage(WebDriver wd) {
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchInput;

    public void search(String keyword) {
        searchInput.sendKeys(keyword);
        searchInput.sendKeys(Keys.ENTER);
    }
}
