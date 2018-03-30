package firstTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.SetupHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FirstTestWithSelenium extends SetupHelper {
    @Test
    public void hardcodedBrowser() throws IOException, InterruptedException {
        WebDriver driver = browserUtil.startChrome();
        driver.get("http://www.google.com");
        TimeUnit.SECONDS.sleep(5);
        browserUtil.quit(driver);
    }

    @Test
    public void configurableBrowser() throws IOException, InterruptedException {
        WebDriver driver = browserUtil.startBrowser();
        driver.get("http://www.google.com");
        TimeUnit.SECONDS.sleep(5);
        browserUtil.quit(driver);
    }
}
