package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public class LoginTest extends BaseTest {
    String validUsername = "student";
    String validPassword = "Password123";
    String invalidUsername = "st";
    String invalidPassword = "123";
    String expectedMessage = "Logged In Successfully";
    String actualMessage;
    String expectedInvalidPasswordMessage = "Your password is invalid!";
    String actualInvalidPasswordMessage;
    String expectedInvalidUsernameMessage = "Your username is invalid!";
    String actualInvalidUsernameMessage;

    public void goToLoginPage() {
        navBarPage.clickOnPracticeButton();
        practicePage.clickOnTestLoginButton();
    }

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

    }

    @Test
    public void loginUsingValidCredentialsTest() {
        goToLoginPage();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnSubmitButton();
        actualMessage = loggedInPage.getLoggedInSuccessfullyMessage().getText();
        Assert.assertTrue(loggedInPage.getLoggedInSuccessfullyMessage().isDisplayed());
        Assert.assertEquals(actualMessage, expectedMessage);
        Assert.assertTrue(loggedInPage.getLogOutButton().isDisplayed());
        loggedInPage.clickOnLogOutButton();
    }

    @Test
    public void logOutTest() {
        goToLoginPage();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnSubmitButton();
        actualMessage = loggedInPage.getLoggedInSuccessfullyMessage().getText();
        loggedInPage.clickOnLogOutButton();
        Assert.assertTrue(loginPage.getUsernameField().isDisplayed());
        Assert.assertTrue(loginPage.getPasswordFIeld().isDisplayed());
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
    }

    @Test
    public void invalidPasswordTest() {
        goToLoginPage();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMessage()));
        actualInvalidPasswordMessage = loginPage.getErrorMessage().getText();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(actualInvalidPasswordMessage, expectedInvalidPasswordMessage);
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
    }

    @Test
    public void invalidUsernameTest() {
        goToLoginPage();
        loginPage.enterUsername(invalidUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMessage()));
        actualInvalidUsernameMessage = loginPage.getErrorMessage().getText();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(actualInvalidUsernameMessage, expectedInvalidUsernameMessage);
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
    }


    @AfterMethod
    public void removeCookies() {
        driver.manage().deleteAllCookies();
    }


}
