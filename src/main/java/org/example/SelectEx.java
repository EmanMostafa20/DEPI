package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectEx {
    public static void main(String[] args) {
        //Navigate to website
        WebDriver myBrowser= new ChromeDriver();
        myBrowser.get("https://the-internet.herokuapp.com/dropdown");

        //Locate about drop down

      WebElement dropDwn= myBrowser.findElement(By.id("dropdown"));
        //save drop down in Select obj
        Select selectObj = new Select(dropDwn);

        //Get drop down options
        List<WebElement> options=selectObj.getOptions();
        System.out.println(options.toString());

        //Click on about
        dropDwn.click();
        //Select About Selenium
        selectObj.selectByVisibleText("Option 1");
    }
}
