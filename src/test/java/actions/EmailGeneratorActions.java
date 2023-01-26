package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.EmailGeneratorPage;

public class EmailGeneratorActions extends BaseAction {

    EmailGeneratorPage emailGeneratorPage = new EmailGeneratorPage(driver);

    public EmailGeneratorActions(WebDriver driver) {
        super(driver);
    }

    public void openEmailGeneratorPage() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://generator.email/inbox2/");
        fluentWait.until(ExpectedConditions.visibilityOf(emailGeneratorPage.getEmailAddress()));
    }

    public String getEmailAddress() {
        String generatedEmail = emailGeneratorPage.getEmailAddress().getText();
        return generatedEmail;
    }

}
