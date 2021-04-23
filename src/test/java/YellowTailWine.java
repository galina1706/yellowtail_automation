import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    Select selectCountryDropDown;
    WebElement welcomeButton;

    // "main" page elements
    WebElement welcomeLabel;
    WebElement menuButton;
    WebElement welcomeToWineWorldLabel;
    WebElement findYourWineButton;
    WebElement enjoyStringElement;
    WebElement footer;

    // Menu elements
    WebElement menuYellowTail;
    WebElement menuWines;
    WebElement menuWhereToBuy;
    WebElement menuCocktails;
    WebElement menuOurStory;
    WebElement menuFAQS;
    WebElement menuContact;
    WebElement menuLanguage;
    WebElement chinaLanguage;

    // main page China elements
    WebElement welcomeLabelChina;
    WebElement weiboIcon;

    // "where to buy" page elements
    WebElement fieldLocation;
    WebElement searchButton;

    // cocktails page elements
    WebElement selectCocktailsDropDown;
    WebElement redCocktail;
    WebElement sparklingWineCocktails;
    WebElement typeTextField;
    WebElement raspberryRoseRecipe;

    // cocktail recipe details page elements
    WebElement ingredientsSection;

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
        By selectCountryDropDownSelector = By.cssSelector("#agegate-selector-options");
        dropDown = driver.findElement(selectCountryDropDownSelector);
        selectCountryDropDown = new Select(driver.findElement(selectCountryDropDownSelector));
        By welcomeButtonSelector = By.cssSelector("[type=\"submit\"]");
        welcomeButton = driver.findElement(welcomeButtonSelector);
    }

    public void mainPageElements(){
        By welcomeLabelSelector = By.cssSelector(".-one .large-mobile");
        welcomeLabel = driver.findElement(welcomeLabelSelector);
        By menuButtonSelector = By.cssSelector(".fa-bars");
        menuButton = driver.findElement(menuButtonSelector);
        By mainPageWelcomeToWineWorldLabelSelector = By.cssSelector(".-one>h2");
        welcomeToWineWorldLabel = driver.findElement(mainPageWelcomeToWineWorldLabelSelector);
        By findYourWineButtonSelector = By.cssSelector(".home-button");
        findYourWineButton = driver.findElement(findYourWineButtonSelector);
        By enjoyStringElementSelector = By.cssSelector(".-one>.header-sub-copy");
        enjoyStringElement = driver.findElement(enjoyStringElementSelector);
        By footerSelector = By.cssSelector("#primary-footer");
        footer = driver.findElement(footerSelector);
        By chinaLanguageSelector = By.cssSelector("[data-key=\"CN\"]");
        chinaLanguage = driver.findElement(chinaLanguageSelector);
    }

    public void mainPageChinaElements(){
        By welcomeLabelChinaSelector = By.cssSelector(".heading-editable>font:first-child");
        welcomeLabelChina = driver.findElement(welcomeLabelChinaSelector);
        By weiboIconSelector = By.cssSelector(".sgg-comp-social-icon>.fa-weibo");
        weiboIcon = driver.findElement(weiboIconSelector);
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

    public void whereToBuyPageElements(){
        By fieldLocationSelector = By.cssSelector("#locationName");
        fieldLocation = driver.findElement(fieldLocationSelector);
        By searchButtonSelector = By.cssSelector(".search-submit");
        searchButton = driver.findElement(searchButtonSelector);
    }

    public void cocktailsPageElements(){
        By selectCocktailDropDownSelector = By.cssSelector(".selected");
        selectCocktailsDropDown = driver.findElement(selectCocktailDropDownSelector);
        By redCocktailSelector = By.cssSelector("[data-value=\"red\"]");
        redCocktail = driver.findElement(redCocktailSelector);
        By sparklingWineCocktailsSelector = By.cssSelector("[data-value=\"bubbles\"]");
        sparklingWineCocktails = driver.findElement(sparklingWineCocktailsSelector);
        By typeTextFieldSelector = By.cssSelector(".selected>span");
        typeTextField = driver.findElement(typeTextFieldSelector);
        By raspberryRoseRecipeSelector = By.cssSelector("[href=\"raspberry-rose\"]");
        raspberryRoseRecipe = driver.findElement(raspberryRoseRecipeSelector);
    }

    public void cocktailRecipePageElements(){
        By ingredientsSectionSelector = By.cssSelector(".row>h3");
        ingredientsSection = driver.findElement(ingredientsSectionSelector);
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
        Thread.sleep(1000);
        selectCountryDropDown.selectByValue("eu");
        welcomeButton.click();
        Thread.sleep(1000);
        mainPageElements();
        Thread.sleep(1000);

        //Assertions.assertTrue(mainPageWelcomeLabel.getText().contains("Welcome".toUpperCase()), "case 2, Welcome label on main page is not appears");
        Assertions.assertEquals("Welcome".toUpperCase(), welcomeLabel.getText(), "case 2, Welcome label on main page is not appears");
    }

    @Test
    //Case 3: Main page: all required elements are displayed
    //1. Navigate to main page
    //2. Verify that the following elements are displayed:
    //   - menu button
    //   - WELCOME TO THE WORLD OF [Yellow tail]
    //   - We are passionate about creating great tasting, quality wines for everyone to enjoy
    //   - find your wine button
    //   - footer
    public void mainPageElementsDisplayed() throws InterruptedException {
        welcomePageElements();
        legalAgeCheck.click();
        Thread.sleep(1000);
        selectCountryDropDown.selectByValue("eu");
        welcomeButton.click();
        Thread.sleep(1000);
        mainPageElements();
        Thread.sleep(1000);

        Assertions.assertTrue(menuButton.isDisplayed(), "case 3, menu button on main page is not displayed");
        String welcomeToWineWorldString = "WELCOME TO THE WORLD OF\n" + "[YELLOW TAIL]";
        Assertions.assertEquals(welcomeToWineWorldString, welcomeToWineWorldLabel.getText(), "case 3, welcome string is not dispalyed");
        String enjoyString= "We are passionate about creating great tasting, quality wines for everyone to enjoy";
        Assertions.assertEquals(enjoyString, enjoyStringElement.getText(), "case 3, enjoy string is not displayed");
        Assertions.assertTrue(findYourWineButton.isDisplayed(), "case 3, find your wine button on main page is not displayed");
        Assertions.assertTrue(footer.isEnabled(), "case 3, footer is not displayed");
    }

    @Test
    //Case 4: Main page: Menu button logic (open header)
    //1. Navigate to main page
    //2. Click on Menu button
    //3. Verify that header with all needed links is appeared
    //4. Click on [yellow tail]
    //5. Verify that Menu button is visible
    public void menuButtonLogicOpenHeader() throws InterruptedException {
        welcomePageElements();
        legalAgeCheck.click();
        Thread.sleep(1000);
        selectCountryDropDown.selectByValue("eu");
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
        welcomePageElements();
        legalAgeCheck.click();
        Thread.sleep(1000);
        selectCountryDropDown.selectByValue("eu");
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
    //Case 6: Main page: Global Nav logic
    //1. Navigate to main page
    //2. Click on Menu button
    //3. Click on Globe icon
    //4. Select China in popup and click on it
    //5. Verify that language is changed
    public void globalNavigationLogic() throws InterruptedException {
        welcomePageElements();
        legalAgeCheck.click();
        Thread.sleep(1000);
        selectCountryDropDown.selectByValue("eu");
        welcomeButton.click();
        Thread.sleep(1000);
        mainPageElements();
        Thread.sleep(1000);
        menuButton.click();
        Thread.sleep(1000);
        menuElements();
        Thread.sleep(1000);
        menuLanguage.click();
        Thread.sleep(1000);
        chinaLanguage.click();
        mainPageChinaElements();

        Assertions.assertEquals("欢迎来到", welcomeLabelChina.getText(), "case 6, Welcome label on main page is not appears");
    }

    @Test
    //Case 7: Main page: Global Nav logic (CHINA - separate site is open)
    //1. Navigate to main page
    //2. Click on Menu button
    //3. Click on Globe icon
    //4. Select China in popup and click on it
    //5. Click on icon ( in white square on screenshot)
    //6. Verify that “https://www.weibo.com/yellowtailChina” site is open in new tab
    public void chineSiteOpen() throws InterruptedException {
        welcomePageElements();
        legalAgeCheck.click();
        Thread.sleep(1000);
        selectCountryDropDown.selectByValue("eu");
        welcomeButton.click();
        Thread.sleep(1000);
        mainPageElements();
        Thread.sleep(1000);
        menuButton.click();
        Thread.sleep(1000);
        menuElements();
        Thread.sleep(1000);
        menuLanguage.click();
        Thread.sleep(1000);
        chinaLanguage.click();
        mainPageChinaElements();
        weiboIcon.click();
        Thread.sleep(3000);

        int windowsCount = driver.getWindowHandles().size();
        if (windowsCount > 1){
            for (String winHandle: driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }
        }
        Thread.sleep(10000);
        String yellowTailChinaUrl = driver.getCurrentUrl();

        Assertions.assertEquals("https://weibo.com/yellowtailChina", yellowTailChinaUrl, "case 7, Welcome label on main page is not appears");
    }

    @Test
    //Case 8: Where to buy: enter valid postal code
    //1. Navigate to “Where to buy” page
    //2. Enter valid data in “Your location” field
    //3. Click on Search button
    //4. Verify that the results of search are displayed
    public void whereToBuyValidPostalCode() throws InterruptedException {
        welcomePageElements();
        legalAgeCheck.click();
        Thread.sleep(1000);
        selectCountryDropDown.selectByValue("eu");
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
        whereToBuyPageElements();
        Thread.sleep(1000);
        fieldLocation.click();
        fieldLocation.sendKeys("Sydney NSW 2000");
        searchButton.click();

        By searchResultsSelector1 = By.cssSelector("h4");
        List<WebElement> searchResults1 = driver.findElements(searchResultsSelector1);
        for (WebElement item : searchResults1) {
            Assertions.assertTrue(item.getText().contains("Sydney"), "case 8, headers of search results are false");
        }
        By searchResultSelector2 = By.cssSelector("div.address");
        List<WebElement> searchResults2 = driver.findElements(searchResultSelector2);
        for (WebElement item : searchResults2) {
            Assertions.assertTrue(item.getText().contains("Sydney NSW 2000"), "case 8, details of search results are false");
        }
    }

        @Test
        //Case 9: Cocktails: Select one wine
        //1. Navigate to “Cocktails” page
        //2. Select “Red wine cocktails”
        //3. Verify that 7 recipes are displayed
        public void cocktailsRecipes() throws InterruptedException {
            welcomePageElements();
            legalAgeCheck.click();
            Thread.sleep(1000);
            selectCountryDropDown.selectByValue("eu");
            welcomeButton.click();
            Thread.sleep(1000);
            mainPageElements();
            Thread.sleep(1000);
            menuButton.click();
            Thread.sleep(1000);
            menuElements();
            Thread.sleep(1000);
            menuCocktails.click();
            Thread.sleep(1000);
            cocktailsPageElements();
            selectCocktailsDropDown.click();
            Thread.sleep(1000);
            redCocktail.click();

            By searchResultsSelector = By.xpath("//div[@class=\"tile recipe-tile\"]");
            List<WebElement> searchResults = driver.findElements(searchResultsSelector);
            int searchResultsCount = searchResults.size();
            Assertions.assertEquals(7, searchResultsCount, "case 9, count of red cocktails is incorrect");
        }

        @Test
        //Case 10: Cocktails: Navigate to Cocktail recipe page
        //1. Navigate to “Cocktails” page
        //2. Scroll to “RASPBERRY ROSÉ” recipe
        //3. Click on “RASPBERRY ROSÉ” recipe
        //4. Verify that new page is displayed:
        //- ingredients section is displayed
        public void cocktailsDetails() throws InterruptedException {
            welcomePageElements();
            legalAgeCheck.click();
            Thread.sleep(1000);
            selectCountryDropDown.selectByValue("eu");
            welcomeButton.click();
            Thread.sleep(1000);
            mainPageElements();
            Thread.sleep(1000);
            menuButton.click();
            Thread.sleep(1000);
            menuElements();
            Thread.sleep(1000);
            menuCocktails.click();
            Thread.sleep(1000);
            cocktailsPageElements();
            Thread.sleep(1000);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", raspberryRoseRecipe);
            Thread.sleep(1000);
            raspberryRoseRecipe.click();
            Thread.sleep(3000);
            int windowsCount = driver.getWindowHandles().size();
                if (windowsCount > 1){
                    for (String winHandle: driver.getWindowHandles()){
                        driver.switchTo().window(winHandle);
                    }
                }
            String raspberryRoseRecipePageUlr = driver.getCurrentUrl();
            Assertions.assertEquals("https://www.yellowtailwine.com/recipe/raspberry-rose/", raspberryRoseRecipePageUlr, "case 10, Welcome label on main page is not appears");
            cocktailRecipePageElements();
            Assertions.assertTrue(ingredientsSection.isDisplayed());
        }

        @Test
        //Case 11: Cocktails: Select several wines
        //1. Navigate to “Cocktails” page
        //2. Select “Red wine cocktails”
        //3. Select “Sparkling wine cocktails”
        //4. Verify that “Multiple” word is displayed in “Type” dropdown
        //5. Verify that 18 recipes are displayed
        public void cocktailsSeveralWines() throws InterruptedException {
            welcomePageElements();
            legalAgeCheck.click();
            Thread.sleep(1000);
            selectCountryDropDown.selectByValue("eu");
            welcomeButton.click();
            Thread.sleep(1000);
            mainPageElements();
            Thread.sleep(1000);
            menuButton.click();
            Thread.sleep(1000);
            menuElements();
            Thread.sleep(1000);
            menuCocktails.click();
            Thread.sleep(1000);
            cocktailsPageElements();
            selectCocktailsDropDown.click();
            Thread.sleep(1000);
            redCocktail.click();
            sparklingWineCocktails.click();

            Assertions.assertTrue(typeTextField.getText().equals("Multiple"));

            By searchResultsSelector = By.xpath("//div[@class=\"tile recipe-tile\"]");
            List<WebElement> searchResults = driver.findElements(searchResultsSelector);
            int searchResultsCount = searchResults.size();
            Assertions.assertEquals(18, searchResultsCount, "case 11, count of sparkling cocktails is incorrect");
        }
    }
