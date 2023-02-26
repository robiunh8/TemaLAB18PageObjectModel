package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private final WebDriver driver;


    @FindBy(css = "[for='login\\:register']")
    private WebElement registerAndCheckoutButton;

    @FindBy(css = "[onclick='checkout\\.setMethod\\(\\)\\;']")
    private WebElement continueButton;

    @FindBy(css = "input#billing\\:use_for_shipping_yes")
    private WebElement ShipToCurrentAdressButton;

    @FindBy(css = "div#billing-buttons-container > button > span > span")
    private WebElement continueBillingInfoButton;

    @FindBy(css = "label[for='s_method_flatrate_flatrate']")
    private WebElement shippingMethodFlatRateButton;

    @FindBy(css = "button[onclick='shippingMethod.save()']")
    private WebElement continueButtonShippingMethod;

    @FindBy(css = "button[onclick='payment.save()']")
    private WebElement continueButtonPaymentInfo;

    @FindBy(css = "button[title='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(css = ".sub-title")
    private WebElement OrderReceivedText;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickregisterAndCheckoutButton() {
        registerAndCheckoutButton.click();
    }

    public void clickcontinueButton() {
        continueButton.click();
    }

    public void clickShipToCurrentAdressButton() {
        ShipToCurrentAdressButton.click();
    }

    public void clickcontinueBillingInfoButton() {
        continueBillingInfoButton.click();
    }

    public void clickshippingMethodFlatRateButton() {
        shippingMethodFlatRateButton.click();
    }

    public void clickcontinueButtonShippingMethod() {
        continueButtonShippingMethod.click();
    }

    public void clickcontinueButtonPaymentInfo() {
        continueButtonPaymentInfo.click();
    }

    public void clickplaceOrderButton() {
        placeOrderButton.click();
    }

    public String getOrderReceivedText() {
        return OrderReceivedText.getText();
    }


}
