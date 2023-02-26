package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;
    @FindBy(css = "#email")
    private WebElement emailField;
    @FindBy(css = "#pass")
    private WebElement passwordField;
    @FindBy(css = "#send2")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setEmailField(String value) {
        emailField.sendKeys(value);
    }

    public void setPasswordFieldField(String value) {
        passwordField.sendKeys(value);
    }

    public void clickLoginButton() {
        loginButton.click();
    }


}
