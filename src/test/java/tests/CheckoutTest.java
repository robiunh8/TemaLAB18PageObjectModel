package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class CheckoutTest {


    private WebDriver driver;

    private HomePage homePage;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private AddToCartPage addToCartPage;
    private CheckoutPage checkOutPage;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        addToCartPage = new AddToCartPage(driver);
        checkOutPage = new CheckoutPage(driver);


    }

    @Test
    public void CheckOut() throws InterruptedException {
        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("dani.ban112@yahoo.com");
        loginPage.setPasswordFieldField("1ParolaPtTest1");
        loginPage.clickLoginButton();

        homePage.clickVipCategoryButton();
        productsPage.clickViewDetailOfProduct();
        productsPage.clickColorButton();
        productsPage.clickSizeButton();
        productsPage.clickAddToCartButton();


        addToCartPage.setQualityOfProduct("1");
        addToCartPage.clickUpdateTotalButton();
        addToCartPage.clickCountryDropdownButton();
        addToCartPage.selectCountry("Statele Unite ale Americii");
        addToCartPage.clickStateOrProvinceButton();
        addToCartPage.selectProvinceOrState("Oregon");
        addToCartPage.setCityField("Portland");
        addToCartPage.setPostcodeZIP("400066");

        Thread.sleep(3000);
        addToCartPage.clickProceedToCheckoutButton();


        checkOutPage.clickcontinueBillingInfoButton();
        Thread.sleep(5000);
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert was present on the page");
        }
        Thread.sleep(4000);
        checkOutPage.clickshippingMethodFlatRateButton();
        checkOutPage.clickcontinueButtonShippingMethod();
        Thread.sleep(4000);
        checkOutPage.clickcontinueButtonPaymentInfo();
        Thread.sleep(4000);
        checkOutPage.clickplaceOrderButton();
        Thread.sleep(4000);
        Assert.assertEquals("THANK YOU FOR YOUR PURCHASE!", checkOutPage.getOrderReceivedText());

    }

    @After
    public void quit() {
        driver.close();

    }

}

