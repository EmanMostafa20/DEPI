package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage {

    WebDriver inventoryDriver;
    //locators
    By title = By.xpath("//span[@class='title']");
    By productTitle = By.className("inventory_item_name");
    By burgerMenu = By.id("react-burger-menu-btn");
    By logOutLink = By.id("logout_sidebar_link");

    By footer = By.xpath("//footer[@data-test='footer']");

    //constructor
    public InventoryPage(WebDriver driver) {
        inventoryDriver = driver;

    }
    //actions

    public WebElement findBackpack() {

        List<WebElement> products = inventoryDriver.findElements(productTitle);
        return products.get(0);
    }


    public LoginPage logOut(){
        inventoryDriver.findElement(burgerMenu).click();
        waitForElementToBeClickable(logOutLink);
        inventoryDriver.findElement(logOutLink).click();
        return new LoginPage(inventoryDriver);
    }

    public void waitForElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(inventoryDriver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
public WebElement getFooter(){
        return inventoryDriver.findElement(footer);
}
}
