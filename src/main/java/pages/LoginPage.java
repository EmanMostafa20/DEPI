package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver loginDriver;
    //Locators
    By userName = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    //constructor
    public LoginPage(WebDriver driver) {
        loginDriver = driver;
    }

    //actions

    public void typeUsername(String username) {
        loginDriver.findElement(userName).sendKeys(username);
    }

    public void typePassword(String password) {
        loginDriver.findElement(this.password).sendKeys(password);
    }

    public InventoryPage clickLogin() {
        loginDriver.findElement(loginButton).click();
        return new InventoryPage(loginDriver);
    }

}
