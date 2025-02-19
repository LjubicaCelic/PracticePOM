package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage {
    WebDriver driver;
    private WebElement testLoginButton;


    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTestLoginButton() {
        return driver.findElement(By.linkText("Test Login Page"));
    }

    //-------------------------------------------------------------

    public void clickOnTestLoginButton() {
        getTestLoginButton().click();
    }

}
