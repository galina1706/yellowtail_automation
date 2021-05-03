package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiters;

import java.time.Duration;

public class MainPage extends AbstractPage{

    // page elements
    @FindBy(css=".-one .large-mobile")
    private WebElement welcomeLabel;
    @FindBy(css=".fa-bars")
    private WebElement menuButton;
    @FindBy(css=".-one>.home-button")
    private WebElement findYourWineButton;
    @FindBy(css=".primary-footer")
    private WebElement footer;
    @FindBy(css=".-one>h2")
    private WebElement welcomeToWorldYellowTailLabel;
    @FindBy(css=".-one>.header-sub-copy")
    private WebElement enjoyLabel;

    // menu elements
    @FindBy(css=".top-nav .yt-logo")
    private WebElement menuYellowTail;
    @FindBy(css=".main-nav [href*=\"wines\"]")
    private WebElement menuWines;
    @FindBy(css=".main-nav [href*=\"stores\"]")
    private WebElement menuWhereToBuy;
    @FindBy(css=".main-nav [href*=\"cocktails\"]")
    private WebElement menuCocktails;
    @FindBy(css=".main-nav [href*=\"our-story\"]")
    private WebElement menuOurStory;
    @FindBy(css=".main-nav [href*=\"faqs\"]")
    private WebElement menuFAQS;
    @FindBy(css=".main-nav [href*=\"contact\"]")
    private WebElement menuContact;
    @FindBy(css=".country-select span")
    private WebElement menuLanguage;
    @FindBy(css="[data-key=\"CN\"]")
    private WebElement menuChinaLanguage;

    public MainPage() {
        super();
    }

    public String welcomeLabelGetText(){
        return welcomeLabel.getText();
    }

    public void menuButtonClick(){
        menuButton.click();
    }

    public void menuYellowTailClick(){
        menuYellowTail.click();
    }

    public void menuLanguageClick(){
        menuLanguage.click();
    }

    public void menuChinaLanguageClick() { menuChinaLanguage.click(); }

    public void menuWhereToBuyClick() { menuWhereToBuy.click(); }

    public void menuCocktailsClick() { menuCocktails.click(); }

    public ChineMainPage navigateToChineMainPage(){
        //wait
        waitForLoadableElement(getMenuButton());
        menuButtonClick();

        //wait
        waitForLoadableElement(getMenuLanguage());
        menuLanguageClick();

        //wait
        waitForLoadableElement(getChinaLanguage());
        menuChinaLanguageClick();

        return new ChineMainPage();
    }

    public WhereToBuyPage navigateToWhereToBuyPage(){
        //wait
        waitForLoadableElement(getMenuButton());
        menuButtonClick();

        //wait
        waitForLoadableElement(getMenuWhereToBuy());
        menuWhereToBuyClick();

        return new WhereToBuyPage();
    }

    public CocktailsPage navigateToCocktailsPage() {
        //wait
        waitForLoadableElement(getMenuButton());
        menuButtonClick();

        //wait
        waitForLoadableElement(getMenuCocktails());
        menuCocktailsClick();

        return new CocktailsPage();
    }

    @Override
    public void waitForLoadableElement(WebElement webElement){
        Waiters.waitForElementToBeVisible(webElement);
    }

    public WebElement getWelcomeLabel() {
        return welcomeLabel;
    }

    public WebElement getMenuButton() {
        return menuButton;
    }

    public WebElement getFindYourWineButton() {
        return findYourWineButton;
    }

    public WebElement getFooter() {
        return footer;
    }

    public WebElement getWelcomeToWorldYellowTailLabel() {
        return welcomeToWorldYellowTailLabel;
    }

    public WebElement getEnjoyLabel() {
        return enjoyLabel;
    }

    public WebElement getMenuYellowTail() {
        return menuYellowTail;
    }

    public WebElement getMenuWines() {
        return menuWines;
    }

    public WebElement getMenuWhereToBuy() {
        return menuWhereToBuy;
    }

    public WebElement getMenuCocktails() {
        return menuCocktails;
    }

    public WebElement getMenuOurStory() {
        return menuOurStory;
    }

    public WebElement getMenuFAQS() {
        return menuFAQS;
    }

    public WebElement getMenuContact() {
        return menuContact;
    }

    public WebElement getMenuLanguage() {
        return menuLanguage;
    }

    public WebElement getChinaLanguage() {
        return menuChinaLanguage;
    }
}
