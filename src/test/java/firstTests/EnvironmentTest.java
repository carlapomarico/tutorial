package firstTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EnvironmentPage;
import utils.SetupHelper;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class EnvironmentTest extends SetupHelper {
    @Value("${homepageurl}") private String homepageUrl;
    @Value("${tobeadded}") private String toBeAdded;
    private EnvironmentPage page;
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = browserUtil.startBrowser();
        page = PageFactory.initElements(driver, EnvironmentPage.class);
    }

    @AfterClass
    public void afterClass() throws IOException {
        browserUtil.quit(driver);
    }

    @Test
    public void configurableBrowser() {
        System.out.println("homepageUrl = " + homepageUrl);
        driver.get(new File(homepageUrl).getAbsolutePath());
        page.addMeField.sendKeys(toBeAdded);
        page.addMeButton.click();
        assertEquals(page.successMessage.getText(), "Success!");
    }
}
