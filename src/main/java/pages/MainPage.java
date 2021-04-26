package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;

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
    private WebElement chinaLanguage;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String elementGetText(WebElement element){
        return element.getText();
    }

    public void elementClick(WebElement element){
        element.click();
    }

    public ChineMainPage switchToChineMainPage(){
        return new ChineMainPage(driver);
    }

    public WhereToBuyPage switchToWhereToBuyPage(){
        return new WhereToBuyPage(driver);
    }

    public CocktailsPage switchToCocktailsPage(){
        return new CocktailsPage(driver);
    }

    public void waitForElement(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitGeneral(){
        new WebDriverWait(driver, Duration.ofSeconds(3));
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
        return chinaLanguage;
    }
}
