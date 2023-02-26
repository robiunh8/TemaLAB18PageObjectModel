package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultsPage;

public class SearchTest {


    private WebDriver driver;

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private SearchResultsPage searchResultsPage;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);


    }

    @Test
    public void searchByKeywordPage() {

        homePage.setSearchField("neck");
        Assert.assertTrue(searchResultsPage.isProductInList("SILVER DESERT NECKLACE"));

        homePage.setSearchField("shirt");
        Assert.assertTrue(searchResultsPage.isProductInList("FRENCH CUFF COTTON TWILL OXFORD"));


    }

    @After
    public void quit() {
        driver.close();
    }
}

