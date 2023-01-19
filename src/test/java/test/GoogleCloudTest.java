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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    @AfterAll
    public static void driverQuit() {
        driver.quit();
        driver = null;
    }

    @Test
    @Order(1)
    @DisplayName("Search the Pricing Calculator page")
    public void openPricingCalculator() {
        mainPage.openMainPage();
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
        pricingCalculatorPage.openPage();
        mainPage.closeCookiesPopUp();
        pricingCalculatorPage.enterNumberOfInstances("4");
        pricingCalculatorPage.selectOperatingSystem();
        pricingCalculatorPage.selectProvisioningModel();
        pricingCalculatorPage.selectMachineType();
        pricingCalculatorPage.checkAddGpuCheckBox();
        pricingCalculatorPage.selectGpuType();
        pricingCalculatorPage.selectGpuQuantity();
        pricingCalculatorPage.selectLocalSsd();
        pricingCalculatorPage.selectDatacenterLocation();
        pricingCalculatorPage.addToEstimate();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getTotalEstimatedCost()));
    }

    @Test
    @Order(3)
    @DisplayName("Verify selected Provisioning Model")
    public void verifyProvisioningModel() {
        pricingCalculatorPage.openPage();
        mainPage.closeCookiesPopUp();
        pricingCalculatorPage.enterNumberOfInstances("4");
        pricingCalculatorPage.selectOperatingSystem();
        pricingCalculatorPage.selectProvisioningModel();
        pricingCalculatorPage.selectMachineType();
        pricingCalculatorPage.checkAddGpuCheckBox();
        pricingCalculatorPage.selectGpuType();
        pricingCalculatorPage.selectGpuQuantity();
        pricingCalculatorPage.selectLocalSsd();
        pricingCalculatorPage.selectDatacenterLocation();
        pricingCalculatorPage.addToEstimate();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getTotalEstimatedCost()));
        assertEquals("Provisioning model: Spot", pricingCalculatorPage.getProvisioningModelOutput().getText());
    }

    @Test
    @Order(4)
    @DisplayName("Verify selected Instance type name")
    public void verifyInstanceType() {
        pricingCalculatorPage.openPage();
        mainPage.closeCookiesPopUp();
        pricingCalculatorPage.enterNumberOfInstances("4");
        pricingCalculatorPage.selectOperatingSystem();
        pricingCalculatorPage.selectProvisioningModel();
        pricingCalculatorPage.selectMachineType();
        pricingCalculatorPage.checkAddGpuCheckBox();
        pricingCalculatorPage.selectGpuType();
        pricingCalculatorPage.selectGpuQuantity();
        pricingCalculatorPage.selectLocalSsd();
        pricingCalculatorPage.selectDatacenterLocation();
        pricingCalculatorPage.addToEstimate();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getTotalEstimatedCost()));
        assertEquals("Instance type: n1-standard-8", pricingCalculatorPage.getInstanceTypeOutput().getText());
    }

    @Test
    @Order(5)
    @DisplayName("Verify selected Region")
    public void verifyRegion() {
        pricingCalculatorPage.openPage();
        mainPage.closeCookiesPopUp();
        pricingCalculatorPage.enterNumberOfInstances("4");
        pricingCalculatorPage.selectOperatingSystem();
        pricingCalculatorPage.selectProvisioningModel();
        pricingCalculatorPage.selectMachineType();
        pricingCalculatorPage.checkAddGpuCheckBox();
        pricingCalculatorPage.selectGpuType();
        pricingCalculatorPage.selectGpuQuantity();
        pricingCalculatorPage.selectLocalSsd();
        pricingCalculatorPage.selectDatacenterLocation();
        pricingCalculatorPage.addToEstimate();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getTotalEstimatedCost()));
        assertEquals("Region: Frankfurt", pricingCalculatorPage.getRegionOutput().getText());
    }

    @Test
    @Order(6)
    @DisplayName("Verify selected Local SSD name")
    public void verifyLocalSsd() {
        pricingCalculatorPage.openPage();
        mainPage.closeCookiesPopUp();
        pricingCalculatorPage.enterNumberOfInstances("4");
        pricingCalculatorPage.selectOperatingSystem();
        pricingCalculatorPage.selectProvisioningModel();
        pricingCalculatorPage.selectMachineType();
        pricingCalculatorPage.checkAddGpuCheckBox();
        pricingCalculatorPage.selectGpuType();
        pricingCalculatorPage.selectGpuQuantity();
        pricingCalculatorPage.selectLocalSsd();
        pricingCalculatorPage.selectDatacenterLocation();
        pricingCalculatorPage.addToEstimate();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getTotalEstimatedCost()));
        assertEquals("Local SSD: 2x375 GiB", pricingCalculatorPage.getLocalSsdOutput().getText());
    }

    @Test
    @Order(7)
    @DisplayName("Verify calculated Total Cost")
    public void verifyCalculatedCost() {
        pricingCalculatorPage.openPage();
        mainPage.closeCookiesPopUp();
        pricingCalculatorPage.enterNumberOfInstances("4");
        pricingCalculatorPage.selectOperatingSystem();
        pricingCalculatorPage.selectProvisioningModel();
        pricingCalculatorPage.selectMachineType();
        pricingCalculatorPage.checkAddGpuCheckBox();
        pricingCalculatorPage.selectGpuType();
        pricingCalculatorPage.selectGpuQuantity();
        pricingCalculatorPage.selectLocalSsd();
        pricingCalculatorPage.selectDatacenterLocation();
        pricingCalculatorPage.addToEstimate();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getTotalEstimatedCost()));
        assertEquals("Total Estimated Cost: USD 2,563.32 per 1 month", pricingCalculatorPage.getTotalEstimatedCost().getText());
    }

}
