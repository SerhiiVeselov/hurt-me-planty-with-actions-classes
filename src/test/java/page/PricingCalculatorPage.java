package page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

@Getter
public class PricingCalculatorPage extends AbstractPage {

    FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);

    @FindBy(xpath = ".//*[starts-with(@name,'goog_')]")
    private WebElement cloudSideFrame;

    @FindBy(id = "myFrame")
    private WebElement myFrame;

    @FindBy(id = "input_90")
    private WebElement numberOfInstancesField;

    @FindBy(css = "#select_value_label_82")
    private WebElement operatingSystemDrpDwn;

    @FindBy(id = "select_option_92")
    private WebElement debianOperatingSystem;

    @FindBy(css = "#select_value_label_83")
    private WebElement provisioningModelDrpDwn;

    @FindBy(id = "select_option_106")
    private WebElement spotProvisioningModel;

    @FindBy(css = "#select_value_label_86")
    private WebElement machineTypeDrpDwn;

    @FindBy(id = "select_option_428")
    private WebElement n1Standard8MachineType;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGpuCheckBox;

    @FindBy(id = "select_466")
    private WebElement gpuTypeDrpDwn;

    @FindBy(id = "select_option_473")
    private WebElement nVidiaTeslaV100Gpu;

    @FindBy(id = "select_value_label_465")
    private WebElement numberOfGpuDrpDwn;

    @FindBy(id = "select_option_477")
    private WebElement gpuQuantity;

    @FindBy(id = "select_value_label_422")
    private WebElement localSsdDrpDwn;

    @FindBy(id = "select_option_449")
    private WebElement localSsdValue;

    @FindBy(id = "select_value_label_88")
    private WebElement datacenterLocationDrpDwn;

    @FindBy(id = "select_option_228")
    private WebElement frankfurtDatacenterLocation;

    @FindBy(xpath = "//*[@id=\"mainForm\"]//div[21]/button")
    private WebElement addToEstimateBtn;

    @FindBy(xpath = "//div[@class='cpc-cart-total']")
    private WebElement totalEstimatedCost;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void switchToMainFrame() {
        driver.switchTo().defaultContent();
    }

    public void enterNumberOfInstances() {
        numberOfInstancesField.sendKeys("4");
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

}
