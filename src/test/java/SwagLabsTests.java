import com.google.common.io.Files;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class SwagLabsTests {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeClass
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }


    @Test
    public void login() throws IOException {
        Allure.step("User Types Username");
        loginPage.typeUsername("standard_user");

        //loginpage.typeusername().typepassword()
        Allure.step("User Types Password");
        loginPage.typePassword("secret_sauce");
        Allure.step("User click on login button");
        inventoryPage = loginPage.clickLogin();
        Assert.assertTrue(inventoryPage.findBackpack().isDisplayed());
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        byte[] screenshotbyte= screenshot.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Login ScreenShot",new ByteArrayInputStream(screenshotbyte));
     //  File screenshotFile= screenshot.getScreenshotAs(OutputType.FILE);
     //  Files.copy(screenshotFile,new File("./screenshotLogin.png"));
      //  inventoryPage.logOut();

    }

@Test(dependsOnMethods = "login")
public void checkFooter() throws IOException {
        //JavaScript executer
   JavascriptExecutor jsExecuter= (JavascriptExecutor) driver;
    jsExecuter.executeScript("arguments[0].scrollIntoView(true);",inventoryPage.getFooter());
    Assert.assertTrue(inventoryPage.getFooter().isDisplayed());
    TakesScreenshot screenshot = (TakesScreenshot) driver;
    File screenshotFile= screenshot.getScreenshotAs(OutputType.FILE);
    Files.copy(screenshotFile,new File("./footer.png"));
//Scroll with selenium actions
    Actions action = new Actions(driver);
    action.moveToElement(inventoryPage.getFooter());
    action.perform();
    Assert.assertTrue(inventoryPage.getFooter().isDisplayed());
    TakesScreenshot screenshot = (TakesScreenshot) driver;
    File screenshotFile= screenshot.getScreenshotAs(OutputType.FILE);
    Files.copy(screenshotFile,new File("./footer.png"));


}
@Test
public void anyTest(){

}




    @AfterClass
    public void tearDown() {
        driver.quit();
    }
 @DataProvider
    public Object[][] dataProvider(){
        return new Object[][]{
                {"standard_user","secret_sauce"},{"visual_user","secret_sauce"}
     };
 }

}

