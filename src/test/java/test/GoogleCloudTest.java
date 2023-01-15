package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import page.MainPage;
import page.PricingCalculatorPage;
import page.SearchResultsPage;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class GoogleCloudTest {

    public static WebDriver driver;
    public static FluentWait<WebDriver> fluentWait;
    public static MainPage mainPage;
    public static SearchResultsPage searchResultsPage;
    public static PricingCalculatorPage pricingCalculatorPage;

    @BeforeAll
    public static void driverSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        pricingCalculatorPage = new PricingCalculatorPage(driver);

        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    @Test
    @Order(1)
    @DisplayName("Open Pricing Calculator page")
    public void openPricingCalculator() {
        mainPage.openPage();
        fluentWait.until(ExpectedConditions.visibilityOf(mainPage.getCookiesOkBtn()));
        mainPage.closeCookiesPopUp();
        mainPage.openSearchField();
        mainPage.enterSearchRequest();
        fluentWait.until(ExpectedConditions.visibilityOf(mainPage.getSuggestSearchResult()));
        mainPage.clickSuggestSearchResult();
        fluentWait.until(ExpectedConditions.visibilityOf(searchResultsPage.getSearchResultsTab()));
        searchResultsPage.clickPricingCalculatorLink();
        assertEquals("https://cloud.google.com/products/calculator", driver.getCurrentUrl());
    }

    @Test
    @Order(2)
    @DisplayName("Fill the Calculation Form")
    public void fillCalculationForm() {
        driver.get("https://cloud.google.com/products/calculator");
        mainPage.closeCookiesPopUp();

        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(pricingCalculatorPage.getCloudSideFrame()));
        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((pricingCalculatorPage.getMyFrame())));
        pricingCalculatorPage.enterNumberOfInstances();
        pricingCalculatorPage.selectOperatingSystem();
        pricingCalculatorPage.selectProvisioningModel();
        pricingCalculatorPage.selectMachineType();
        pricingCalculatorPage.checkAddGpuCheckBox();
        pricingCalculatorPage.selectGpuType();
        pricingCalculatorPage.selectGpuQuantity();
        pricingCalculatorPage.selectLocalSsd();
        pricingCalculatorPage.selectDatacenterLocation();
        pricingCalculatorPage.addToEstimate();
        //  assertEquals("n1-standard-8 (vCPUs: 8, RAM: 30GB)", pricingCalculatorPage.getMachineTypeDrpDwn().getText());
    }

    @Test
    @Disabled
    @Order(3)
    public void verifyVmClass() {
        assertEquals(pricingCalculatorPage.getMachineTypeDrpDwn()
                .getAttribute("aria-label"), "Instance type: n1-standard-8 (vCPUs: 8, RAM: 30GB)");
    }

    @Test
    @Disabled
    @Order(3)
    public void verifyInstanceType() {

    }

    @Test
    @Disabled
    @Order(4)
    public void verifyRegion() {

    }

    @Test
    @Disabled
    @Order(5)
    public void verifyLocalSsd() {

    }

    @Test
    @Disabled
    @Order(6)
    public void verifyCommitmentTerm() {

    }

    @Test
    @Disabled
    @Order(7)
    public void verifyCalculatedCost() {

    }

    @AfterAll
    public static void driverQuit() {
        driver.quit();
        driver = null;
    }
}
