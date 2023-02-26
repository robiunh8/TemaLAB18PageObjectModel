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

public class LoginTest {


    private WebDriver driver;

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

    }

    @Test
    public void LogIntoAccount() {


        homePage.clickAccountButton();
        homePage.clickLoginLink();

        loginPage.setEmailField("dani.ban112@yahoo.com");
        loginPage.setPasswordFieldField("1ParolaPtTest1");
        loginPage.clickLoginButton();

        Assert.assertEquals("Hello, LIONEL MESSI!", accountPage.getWelcomeText());


    }

    @After
    public void quit() {
        driver.close();
    }
}

