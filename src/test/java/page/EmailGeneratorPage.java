package page;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.ArrayList;
@Getter
public class EmailGeneratorPage extends AbstractPage {

    FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);

    @FindBy(id = "email_ch_text")
    private WebElement emailAddress;

    @FindBy(xpath = "//h2[contains(text(), 'Estimated Monthly Cost')]")
    private WebElement estimatedCostFromEmail;

    public EmailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    public void openEmailGeneratorPage() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://generator.email/inbox2/");
        fluentWait.until(ExpectedConditions.visibilityOf(emailAddress));
    }

    public String getEmailAddress() {
        String generatedEmail = emailAddress.getText();
        return generatedEmail;
    }

}
