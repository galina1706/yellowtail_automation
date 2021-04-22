import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class YellowTailWine {
    static WebDriver driver;
    // "welcome" page elements
    WebElement legalAgeCheck;
    WebElement dropDown;
    Select selectDropDown;
    WebElement welcomeButton;
    // "main" page elements
    WebElement mainPageWelcomeLabel;
    WebElement menuButton;
    // Menu elements
    WebElement menuYellowTail;
    WebElement menuWines;
    WebElement menuWhereToBuy;
    WebElement menuCocktails;
    WebElement menuOurStory;
    WebElement menuFAQS;
    WebElement menuContact;
    WebElement menuLanguage;
    // "where to buy" page elements
    WebElement fieldLocation;
    WebElement searchButton;
    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.yellowtailwine.com/");
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    public void welcomePageElements(){
        By legalAgeCheckSelector = By.cssSelector("[for=\"confirm\"]");
        legalAgeCheck = driver.findElement(legalAgeCheckSelector);
        By selectDropDownSelector = By.cssSelector("#agegate-selector-options");
        dropDown = driver.findElement(selectDropDownSelector);
        selectDropDown = new Select(driver.findElement(selectDropDownSelector));
        By welcomeButtonSelector = By.cssSelector("[type=\"submit\"]");
        welcomeButton = driver.findElement(welcomeButtonSelector);
    }

    public void mainPageElements(){
        By mainPageWelcomeLabelSelector = By.cssSelector(".-one .large-mobile");
        mainPageWelcomeLabel = driver.findElement(mainPageWelcomeLabelSelector);
        By menuButtonSelector = By.cssSelector(".fa-bars");
        menuButton = driver.findElement(menuButtonSelector);
    }

    public void menuElements(){
        By menuYellowTailSelector = By.cssSelector(".top-nav .yt-logo");
        menuYellowTail = driver.findElement(menuYellowTailSelector);
        By menuWinesSelector = By.cssSelector(".main-nav [href*=\"wines\"]");
        menuWines = driver.findElement(menuWinesSelector);
        By menuWhereToBuySelector = By.cssSelector(".main-nav [href*=\"stores\"]");
        menuWhereToBuy = driver.findElement(menuWhereToBuySelector);
        By menuCocktailsSelector = By.cssSelector(".main-nav [href*=\"cocktails\"]");
        menuCocktails = driver.findElement(menuCocktailsSelector);
        By menuOurStorySelector = By.cssSelector(".main-nav [href*=\"our-story\"]");
        menuOurStory = driver.findElement(menuOurStorySelector);
        By menuFAQSSelector = By.cssSelector(".main-nav [href*=\"faqs\"]");
        menuFAQS = driver.findElement(menuFAQSSelector);
        By menuContactSelector = By.cssSelector(".main-nav [href*=\"contact\"]");
        menuContact = driver.findElement(menuContactSelector);
        By menuLanguageSelector = By.cssSelector(".country-select span");
        menuLanguage = driver.findElement(menuLanguageSelector);
    }

    public void whereToBuyElements(){
        By fieldLocationSelector = By.cssSelector("#locationName");
        fieldLocation = driver.findElement(fieldLocationSelector);
        By searchButtonSelector = By.cssSelector(".search-submit");
        searchButton = driver.findElement(searchButtonSelector);
    }

    @Test
    //Case 1: Welcome page: all required elements are displayed
    //1. Go to Welcome page: https://www.yellowtailwine.com
    //2. Verify that “I am of legal drinking age in” is displayed
    //3. Verify that checkbox before “I am of legal drinking age in” is displayed
    //4. Verify that dropdown with Select is displayed
    //5. Verify that “Welcome” button is displayed and is inactive
    public void welcomePageElementsDisplayed(){
        welcomePageElements();
        Assertions.assertEquals("I am of legal drinking age in", legalAgeCheck.getText(), "case 1, legalAgeLabel does not have expected text");
        Assertions.assertTrue(legalAgeCheck.isDisplayed(), "case 1, legalAgeCheck is not displayed");
        Assertions.assertTrue(dropDown.isDisplayed(), "case 1, selectDropDown is not displayed");
        Assertions.assertTrue(welcomeButton.isDisplayed(), "case 1, welcomeButton is not displayed");
        Assertions.assertFalse(welcomeButton.isEnabled(), "case 1, welcomeButton should be disabled but it is enabled");
    }

    @Test
    //Case 2: Main page: navigate to main page as European customer
    //1. Tick on checkbox
    //2. Select “Europe” from dropbox
    //3. Press “Welcome” button
    //4. Main page should be displayed
    public void mainPageDisplayed() throws InterruptedException {
        welcomePageElements();
        legalAgeCheck.click();
        welcomeButton.click();
        mainPageElements();

        //Assertions.assertTrue(mainPageWelcomeLabel.getText().contains("Welcome".toUpperCase()), "case 2, Welcome label on main page is not appears");
        Assertions.assertEquals("Welcome".toUpperCase(), mainPageWelcomeLabel.getText(), "case 2, Welcome label on main page is not appears");
    }

    @Test
    //Case 4: Main page: Menu button logic (open header)
    //1. Navigate to main page
    //2. Click on Menu button
    //3. Verify that header with all needed links is appeared
    //4. Click on [yellow tail]
    //5. Verify that Menu button is visible
    public void menuButtonLogicOpenHeader() throws InterruptedException {
        Thread.sleep(1000);
        welcomePageElements();
        Thread.sleep(1000);
        legalAgeCheck.click();
        selectDropDown.selectByValue("eu");
        welcomeButton.click();
        Thread.sleep(1000);
        mainPageElements();
        Thread.sleep(1000);
        menuButton.click();
        Thread.sleep(1000);
        menuElements();
        Thread.sleep(1000);

        Assertions.assertTrue(menuYellowTail.isDisplayed(), "case 4, menu item Yellow Tail issue");
        Assertions.assertTrue(menuWines.getText().contains("Wines".toUpperCase()), "case 4, menu item Wines issue");
        Assertions.assertTrue(menuWhereToBuy.getText().contains("Where To Buy".toUpperCase()), "case 4, menu item Where To Buy issue");
        Assertions.assertTrue(menuCocktails.getText().contains("Cocktails".toUpperCase()), "case 4, menu item Cocktails issue");
        Assertions.assertTrue(menuOurStory.getText().contains("Our Story".toUpperCase()), "case 4, menu item Our Story issue");
        Assertions.assertTrue(menuFAQS.getText().contains("FAQs".toUpperCase()), "case 4, menu item FAQs issue");
        Assertions.assertTrue(menuContact.getText().contains("Contact".toUpperCase()),"case 4, menu item Contacts issue");
        Assertions.assertTrue(menuLanguage.isDisplayed(), "case 4, menu item Language issue");

        menuYellowTail.click();
        mainPageElements();

        Assertions.assertTrue(menuButton.isDisplayed(), "menu button issue");
    }

    @Test
    //Case 5: Main page: Menu button logic (close header)
    //1. Navigate to main page
    //2. Click on Menu button
    //3. Click on [yellow tail]
    //4. Verify that Menu button is visible
    public void menuButtonLogicCloseHeader() throws InterruptedException {
        Thread.sleep(1000);
        welcomePageElements();
        Thread.sleep(1000);
        legalAgeCheck.click();
        selectDropDown.selectByValue("eu");
        welcomeButton.click();
        Thread.sleep(1000);
        mainPageElements();
        Thread.sleep(1000);
        menuButton.click();
        Thread.sleep(1000);
        menuElements();
        Thread.sleep(1000);
        menuYellowTail.click();
        mainPageElements();

        Assertions.assertTrue(menuButton.isDisplayed(), "case 5, menu button issue");
    }

    @Test
    //Case 8: Where to buy: enter valid postal code
    //1. Navigate to “Where to buy” page
    //2. Enter valid data in “Your location” field
    //3. Click on Search button
    //4. Verify that the results of search are displayed
    public void whereToBuyValidPostalCode() throws InterruptedException {
        welcomePageElements();
        Thread.sleep(1000);
        legalAgeCheck.click();
        selectDropDown.selectByValue("eu");
        welcomeButton.click();
        Thread.sleep(1000);
        mainPageElements();
        Thread.sleep(1000);
        menuButton.click();
        Thread.sleep(1000);
        menuElements();
        Thread.sleep(1000);
        menuWhereToBuy.click();
        Thread.sleep(1000);
        whereToBuyElements();
        Thread.sleep(1000);
        fieldLocation.click();
        fieldLocation.sendKeys("Sydney NSW 2000");
        searchButton.click();

        By searchResultsSelector1 = By.cssSelector("h4");
        List<WebElement> searchResults1 = driver.findElements(searchResultsSelector1);
        for (WebElement item: searchResults1){
            Assertions.assertTrue(item.getText().contains("Sydney"), "case 8, headers of search results are false");
        }
        By searchResultSelector2 = By.cssSelector("div.address");
        List<WebElement> searchResults2 = driver.findElements(searchResultSelector2);
        for (WebElement item: searchResults2){
            Assertions.assertTrue(item.getText().contains("Sydney NSW 2000"), "case 8, details of search results are false");
        }
    }
}
