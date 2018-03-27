package firstTests;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;
import utils.BrowserUtil;
import utils.SetupHelper;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FirstTestWithSelenium extends SetupHelper{
    @Value("${homepageurl}") private String homepageUrl;

    @Test
    public void firstTest() throws IOException, InterruptedException {
        System.out.println("homepageUrl = " + homepageUrl);
        BrowserUtil browserUtil = new BrowserUtil();
        WebDriver driver = browserUtil.startBrowser();
        driver.get(new File(homepageUrl).getAbsolutePath());
        TimeUnit.SECONDS.sleep(5);
        browserUtil.quit(driver);
    }
}
