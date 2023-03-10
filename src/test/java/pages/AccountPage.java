package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    private final WebDriver driver;

    @FindBy(css = ".hello > strong")
    private WebElement welcomeTextElement;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getWelcomeText() {
        return welcomeTextElement.getText();
    }


}
