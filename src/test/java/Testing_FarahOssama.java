import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Testing_FarahOssama {
    WebDriver myBrowser;


    @BeforeClass
    public void start(){
        myBrowser = new ChromeDriver();
        myBrowser.get("https://the-internet.herokuapp.com/login");

        myBrowser.manage().window().maximize();
    }

    @Test(testName = "login test case")
    public void login(){
        myBrowser.findElement(By.id("username")).sendKeys("tomsmith");
        myBrowser.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        myBrowser.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @Test(testName = "secure page test case", dependsOnMethods = "login")
    public void textingreenarea(){

        WebDriverWait wait = new WebDriverWait(myBrowser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("secure"));

        
        //WebDriverWait explicitwait = new WebDriverWait(myBrowser, Duration.ofSeconds(5));
        WebElement titleElement = myBrowser.findElement(By.id("flash"));

        Assert.assertEquals(titleElement.getText(), "You logged into a secure area!\n" + "×");
        System.out.printf(titleElement.getText());
    }

    @Test(testName = "logout", dependsOnMethods = "textingreenarea")
    public void logout(){
        myBrowser.findElement(By.xpath("//a[@href='/logout']")).click();
        String url = myBrowser.getCurrentUrl();
        Assert.assertEquals(url, "https://the-internet.herokuapp.com/login");

    }
}
