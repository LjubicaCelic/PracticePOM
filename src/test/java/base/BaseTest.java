package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import pages.LoggedInSuccessfullyPage;
import pages.PracticePage;
import pages.NavBarPage;
import pages.LoginPage;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public NavBarPage navBarPage;
    public PracticePage practicePage;
    public LoginPage loginPage;
    public LoggedInSuccessfullyPage loggedInSuccessfullyPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        navBarPage = new NavBarPage(driver);
        practicePage = new PracticePage(driver);
        loginPage = new LoginPage(driver);
        loggedInSuccessfullyPage = new LoggedInSuccessfullyPage(driver);
    }
}
