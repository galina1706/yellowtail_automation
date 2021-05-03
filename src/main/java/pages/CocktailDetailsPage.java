package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiters;

import java.time.Duration;

public class CocktailDetailsPage extends AbstractPage{

    @FindBy (css = ".row>h3")
    private WebElement ingredientSection;

    public CocktailDetailsPage() {
        super();
        waitForPageUrl();
    }

    public void waitForPageUrl() {
        new WebDriverWait(ProviderForDriver.getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.urlContains("yellowtailwine.com/recipe"));
    }

    public String getPageUrl(){
        return ProviderForDriver.getDriver().getCurrentUrl();
    }

    public WebElement getIngredientSection() {
        return ingredientSection;
    }

    @Override
    public void waitForLoadableElement(WebElement webElement){
        Waiters.waitForElementToBeVisible(webElement);
    }
}
