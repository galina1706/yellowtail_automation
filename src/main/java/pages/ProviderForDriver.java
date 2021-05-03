package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constants;
public class ProviderForDriver {
    static WebDriver driver;

    private static WebDriver createDriver() {
        System.setProperty(Constants.SYSTEM_PROPERTY_CHROME_DRIVE, Constants.PATH_TO_CHROME_DRIVER);
        return new ChromeDriver();
    }

    public static WebDriver getDriver(){
        if (driver == null){
            driver = createDriver();
        }
        return driver;
    }

    public static void setDriverNull(){
        driver = null;
    }
}
