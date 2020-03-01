package driverInstance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private Driver() {

    }
    public static String BaseAddress() {
        return "https://www.hepsiburada.com/";
    }

    public static WebDriver getChromeDriver(){
        if(driver==null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }
        return driver;
    }

    public static WebDriverWait getWebDriverWait(){
        if(wait==null){
            wait = new WebDriverWait(getChromeDriver(), 5);
        }
        return wait;
    }
}
