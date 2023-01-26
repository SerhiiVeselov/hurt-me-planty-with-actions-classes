package actions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import pages.MainPage;

public class MainPageActions extends BaseAction {

    MainPage mainPage = new MainPage(driver);

    public MainPageActions(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        driver.get("https://cloud.google.com/");
    }

    public void closeCookiesPopUp() {

        try {
            if (mainPage.getCookiesOkBtn().isDisplayed()) {
                mainPage.getCookiesOkBtn().click();
                fluentWait.until(ExpectedConditions.invisibilityOf(mainPage.getCookiesOkBtn()));
            }
        }
        catch (NoSuchElementException e) {

        }
    }

    public void openSearchField() {
        mainPage.getSearchBtn().click();
    }

    public void enterSearchRequest() {
        mainPage.getSearchField().sendKeys("Google Cloud Platform Pricing Calculator");
    }

    public void clickSuggestSearchResult() {
        mainPage.getSuggestSearchResult().click();
    }

}
