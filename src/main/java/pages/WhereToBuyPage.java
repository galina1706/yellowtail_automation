package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WhereToBuyPage {
    WebDriver driver;

    public WhereToBuyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#locationName")
    private WebElement fieldLocation;
    @FindBy(css = ".search-submit")
    private WebElement searchButton;
    @FindBy(css = "div.address")
    private List<WebElement> searchResults;

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

    public void waitForElement(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitGeneral(){
        new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public WebElement getFieldLocation() {
        return fieldLocation;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }
}
