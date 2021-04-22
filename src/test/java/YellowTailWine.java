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
    By legalAgeCheckSelector;
    WebElement legalAgeCheck;
    By selectDropDownSelector;
    WebElement dropDown;
    Select selectDropDown;
    By welcomeButtonSelector;
    WebElement welcomeButton;

    // "main" page elements
    By mainPageWelcomeLabelSelector;
    WebElement mainPageWelcomeLabel;
    By menuButtonSelector;
    WebElement menuButton;

    // menu elements
    By menuItem0Selector;
    WebElement menuItem0;
    By menuItem1Selector;
    WebElement menuItem1;
    By menuItem2Selector;
    WebElement menuItem2;
    By menuItem3Selector;
    WebElement menuItem3;
    By menuItem4Selector;
    WebElement menuItem4;
    By menuItem5Selector;
    WebElement menuItem5;
    By menuItem6Selector;
    WebElement menuItem6;
    By menuItem7Selector;
    WebElement menuItem7;

    // "where to buy" page elements
    By fieldLocationSelector;
    WebElement fieldLocation;
    By searchButtonSelector;
    WebElement searchButton;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    public void welcomePageElements(){
        legalAgeCheckSelector = By.cssSelector("label[for=\"confirm\"]");
        legalAgeCheck = driver.findElement(legalAgeCheckSelector);
        selectDropDownSelector = By.cssSelector("#agegate-selector-options");
        dropDown = driver.findElement(selectDropDownSelector);
        selectDropDown = new Select(driver.findElement(selectDropDownSelector));
        welcomeButtonSelector = By.cssSelector("input[type=\"submit\"]");
        welcomeButton = driver.findElement(welcomeButtonSelector);
    }

    public void mainPageElements(){
        mainPageWelcomeLabelSelector = By.cssSelector("div.content.animation-screen.-one>h2>span.large-mobile");
        mainPageWelcomeLabel = driver.findElement(mainPageWelcomeLabelSelector);
        menuButtonSelector = By.cssSelector("i.fa.fa-bars>span");
        menuButton = driver.findElement(menuButtonSelector);
    }

    public void menuElements(){
        menuItem0Selector = By.cssSelector("div.top-nav.-active>div.main-nav>div>div>a>img");
        menuItem0 = driver.findElement(menuItem0Selector);
        menuItem1Selector = By.cssSelector("div.main-nav li:nth-child(1)");
        menuItem1 = driver.findElement(menuItem1Selector);
        menuItem2Selector = By.cssSelector("div.main-nav li:nth-child(2)");
        menuItem2 = driver.findElement(menuItem2Selector);
        menuItem3Selector = By.cssSelector("div.main-nav li:nth-child(3)");
        menuItem3 = driver.findElement(menuItem3Selector);
        menuItem4Selector = By.cssSelector("div.main-nav li:nth-child(4)");
        menuItem4 = driver.findElement(menuItem4Selector);
        menuItem5Selector = By.cssSelector("div.main-nav li:nth-child(5)");
        menuItem5 = driver.findElement(menuItem5Selector);
        menuItem6Selector = By.cssSelector("div.main-nav li:nth-child(6)");
        menuItem6 = driver.findElement(menuItem6Selector);
        menuItem7Selector = By.cssSelector("#country-select>a>span");
        menuItem7 = driver.findElement(menuItem7Selector);
    }

    public void whereToBuyElements(){
        fieldLocationSelector = By.cssSelector("#locationName");
        fieldLocation = driver.findElement(fieldLocationSelector);
        searchButtonSelector = By.cssSelector("button.search-submit");
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
        driver.get("https://www.yellowtailwine.com/");
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
        driver.get("https://www.yellowtailwine.com/");
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
        driver.get("https://www.yellowtailwine.com/");
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

        Assertions.assertTrue(menuItem0.isDisplayed(), "case 4, menu item 0 issue");
        Assertions.assertTrue(menuItem1.getText().contains("Wines".toUpperCase()), "case 4, menu item 1 issue");
        Assertions.assertTrue(menuItem2.getText().contains("Where To Buy".toUpperCase()), "case 4, menu item 2 issue");
        Assertions.assertTrue(menuItem3.getText().contains("Cocktails".toUpperCase()), "case 4, menu item 3 issue");
        Assertions.assertTrue(menuItem4.getText().contains("Our Story".toUpperCase()), "case 4, menu item 4 issue");
        Assertions.assertTrue(menuItem5.getText().contains("FAQs".toUpperCase()), "case 4, menu item 5 issue");
        Assertions.assertTrue(menuItem6.getText().contains("Contact".toUpperCase()),"case 4, menu item 6 issue");
        Assertions.assertTrue(menuItem7.isDisplayed(), "case 4, menu item 7 issue");

        menuItem0.click();
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
        driver.get("https://www.yellowtailwine.com/");
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
        menuItem0.click();
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
        driver.get("https://www.yellowtailwine.com/");
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
        menuItem2.click();
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
            Assertions.assertTrue(item.getText().contains("Sydney NSW 2000"), "case 8, details of arch results are false");
        }
    }
}
