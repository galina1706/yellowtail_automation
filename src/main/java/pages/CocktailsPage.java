package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CocktailsPage {
    WebDriver driver;

    public CocktailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
        int winHandleNum = driver.getWindowHandles().size();
        if (winHandleNum > 1){
            for (String winHandle: driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }
        }
        return new CocktailDetailsPage(driver);
    }

    public String cocktailsTypeFieldGetText() {
        return cocktailsTypeField.getText();
    }

    public void scrolling(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForElement(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(element));
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
}
