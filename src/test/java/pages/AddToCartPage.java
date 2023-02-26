package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddToCartPage {

    private final WebDriver driver;

    @FindBy(css = "[title='Country']")
    private WebElement countryDropdownButton;

    @FindBy(css = ".required-entry.validate-select")
    private WebElement StateOrProvinceButton;

    @FindBy(css = "input#city")
    private WebElement CityField;

    @FindBy(css = "input#postcode")
    private WebElement PostalCodeZIP;

    @FindBy(css = "input#s_method_freeshipping_freeshipping")
    private WebElement FreeShippingOptionBox;

    @FindBy(css = "input#s_method_flatrate_flatrate")
    private WebElement FlatRateOptionBox;

    @FindBy(css = ".product-cart-actions > button[name='update_cart_action'] > span > span")
    private WebElement UpdateTotalButton;

    @FindBy(css = "li[class='method-checkout-cart-methods-onepage-bottom'] button[title='Proceed to Checkout'] span span")
    private WebElement ProceedToCheckoutButton;

    @FindBy(css = "li[class='success-msg'] ul li span")
    private WebElement addedToCartProductText;

    @FindBy(css = "[data-rwd-label] .input-text")
    private WebElement QualityOfProduct;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void setQualityOfProduct(String value) {
        QualityOfProduct.clear();
        QualityOfProduct.sendKeys(value);
    }

    public void clickCountryDropdownButton() {
        countryDropdownButton.click();
    }

    public void clickStateOrProvinceButton() {
        StateOrProvinceButton.click();
    }

    public void setCityField(String value) {
        CityField.clear();
        CityField.sendKeys(value);
    }

    public void setPostcodeZIP(String value) {
        PostalCodeZIP.clear();
        PostalCodeZIP.sendKeys(value);
    }

    public void clickFreeShippingOptionBox() {
        FreeShippingOptionBox.click();
    }

    public void clickFlatRateOptionBox() {
        FlatRateOptionBox.click();
    }

    public void clickUpdateTotalButton() {
        UpdateTotalButton.click();
    }

    public void clickProceedToCheckoutButton() {
        ProceedToCheckoutButton.click();
    }

    public String getProductWasAddedToCart() {
        return addedToCartProductText.getText();
    }

    public void selectCountry(String countryName) {
        Select select = new Select(countryDropdownButton);
        select.selectByVisibleText(countryName);
    }

    public void selectProvinceOrState(String provinceOrStatename) {
        Select select = new Select(StateOrProvinceButton);
        select.selectByVisibleText(provinceOrStatename);
    }

}
