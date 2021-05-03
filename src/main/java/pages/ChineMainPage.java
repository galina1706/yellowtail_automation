package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiters;

import java.time.Duration;

public class ChineMainPage extends AbstractPage{

    public ChineMainPage() {
        super();
        waitForPageUrl();
    }

    @FindBy (css = ".heading-editable>font:first-child")
    private WebElement chinaMainPageWelcomeLabel;
    @FindBy (css = ".sgg-comp-social-icon>.fa.fa-weibo")
    private WebElement weiboIcon;

    public void waitForPageUrl() {
        new WebDriverWait(ProviderForDriver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("yellowtailwine.cn"));
    }

    public void weiboIconClick() {
        weiboIcon.click();
    }

    public WeiboChinaPage navigateToWeiboChinaPage() {
        //wait
        waitForLoadableElement(getWeiboIcon());
        weiboIconClick();

        int winHandleNum = ProviderForDriver.getDriver().getWindowHandles().size();
        if (winHandleNum > 1){
            for (String winHandle: ProviderForDriver.getDriver().getWindowHandles()){
                ProviderForDriver.getDriver().switchTo().window(winHandle);
            }
        }
        return new WeiboChinaPage();
    }

    @Override
    public void waitForLoadableElement(WebElement webElement){
        Waiters.waitForElementToBeVisible(webElement);
    }

    public String getPageUrl(){
        return ProviderForDriver.getDriver().getCurrentUrl();
    }

    public WebElement getWeiboIcon() {
        return weiboIcon;
    }
}

