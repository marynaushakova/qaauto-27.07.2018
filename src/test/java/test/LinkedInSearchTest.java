package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedInHomePage;
import page.LinkedInSearchPage;

import java.util.List;

public class LinkedInSearchTest extends BaseTest{

    @Test
    public void linkedInFindHRTest() {
        String searchTerm = "HR";
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login("mf689799@gmail.com", "MirMer1010");
        Assert.assertTrue(linkedInHomePage.isLoaded(), "Home page is not loaded");

        LinkedInSearchPage linkedInSearchPage = linkedInHomePage.search("HR");
        Assert.assertTrue(linkedInSearchPage.isLoaded(), "Search page is not loaded");
        Assert.assertEquals(linkedInSearchPage.getSearchResultsCount(), 10, "Search results count is wrong");

        List<String> searchResults = linkedInSearchPage.getSearchResultsList();
        for (String searchResult : searchResults) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "searchTerm " + searchTerm + " not found in : \n" + searchResult);
        }
    }
}


