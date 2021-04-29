package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CocktailDetailsPage {
    WebDriver driver;

    @FindBy (css = ".row>h3")
    private WebElement ingredientSection;

    public CocktailDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public WebElement getIngredientSection() {
        return ingredientSection;
    }

    public void waitGeneral(){
        new WebDriverWait(driver, Duration.ofSeconds(3));
    }

}
