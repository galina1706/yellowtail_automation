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
    private WebElement regionDropBox;
    @FindBy(css = "[type=\"submit\"]")
    private WebElement welcomeButton;
    private Select selectElement;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String legalAgeCheckGetText(){
        return legalAgeCheck.getText();
    }

    public void legalAgeCheckClick(){ legalAgeCheck.click(); }

    public void welcomeButtonClick(){ welcomeButton.click(); }

    public void selectValueCountryDropBox(String input){
        selectElement = new Select(regionDropBox);
        selectElement.selectByValue(input);
    }

    public MainPage navigateToMainPage(){
        getLegalAgeCheck();

        //wait
        waitForElement(getLegalAgeCheck());

        legalAgeCheckClick();
        selectValueCountryDropBox("eu");
        welcomeButtonClick();

        return new MainPage(driver);
    }

    public void waitForElement(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement getLegalAgeCheck(){ return legalAgeCheck; }

    public WebElement getRegionDropBox() { return regionDropBox; }

    public WebElement getWelcomeButton() {
        return welcomeButton;
    }
}