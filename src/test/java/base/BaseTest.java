package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoggedInPage;
import pages.PracticePage;
import pages.NavBarPage;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public NavBarPage navBarPage;
    public PracticePage practicePage;
    public LoginPage loginPage;
    public LoggedInPage loggedInPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver = new ChromeDriver();
        navBarPage = new NavBarPage(driver);
        practicePage = new PracticePage(driver);
        loginPage = new LoginPage(driver);
        loggedInPage = new LoggedInPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
