package Helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetup {

    public static WebDriver driver = null;

    public static WebDriver startBrowser(String browserChoice, String url) {

        if ("chrome".equalsIgnoreCase(browserChoice)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(chromeOptions);
        } else if ("firefox".equalsIgnoreCase(browserChoice)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--remote-allow-origins=*");
            driver = new EdgeDriver(edgeOptions);
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }



}
