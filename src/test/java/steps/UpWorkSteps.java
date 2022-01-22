package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;

import page_model.DuckHomepage;
import page_model.DuckSearchItems;
import page_model.GoogleHomepage;
import page_model.GoogleSearchItems;

import utils.driver.DriverFactory;
import utils.map.MapUtils;

import java.util.HashMap;
import java.util.Map;

public class UpWorkSteps {

    public static WebDriver wd;
    public static Map<Integer, String[]> searchResultsGoogle = new HashMap<Integer, String[]>();
    public static Map<Integer, String[]> searchResultsDuck = new HashMap<Integer, String[]>();
    String searchEngine;
    String keyword;

    @Given("user goes to Google website using {string}")
    public void goToGoogle(String browser) {
        wd = new DriverFactory().setupDriver(browser);
        wd.get("https://www.google.com/");
        searchEngine = "Google";
    }

    @Given("user goes to Duck website using {string}")
    public void goToBing(String browser) {
        wd = new DriverFactory().setupDriver(browser);
        wd.get("https://duckduckgo.com/");
        searchEngine = "Duck";
    }

    @When("user searches for {string}")
    public void search(String keyword) {
        switch (searchEngine) {
            case "Google":
                GoogleHomepage ghp = new GoogleHomepage(wd);
                ghp.search(keyword);
                break;
            case "Duck":
                DuckHomepage dhp = new DuckHomepage(wd);
                dhp.search(keyword);
                break;
            default:
                System.out.println("No Match");
        }
        this.keyword = keyword;
    }

    @And("saves the first 10 items")
    public void savesTheFirst10Items() {
        switch (searchEngine) {
            case "Google":
                GoogleSearchItems gsi = new GoogleSearchItems(wd);
                searchResultsGoogle = gsi.createMap(searchResultsGoogle);
                break;
            case "Duck":
                DuckSearchItems dsi = new DuckSearchItems(wd);
                searchResultsDuck = dsi.createMap(searchResultsDuck, wd);
                break;
            default:
                System.out.println("No Match");
        }
    }

    @Then("at least one attribute of each item contains searched keyword")
    public void atLeastOneAttributeOfEachItemContains() {
        MapUtils mp = new MapUtils();
        switch (searchEngine) {
            case "Google":
                mp.validateKeyword(keyword, searchResultsGoogle);
                break;
            case "Duck":
                mp.validateKeyword(keyword, searchResultsDuck);
                break;
            default:
                System.out.println("No Match");
        }
    }

    @Then("show duplicated items from both search engines results")
    public void showDuplicatedItemsFromBothSearchEnginesResults() {
        MapUtils mp = new MapUtils();
        mp.duplicatedTitles(searchResultsGoogle, searchResultsDuck);
    }

    @After
    public void closeDriver() {
       wd.quit();
    }

}
