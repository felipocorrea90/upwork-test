package page_model;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomepage {
    public GoogleHomepage(WebDriver wd) {
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchInput;

    @FindBy(xpath = "//input[@value='Google Search']")
    WebElement searchButton;

    public void search(String keyword) {
        searchInput.sendKeys(keyword);
        searchInput.sendKeys(Keys.ENTER);
    }
}
