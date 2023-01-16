package page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//article[@class='devsite-article-inner']")
    private WebElement searchResultsTab;

    @FindBy(xpath = "//a/b[text()='Google Cloud Pricing Calculator']")
    private WebElement pricingCalculatorLink;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickPricingCalculatorLink() {
        pricingCalculatorLink.click();
    }

}
