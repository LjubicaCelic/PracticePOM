package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavBarPage {
    WebDriver driver;
    private WebElement homeLink;
    private WebElement practiceButton;
    private WebElement coursesLink;
    private WebElement blogLink;

    public NavBarPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPracticeButton() {
        return driver.findElement(By.id("menu-item-20"));
    }

    //------------------------------------------------------

    public void clickOnPracticeButton() {
        getPracticeButton().click();
    }

}
