package page;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

@Getter
public class MainPage extends AbstractPage {

    FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);

    @FindBy(xpath = "//button[@class='devsite-snackbar-action']")
    private WebElement cookiesOkBtn;

    @FindBy(xpath = "//div[@class='devsite-searchbox']")
    private WebElement searchBtn;

    @FindBy(xpath = "//div[@class='devsite-searchbox']/input")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"suggestion-partial-query-2\"]/a/span")
    private WebElement suggestSearchResult;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        driver.get("https://cloud.google.com/");
    }

//    public void closeCookiesPopUp() {
//        cookiesOkBtn.click();
//        fluentWait.until(ExpectedConditions.invisibilityOf(cookiesOkBtn));
//    }

    public void closeCookiesPopUp() {

        try {
            if (cookiesOkBtn.isDisplayed()) {
                cookiesOkBtn.click();
                fluentWait.until(ExpectedConditions.invisibilityOf(cookiesOkBtn));
            }
        }
        catch (NoSuchElementException e) {

        }
    }

    public void openSearchField() {
        searchBtn.click();
    }

    public void enterSearchRequest() {
        searchField.sendKeys("Google Cloud Platform Pricing Calculator");
    }

    public void clickSuggestSearchResult() {
        suggestSearchResult.click();
    }

}
