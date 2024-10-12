import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing {
    WebDriver myBrowser;

@BeforeClass
public void start(){
    myBrowser  = new ChromeDriver();
    //Navigate to url
    myBrowser.get("https://www.saucedemo.com/");
    // maxmize window
    myBrowser.manage().window().maximize();
}

@Test(testName = "Login Test Case",priority = 1)
public void login(){
    myBrowser.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("standard_user");
    myBrowser.findElement(By.id("password")).sendKeys("secret_sauce");
    myBrowser.findElement(By.id("login-button")).click();
}


    @Test(testName = "Check Inventory Products Title is Products",priority = 2)
    public void checkInventoryProductsTitle(){


        WebElement titleElement=myBrowser.findElement(By.className("title"));
       // Assert.assertEquals(titleElement.getText(),"Products","Products title is wrong");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(titleElement.getText(),"Product","Products title is wrong");
        softAssert.assertAll();
    }

    @Test(testName = "Check Inventory Products Text",priority = 3)
    public void checkBackpackProductText(){
    WebElement productText=myBrowser.findElement(By.xpath("//div[@data-test='inventory-item-name']"));
        Assert.assertEquals(productText.getText(),"Sauce Labs Backpack");
    }

@AfterClass
    public void tearDown(){
    myBrowser.quit();
}
}
