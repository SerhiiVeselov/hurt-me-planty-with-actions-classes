package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class BaseAction {
    protected FluentWait fluentWait;
    protected WebDriver driver;

    public BaseAction(WebDriver driver) {
        this.driver = driver;
        this.fluentWait = new FluentWait<>(driver);
    }

}
