package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;
    @FindBy(css = ".skip-account .label")
    private WebElement accountButton;
    @FindBy(css = "[title='Log In']")
    private WebElement loginLink;
    @FindBy(id = "search")
    private WebElement searchField;
    @FindBy(css = "li[class='level0 nav-6'] a[class='level0 ']")
    private WebElement VipCategoryButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAccountButton() {
        accountButton.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void setSearchField(String searchValue) {
        searchField.clear();
        searchField.sendKeys(searchValue + Keys.ENTER);
    }

    public void clickVipCategoryButton() {
        VipCategoryButton.click();
    }

}
