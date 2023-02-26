package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {

    private final WebDriver driver;

    @FindBy(css = "li[class='success-msg'] ul li span")
    private WebElement addedToWishlistText;


    public WishlistPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getaddedToWishlistText() {
        return addedToWishlistText.getText();
    }


}


