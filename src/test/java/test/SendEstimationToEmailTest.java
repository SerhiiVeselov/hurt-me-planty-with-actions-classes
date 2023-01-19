package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import page.EmailGeneratorPage;
import page.MainPage;
import page.PricingCalculatorPage;
import page.SearchResultsPage;
import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SendEstimationToEmailTest {

    public static WebDriver driver;
    public static FluentWait<WebDriver> fluentWait;
    public static MainPage mainPage;
    public static SearchResultsPage searchResultsPage;
    public static PricingCalculatorPage pricingCalculatorPage;

    public static EmailGeneratorPage emailGeneratorPage;
    String emailAddress;

    @BeforeAll
    public static void driverSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        pricingCalculatorPage = new PricingCalculatorPage(driver);
        emailGeneratorPage = new EmailGeneratorPage(driver);

        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    @AfterAll
    public static void driverQuit() {
        driver.quit();
        driver = null;
    }

    @Test
    @Order(1)
    @DisplayName("Fill the Calculation Form")
    public void sendEstimationToEmail() {
        pricingCalculatorPage.openGeneratedEstimationPage();
        mainPage.closeCookiesPopUp();
        emailGeneratorPage.openEmailGeneratorPage();
        emailAddress = emailGeneratorPage.getEmailAddress();
        switchToTab("Google Cloud");
        pricingCalculatorPage.clickEmailEstimateBtn();
        pricingCalculatorPage.enterEmailAddress(emailAddress);
        pricingCalculatorPage.clickSendEmailBtn();
        switchToTab("Email Generator");
        fluentWait.until(ExpectedConditions.visibilityOf(emailGeneratorPage.getEstimatedCostFromEmail()));
        assertEquals("Estimated Monthly Cost: USD 2,563.32", emailGeneratorPage.getEstimatedCostFromEmail().getText());
    }

    public void switchToTab(String title) {
        for (String winHandle : driver.getWindowHandles()) {
            if (driver.switchTo().window(winHandle).getTitle().contains(title)) {
                driver.switchTo().window(winHandle);
                break;
            }
        }
    }

}
