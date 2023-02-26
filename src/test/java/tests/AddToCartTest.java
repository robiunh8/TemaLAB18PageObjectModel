package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class AddToCartTest {


    private WebDriver driver;

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private ProductsPage productsPage;
    private AddToCartPage addToCartPage;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        productsPage = new ProductsPage(driver);
        addToCartPage = new AddToCartPage(driver);


    }

    @Test
    public void AddToCart() throws InterruptedException {


        homePage.clickVipCategoryButton();
        productsPage.clickViewDetailOfProduct();
        productsPage.clickColorButton();
        productsPage.clickSizeButton();
        productsPage.clickAddToCartButton();

        Assert.assertEquals("Lexington Cardigan Sweater was added to your shopping cart.", addToCartPage.getProductWasAddedToCart());


        addToCartPage.clickCountryDropdownButton();
        addToCartPage.selectCountry("Statele Unite ale Americii");

        addToCartPage.clickStateOrProvinceButton();
        addToCartPage.selectProvinceOrState("Oregon");

        addToCartPage.setCityField("Portland");
        addToCartPage.setPostcodeZIP("400066");
        addToCartPage.clickProceedToCheckoutButton();


    }

    @After
    public void quit() {
        driver.close();
    }
}

