package actions;

import org.openqa.selenium.WebDriver;
import pages.SearchResultsPage;

public class SearchResultsActions extends BaseAction {

    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    public SearchResultsActions(WebDriver driver) {
        super(driver);
    }

    public void clickPricingCalculatorLink() {
        searchResultsPage.getPricingCalculatorLink().click();
    }
}
