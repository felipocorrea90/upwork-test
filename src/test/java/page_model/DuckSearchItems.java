package page_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.map.MapUtils;

import java.util.List;
import java.util.Map;

public class DuckSearchItems {
    public DuckSearchItems(WebDriver wd) {
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//div[@id='links']/div[contains(@class,'results_links_deep')]")
    List<WebElement> searchItems;

    @FindBy(xpath = "//div[@id='links']/div//span[@class='result__url__domain']")
    List<WebElement> searchUrls;

    @FindBy(xpath = "//div[@id='links']//a[@data-testid='result-title-a']")
    List<WebElement> searchTitles;

    @FindBy(xpath = "//div[@id='links']//div[contains(@class,'result__snippet')]")
    List<WebElement>  searchDescriptions;

    public Map<Integer, String[]> createMap(Map<Integer, String[]> searchResultsDuck, WebDriver wd) {
        MapUtils mp = new MapUtils();
        searchResultsDuck = mp.createMap(searchResultsDuck, searchItems, searchUrls, searchTitles, searchDescriptions);
        return searchResultsDuck;
    }

}
