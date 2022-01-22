package page_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.map.MapUtils;

import java.util.*;

public class GoogleSearchItems {

    public GoogleSearchItems(WebDriver wd) {
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//div[@class='g tF2Cxc']")
    List<WebElement> searchItems;

    @FindBy(xpath = "//div[@class='g tF2Cxc']//div[@class='TbwUpd NJjxre']/cite")
    List<WebElement> searchUrls;

    @FindBy(xpath = "//div[@class='g tF2Cxc']//h3[@class='LC20lb MBeuO DKV0Md']")
    List<WebElement> searchTitles;

    @FindBy(xpath = "//div[@class='g tF2Cxc']//div[contains(@class,'NJo7tc') and contains(@class,'uUuwM')]")
    List<WebElement>  searchDescriptions;

    @FindBy(id = "pnnext")
    WebElement nextPage;

    public void goToNextPage() {
        nextPage.click();
    }

    public Map<Integer, String[]> createMap(Map<Integer, String[]> searchResultsGoogle) {
        MapUtils mp = new MapUtils();
        searchResultsGoogle = mp.createMap(searchResultsGoogle, searchItems, searchUrls, searchTitles, searchDescriptions);
        while (searchResultsGoogle.size() < 10) {
            goToNextPage();
            mp.createMap(searchResultsGoogle, searchItems, searchUrls, searchTitles, searchDescriptions);
        }
        return searchResultsGoogle;
    }

}
