package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WeiboChinaPage {
    WebDriver driver;

    public WeiboChinaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPageTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs("黄尾袋鼠葡萄酒China的微博_微博"));
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
}
