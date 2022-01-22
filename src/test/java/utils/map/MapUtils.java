package utils.map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.*;

public class MapUtils {

    public Map<Integer, String[]> createMap(Map<Integer, String[]> searchResults, List<WebElement> searchItems, List<WebElement> searchUrls,
                                            List<WebElement> searchTitles, List<WebElement> searchDescriptions) {
        // Populate map
        int i = 0;
        while (i < searchItems.size()) {
            if (searchResults.size() < 10) {
                String[] searchElements = new String[]{searchUrls.get(i).getText().split(" ")[0],searchTitles.get(i).getText(), searchDescriptions.get(i).getText()};
                searchResults.put(searchResults.size()+1, searchElements);
                i++;
            } else {
                break;
            }
        }
        return searchResults;
    }

    public void validateKeyword(String keyword, Map<Integer, String[]> searchItems) {
        int noKeywordFlag = 0;
        for (int i=0; i < 10; i++) {
            int noKeywordCounter = 0;
            System.out.println("----------");
            for (String item : searchItems.get(i+1)) {
                if (item.toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(item.toLowerCase() + " -> contains searched keyword");
                } else {
                    System.out.println(item.toLowerCase() + " -> does not contain searched keyword");
                    noKeywordCounter++;
                }
            }
            // Check if the keyword is not part of any of the 3 attributes from the search item
            if(noKeywordCounter == 3) {
                noKeywordFlag++;
            }
        }
        // Assert that at least one item from searchItems Map contains keyword
        Assert.assertTrue("At least one search item does not have the keyword on any of its components ",noKeywordFlag < 1);
    }

    public void duplicatedTitles(Map<Integer, String[]> searchItems1, Map<Integer, String[]> searchItems2) {
        int i = 0;
        while (i < 9) {
            for (int x=0; x <= 9; x++) {
                String urlItem1 = searchItems1.get(i+1)[0];
                //System.out.println("Url Item from SE1 " + (i+1) + " " + urlItem1);
                String urlItem2 = searchItems2.get(x+1)[0];
                //System.out.println("Url Item from SE2 " + (x+1) + " " + urlItem2);
                if (urlItem1.equals(urlItem2)) {
                    System.out.println("Item with URL " + searchItems1.get(i+1)[0] + " is found on both searches");
                }
            }
        i++;
        }
    }
}
