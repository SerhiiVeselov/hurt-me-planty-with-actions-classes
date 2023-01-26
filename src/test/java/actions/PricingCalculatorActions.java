package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PricingCalculatorPage;

public class PricingCalculatorActions extends BaseAction {

    PricingCalculatorPage pricingCalculatorPage = new PricingCalculatorPage(driver);

    public PricingCalculatorActions(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://cloud.google.com/products/calculator");

    }

    public void enterNumberOfInstances(String numbOfInstances) {
        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(pricingCalculatorPage.getCloudSideFrame()));
        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((pricingCalculatorPage.getMyFrame())));
        pricingCalculatorPage.getNumberOfInstancesField().sendKeys(numbOfInstances);
    }

    public void selectOperatingSystem() {
        pricingCalculatorPage.getOperatingSystemDrpDwn().click();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getDebianOperatingSystem()));
        pricingCalculatorPage.getDebianOperatingSystem().click();
    }

    public void selectProvisioningModel() {
        pricingCalculatorPage.getProvisioningModelDrpDwn().click();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getSpotProvisioningModel()));
        pricingCalculatorPage.getSpotProvisioningModel().click();
    }

    public void selectMachineType() {
        pricingCalculatorPage.getMachineTypeDrpDwn().click();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getN1Standard8MachineType()));
        pricingCalculatorPage.getN1Standard8MachineType().click();
    }

    public void checkAddGpuCheckBox() {
        pricingCalculatorPage.getAddGpuCheckBox().click();
    }

    public void selectGpuType() {
        pricingCalculatorPage.getGpuTypeDrpDwn().click();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getNVidiaTeslaV100Gpu()));
        pricingCalculatorPage.getNVidiaTeslaV100Gpu().click();
    }

    public void selectGpuQuantity() {
        pricingCalculatorPage.getNumberOfGpuDrpDwn().click();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getGpuQuantity()));
        pricingCalculatorPage.getGpuQuantity().click();
    }

    public void selectLocalSsd() {
        pricingCalculatorPage.getLocalSsdDrpDwn().click();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getLocalSsdValue()));
        pricingCalculatorPage.getLocalSsdValue().click();
    }

    public void selectDatacenterLocation() {
        pricingCalculatorPage.getDatacenterLocationDrpDwn().click();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getFrankfurtDatacenterLocation()));
        pricingCalculatorPage.getFrankfurtDatacenterLocation().click();
    }

    public void addToEstimate() {
        fluentWait.until(ExpectedConditions.elementToBeClickable(pricingCalculatorPage.getAddToEstimateBtn()));
        pricingCalculatorPage.getAddToEstimateBtn().click();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getTotalEstimatedCost()));
    }

    public void openGeneratedEstimationPage() {
        driver.get("https://cloud.google.com/products/calculator#id=2bb335fe-cd07-47d0-b714-081424f311cb");
    }

    public void clickEmailEstimateBtn() {
        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(pricingCalculatorPage.getCloudSideFrame()));
        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((pricingCalculatorPage.getMyFrame())));
        pricingCalculatorPage.getEmailEstimateBtn().click();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getEmailAddressField()));
    }

    public void enterEmailAddress(String emailAddress) {
        pricingCalculatorPage.getEmailAddressField().click();
        pricingCalculatorPage.getEmailAddressField().sendKeys(emailAddress);
    }

    public void clickSendEmailBtn() {
        pricingCalculatorPage.getSendEmailBtn().click();
        fluentWait.until(ExpectedConditions.invisibilityOf(pricingCalculatorPage.getSendEmailBtn()));
    }

}
