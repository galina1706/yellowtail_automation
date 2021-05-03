package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiters;

import java.time.Duration;
import java.util.List;

public class WhereToBuyPage extends AbstractPage{
    public WhereToBuyPage() {
        super();
        waitForPageUrl();
    }

    @FindBy(css = "#locationName")
    private WebElement fieldLocation;
    @FindBy(css = ".search-submit")
    private WebElement searchButton;
    @FindBy(css = "div.address")
    private List<WebElement> searchResults;

    public void waitForPageUrl() {
        new WebDriverWait(ProviderForDriver.getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.urlContains("yellowtailwine.com/stores"));
    }

    public void fieldLocationClick() {
        fieldLocation.click();
    }

    public void searchButtonClick() {
        searchButton.click();
    }

    public void elementSendKeys(WebElement element, String input) {
        element.sendKeys(input);
    }

    public String searchResultsGetText(WebElement element){
        return element.getText();
    }

    @Override
    public void waitForLoadableElement(WebElement webElement){
        Waiters.waitForElementToBeVisible(webElement);
    }

    public WebElement getFieldLocation() {
        return fieldLocation;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }
}
