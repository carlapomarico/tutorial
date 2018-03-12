package utils;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static java.lang.System.setProperty;

@Component
public class BrowserUtil {
    @Autowired
    private Environment environment;

    public WebDriver startFirefox() {
        setProperty("webdriver.gecko.driver", "src/test/resources/browsers/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver();
        maximize(driver);
        System.out.println("\n---------------- FIREFOX has started! -------------------\n");
        return driver;
    }

    public WebDriver startChrome() {
        if (SystemUtils.IS_OS_WINDOWS) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browsers/chromedriver.exe");
        }
        if (SystemUtils.IS_OS_LINUX) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browsers/chromedriver");
        }
        WebDriver driver = new ChromeDriver();
        maximize(driver);
        System.out.println("\n--------------- CHROME has started! ------------------\n");
        return driver;
    }

    public WebDriver startInternetExplorer() {
        setProperty("webdriver.ie.driver", "src/test/resources/browsers/IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        maximize(driver);
        System.out.println("\n----------- INTERNET EXPLORER has started! --------------\n");
        return driver;
    }

    public WebDriver startBrowser() {
        switch (environment.getProperty("browser").toLowerCase()) {
            case "chrome":
                return startChrome();
            case "firefox":
                return startFirefox();
            case "ie":
                return startInternetExplorer();
            default:
                System.out.println("THERE WAS AN ERROR READING THE BROWSER CONFIGURATION! CHROME WILL START BY " +
                        "DEFAULT!");
                return startChrome();
        }
    }

    public WebDriver startBrowserCustomSize(int width, int height) {
        setProperty("webdriver.chrome.driver", "src/test/resources/browsers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(width, height));
        System.out.println("\n--------------- CHROME has started in CUSTOM size! ------------------\n");
        return driver;
    }

    private void maximize(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void quit(WebDriver driver) throws IOException {
        if (driver.getClass().equals(InternetExplorerDriver.class)) {
            Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
        } else
            driver.quit();

    }
}
