package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static WebDriver driver = new ChromeDriver();
    static void launch(){
        System.setProperty("webdriver/chrome/driver","drivers/chromedriver");
    }

}
