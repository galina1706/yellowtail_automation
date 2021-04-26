package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePage {
    WebDriver driver;

    @FindBy(css = "[for=\"confirm\"]")
    private WebElement legalAgeCheck;
    @FindBy(css = "#agegate-selector-options")
    private WebElement dropDown;
    @FindBy(css = "[type=\"submit\"]")
    private WebElement welcomeButton;
    private Select selectCountryDropDown;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String elementGetText(WebElement element){
        return element.getText();
    }

    public void elementClick(WebElement element){
        element.click();
    }

    public MainPage switchToMainPage(){
        return new MainPage(driver);
    }

    public void selectValueCountryDropDown(Select selectElement, WebElement element, String input){
        selectElement = new Select(element);
        selectElement.selectByValue(input);
    }

    public void waitForElement(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitGeneral(){
        new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public WebElement getLegalAgeCheck(){ return legalAgeCheck; }

    public WebElement getDropDown() { return dropDown; }

    public WebElement getWelcomeButton() {
        return welcomeButton;
    }

    public Select getSelectCountryDropDown() { return selectCountryDropDown; }
}