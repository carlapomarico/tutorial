package translations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TranslationsPage;
import utils.SetupHelper;
import utils.TranslationsHelper;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class TranslationsTest extends SetupHelper {
    @Value("${german.site}") private String germanSiteUrl;
    @Value("${english.site}") private String englishSiteUrl;
    @Value("${spanish.site}") private String spanishSiteUrl;
    @Value("${norwegian.site}") private String norwegianSiteUrl;

    private TranslationsHelper translationsHelper = new TranslationsHelper();

    private WebDriver driver;
    private TranslationsPage page;

    @BeforeClass
    public void beforeClass() {
        driver = browserUtil.startBrowser();
        page = PageFactory.initElements(driver, TranslationsPage.class);
    }

    @AfterClass
    public void afterClass() throws IOException {
        browserUtil.quit(driver);
    }

    @Test
    public void germanSite() throws IOException {
        driver.get(new File(germanSiteUrl).getAbsolutePath());
        assertEquals(page.superheroElement.getText(), translationsHelper.getTranslation("superhero", "de"));
        assertEquals(page.superheroNames.get(0).getText(), translationsHelper.getTranslation("superhero.firstname", "de"));
        assertEquals(page.superheroNames.get(1).getText(), translationsHelper.getTranslation("superhero.lastname", "de"));
    }

    @Test(dataProvider = "languages")
    public void allSites(String url, String language) throws IOException {
        driver.get(new File(url).getAbsolutePath());
        assertEquals(page.superheroElement.getText(), translationsHelper.getTranslation("superhero", language));
        assertEquals(page.superheroNames.get(0).getText(), translationsHelper.getTranslation("superhero.firstname",
                language));
        assertEquals(page.superheroNames.get(1).getText(), translationsHelper.getTranslation("superhero.lastname",
                language));
    }

    @DataProvider(name = "languages")
    public Object[][] languages() {
        return new Object[][]{
                {englishSiteUrl, "en"},
                {germanSiteUrl, "de"},
                {spanishSiteUrl, "es"},
                {norwegianSiteUrl, "no"}
        };}

}
