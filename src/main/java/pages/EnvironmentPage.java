package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.CSS;

public class EnvironmentPage {
    @FindBy(how = CSS, using = "#addMe") public WebElement addMeField;
    @FindBy(how = CSS, using = ".w3-btn") public WebElement addMeButton;
    @FindBy(how = CSS, using = ".successMessage") public WebElement successMessage;
}
