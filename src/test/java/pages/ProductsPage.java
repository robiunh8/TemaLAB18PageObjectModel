package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    private final WebDriver driver;


    @FindBy(css = "li:nth-of-type(1) > .product-info  a[title='View Details']")
    private WebElement ViewDetailOfProduct;

    @FindBy(css = "img[alt='Indigo']")
    private WebElement ColorButton;

    @FindBy(css = "a[id='swatch80'] span[class='swatch-label']")
    private WebElement SizeButton;

    @FindBy(css = "#qty")
    private WebElement quantityField;

    @FindBy(css = ".add-to-cart-buttons span:nth-of-type(1) span")
    private WebElement AddToCartButton;

    @FindBy(css = ".link-wishlist")
    private WebElement addToWishlistButton;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickViewDetailOfProduct() {
        ViewDetailOfProduct.click();
    }

    public void clickColorButton() {
        ColorButton.click();
    }

    public void clickSizeButton() {
        SizeButton.click();
    }

    public void setQuantityField(String value) {
        quantityField.sendKeys(value);
    }

    public void clickAddToCartButton() {
        AddToCartButton.click();
    }

    public void clickaddToWishlistButton() {
        addToWishlistButton.click();
    }

}
