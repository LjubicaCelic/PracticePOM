package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    String validUsername ="student";
    String validPassword = "Password123";
    private String expectedMessage = "Logged In Successfully";

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

    }

    @Test
    public void loginTest() {
        navBarPage.clickOnPracticeButton();
        practicePage.clickOnTestLoginButton();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertEquals(loggedInSuccessfullyPage.getText(),expectedMessage);
        Assert.assertTrue(loggedInSuccessfullyPage.getLogOutButton().isDisplayed());
        loggedInSuccessfullyPage.clickOnLogOutButton();
    }
}
