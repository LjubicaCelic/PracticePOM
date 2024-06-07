package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedInSuccessfullyPage {
    WebDriver driver;
    private WebElement logOutButton;
    private WebElement LoggedInSuccessfullyMessage;
    private String text;

    public LoggedInSuccessfullyPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color"));
    }

    public WebElement getLoggedInSuccessfullyMessage() {
        return driver.findElement(By.className("post-title"));
    }

    public String getText() {
        return getLoggedInSuccessfullyMessage().getText();
    }

    //-----------------------------------------------------------------------------------

    public void clickOnLogOutButton(){
        getLogOutButton().click();
    }

}
