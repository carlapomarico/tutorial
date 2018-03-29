package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class TranslationsPage {
    @FindBy(how = How.CSS, using = "h3") public WebElement superheroElement;
    @FindBy(how = How.CSS, using = "td") public List<WebElement> superheroNames;
}
