package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.Waiters;

public class WelcomePage extends AbstractPage{

    @FindBy(css = "[for=\"confirm\"]")
    private WebElement legalAgeCheck;
    @FindBy(css = "#agegate-selector-options")
    private WebElement regionDropBox;
    @FindBy(css = "[type=\"submit\"]")
    private WebElement welcomeButton;
    private Select selectElement;

    public WelcomePage() {
        super();
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
        //wait
        waitForLoadableElement(getLegalAgeCheck());
        legalAgeCheckClick();
        selectValueCountryDropBox("eu");
        welcomeButtonClick();
        return new MainPage();
    }

    @Override
    public void waitForLoadableElement(WebElement webElement){
        Waiters.waitForElementToBeVisible(webElement);
    }

    public WebElement getLegalAgeCheck(){ return legalAgeCheck; }

    public WebElement getRegionDropBox() { return regionDropBox; }

    public WebElement getWelcomeButton() {
        return welcomeButton;
    }
}