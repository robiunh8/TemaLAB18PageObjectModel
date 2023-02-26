package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class WishlistTest {

    private WebDriver driver;

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private SearchResultsPage searchResultsPage;
    private ProductsPage productsPage;
    private WishlistPage wishlistPage;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        wishlistPage = new WishlistPage(driver);
    }

    @Test
    public void WISHLISTsale() {


        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("dani.ban112@yahoo.com");
        loginPage.setPasswordFieldField("1ParolaPtTest1");
        loginPage.clickLoginButton();

        homePage.clickVipCategoryButton();
        productsPage.clickaddToWishlistButton();


        Assert.assertEquals("Lexington Cardigan Sweater has been added to your wishlist. Click here to continue " +
                "shopping.", wishlistPage.getaddedToWishlistText());
    }


    @After
    public void quit() {
        driver.close();
    }

}
