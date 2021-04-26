package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChineMainPage {
    WebDriver driver;

    public ChineMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".heading-editable>font:first-child")
    private WebElement chinaMainPageWelcomeLabel;
    @FindBy (css = ".sgg-comp-social-icon>.fa.fa-weibo")
    private WebElement weiboIcon;

    public void elementClick(WebElement element) {
        element.click();
    }

    public WeiboChinaPage switchToWeiboChinaPage() {
        int winHandleNum = driver.getWindowHandles().size();
        if (winHandleNum > 1){
            for (String winHandle: driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }
        }
        return new WeiboChinaPage(driver);
    }

    public void waitForElement(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitGeneral(){
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public WebElement getChinaMainPageWelcomeLabel() {
        return chinaMainPageWelcomeLabel;
    }

    public WebElement getWeiboIcon() {
        return weiboIcon;
    }
}

