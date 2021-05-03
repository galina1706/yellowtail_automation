package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiters;

import java.time.Duration;
import java.util.List;

public class CocktailsPage extends AbstractPage{

    public CocktailsPage() {
        super();
    }

    @FindBy(css = ".selected")
    private WebElement selectCocktailsDropBox;
    @FindBy(css = "[data-value=\"red\"]")
    private WebElement redWineCocktailItem;
    @FindBy(css = "[data-value=\"bubbles\"]")
    private WebElement sparklingWineCocktailItem;
    @FindBy(css = ".selected>span")
    private WebElement cocktailsTypeField;
    @FindBy(css = "[href=\"raspberry-rose\"]")
    private WebElement raspberryRoseWine;
    @FindBy(xpath = "//div[@class=\"tile recipe-tile\"]")
    private List<WebElement> searchResults;

    public void selectCocktailsDropBoxClick() {
        selectCocktailsDropBox.click();
    }

    public void redWineCocktailItemClick() {
        redWineCocktailItem.click();
    }

    public void raspberryRoseWineClick() {
        raspberryRoseWine.click();
    }

    public void sparklingWineCocktailItemClick() {
        sparklingWineCocktailItem.click();
    }

    public int elementsCount(List<WebElement> elements) {
        return elements.size();
    }

    public CocktailDetailsPage navigateToCocktailDetailsPage(){
        int winHandleNum = ProviderForDriver.getDriver().getWindowHandles().size();

        if (winHandleNum > 1){
            for (String winHandle: ProviderForDriver.getDriver().getWindowHandles()){
                ProviderForDriver.getDriver().switchTo().window(winHandle);
            }
        }
        return new CocktailDetailsPage();
    }

    public String cocktailsTypeFieldGetText() {
        return cocktailsTypeField.getText();
    }

    public void scrolling(WebElement element) {
        ((JavascriptExecutor)ProviderForDriver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement getSelectCocktailsDropBox() {
        return selectCocktailsDropBox;
    }

    public WebElement getRedWineCocktailItem() {
        return redWineCocktailItem;
    }

    public WebElement getSparklingWineCocktailItem() {
        return sparklingWineCocktailItem;
    }

    public WebElement getRaspberryRoseWine() {
        return raspberryRoseWine;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    @Override
    public void waitForLoadableElement(WebElement webElement){
        Waiters.waitForElementToBeVisible(webElement);
    }
}
