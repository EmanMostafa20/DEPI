package org.example;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       // System.out.println("Hello world!");


        //Click on login button
        WebDriver myBrowser = new ChromeDriver();
        //Navigate to url
        myBrowser.get("https://www.saucedemo.com/");
        // maxmize window
        myBrowser.manage().window().maximize();
        //login username standard_user secret_sauce
       // myBrowser.findElement(By.id("user-name")).sendKeys("standard_user");
        myBrowser.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("standard_user");
        myBrowser.findElement(By.id("password")).sendKeys("secret_sauce");
        myBrowser.findElement(By.id("login-button")).click();
       // myBrowser.findElement(By.id("login-button")).submit();


        //Waits in selenuim java
        //implicit wait
      //  myBrowser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //explicit wait
        //WebDriverWait explicitWait = new WebDriverWait(myBrowser,Duration.ofSeconds(5));
       // explicitWait.until(ExpectedConditions.visibilityOf( myBrowser.findElement(By.className("title"))));

        //fluent wait
        FluentWait fluentWait = new FluentWait(myBrowser);
        fluentWait.withTimeout(Duration.ofSeconds(5));
        fluentWait.pollingEvery(Duration.ofSeconds(2));
        fluentWait.until(ExpectedConditions.visibilityOf(myBrowser.findElement(By.className("title"))));
       List<WebElement> products = myBrowser.findElements(By.xpath("//div[@data-test='inventory-item']"));
       System.out.println("Size of list ="+products.size());

        System.out.println(products.get(1).getText());

      //  myBrowser.findElement(By.cssSelector("button[type='any']"));

      //  myBrowser.findElement(By.className("title"));
        //click add to cart to any product
        //get text of remove button (system.out)
        //click product name
        //click on remove
        //     //get text of add to cart button (system.out)
        //close browser
       // myBrowser.quit();
      //  myBrowser.close();
    }
}