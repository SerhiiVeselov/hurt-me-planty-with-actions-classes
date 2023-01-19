package page;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.ArrayList;

@Getter
public class PricingCalculatorPage extends AbstractPage {

    FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
    ArrayList<String> openedTab = new ArrayList<>(driver.getWindowHandles());
    MainPage mainPage = new MainPage(driver);
    EmailGeneratorPage emailGeneratorPage = new EmailGeneratorPage(driver);

    @FindBy(xpath = "//iframe[starts-with(@name,'goog_')]")
    private WebElement cloudSideFrame;

    @FindBy(id = "myFrame")
    private WebElement myFrame;

    @FindBy(id = "input_91")
    private WebElement numberOfInstancesField;

    @FindBy(css = "#select_value_label_83")
    private WebElement operatingSystemDrpDwn;

    @FindBy(id = "select_option_93")
    private WebElement debianOperatingSystem;

    @FindBy(css = "#select_value_label_84")
    private WebElement provisioningModelDrpDwn;

    @FindBy(id = "select_option_107")
    private WebElement spotProvisioningModel;

    @FindBy(css = "#select_value_label_87")
    private WebElement machineTypeDrpDwn;

    @FindBy(id = "select_option_429")
    private WebElement n1Standard8MachineType;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGpuCheckBox;

    @FindBy(id = "select_467")
    private WebElement gpuTypeDrpDwn;

    @FindBy(id = "select_option_474")
    private WebElement nVidiaTeslaV100Gpu;

    @FindBy(id = "select_value_label_466")
    private WebElement numberOfGpuDrpDwn;

    @FindBy(id = "select_option_478")
    private WebElement gpuQuantity;

    @FindBy(id = "select_value_label_423")
    private WebElement localSsdDrpDwn;

    @FindBy(id = "select_option_450")
    private WebElement localSsdValue;

    @FindBy(id = "select_value_label_89")
    private WebElement datacenterLocationDrpDwn;

    @FindBy(id = "select_option_229")
    private WebElement frankfurtDatacenterLocation;

    @FindBy(xpath = "//*[@id=\"mainForm\"]//div[21]/button")
    private WebElement addToEstimateBtn;

    @FindBy(xpath = "//div[@class='cpc-cart-total']")
    private WebElement totalEstimatedCost;

    @FindBy(xpath = "//div[contains(text(), 'Instance type')]")
    private WebElement instanceTypeOutput;

    @FindBy(xpath = "//div[contains(text(), 'Provisioning model')]")
    private WebElement provisioningModelOutput;

    @FindBy(xpath = "//div[contains(text(), 'Region')]")
    private WebElement regionOutput;

    @FindBy(xpath = "//div[contains(text(), 'Local SSD:')]")
    private WebElement localSsdOutput;

    @FindBy(id = "Email Estimate")
    private WebElement emailEstimateBtn;

    @FindBy(id = "dialogContent_549")
    private WebElement emailEstimateTab;

    @FindBy(id = "input_453")
    private WebElement emailAddressField;

    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private WebElement sendEmailBtn;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://cloud.google.com/products/calculator");

    }

    public void enterNumberOfInstances(String numbOfInstances) {
        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(cloudSideFrame));
        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((myFrame)));
        numberOfInstancesField.sendKeys(numbOfInstances);
    }

    public void selectOperatingSystem() {
        operatingSystemDrpDwn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(debianOperatingSystem));
        debianOperatingSystem.click();
    }

    public void selectProvisioningModel() {
        provisioningModelDrpDwn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(spotProvisioningModel));
        spotProvisioningModel.click();
    }

    public void selectMachineType() {
        machineTypeDrpDwn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(n1Standard8MachineType));
        n1Standard8MachineType.click();
    }

    public void checkAddGpuCheckBox() {
        addGpuCheckBox.click();
    }

    public void selectGpuType() {
        gpuTypeDrpDwn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(nVidiaTeslaV100Gpu));
        nVidiaTeslaV100Gpu.click();
    }

    public void selectGpuQuantity() {
        numberOfGpuDrpDwn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(gpuQuantity));
        gpuQuantity.click();
    }

    public void selectLocalSsd() {
        localSsdDrpDwn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(localSsdValue));
        localSsdValue.click();
    }

    public void selectDatacenterLocation() {
        datacenterLocationDrpDwn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(frankfurtDatacenterLocation));
        frankfurtDatacenterLocation.click();
    }

    public void addToEstimate() {
        fluentWait.until(ExpectedConditions.elementToBeClickable(addToEstimateBtn));
        addToEstimateBtn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(totalEstimatedCost));
    }

    public void openGeneratedEstimationPage() {
        driver.get("https://cloud.google.com/products/calculator#id=2bb335fe-cd07-47d0-b714-081424f311cb");
    }

    public void clickEmailEstimateBtn() {
        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(cloudSideFrame));
        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((myFrame)));
        emailEstimateBtn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(emailAddressField));
    }

    public void enterEmailAddress(String emailAddress) {
        emailAddressField.click();
        emailAddressField.sendKeys(emailAddress);
    }

    public void clickSendEmailBtn() {
        sendEmailBtn.click();
        fluentWait.until(ExpectedConditions.invisibilityOf(sendEmailBtn));
    }


}
