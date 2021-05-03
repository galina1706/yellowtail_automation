package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiters;

import java.time.Duration;

public class WeiboChinaPage extends AbstractPage{

    public WeiboChinaPage() {
        super();
        waitForWeiboPageUrl();
    }

    public void waitForWeiboPageUrl() {
        new WebDriverWait(ProviderForDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.urlContains("weibo.com/yellowtailChina"));
    }

    public String getPageUrl(){
        return ProviderForDriver.getDriver().getCurrentUrl();
    }

    @Override
    public void waitForLoadableElement(WebElement webElement){
        Waiters.waitForElementToBeVisible(webElement);
    }
}
