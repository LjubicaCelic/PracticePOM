package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    private WebElement usernameField;
    private WebElement passwordFIeld;
    private WebElement submitButton;
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordFIeld() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));

    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.id("error"));
    }


    //--------------------------------------------------------

    public void enterUsername(String username) {
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void enterPassword(String password) {
        getPasswordFIeld().clear();
        getPasswordFIeld().sendKeys(password);
    }

    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }


}
