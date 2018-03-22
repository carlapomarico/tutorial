package firstSteps;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import utils.BrowserUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@ContextConfiguration("/application-context.xml")
public class FirstTestWithSelenium extends AbstractTestNGSpringContextTests{
    @Value("${homepageurl}") private String homepageUrl;

    @Test
    public void a() throws IOException, InterruptedException {
        System.out.println("homepageUrl = " + homepageUrl);
        BrowserUtil browserUtil = new BrowserUtil();
        WebDriver driver = browserUtil.startBrowser();
        driver.get("http://www.google.com");
        driver.get(new File(homepageUrl).getAbsolutePath());
        TimeUnit.SECONDS.sleep(5);
        browserUtil.quit(driver);
    }
}
