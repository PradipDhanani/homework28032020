package teamwork28032020;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

/**
 * Created by Pradip
 */
public class Login extends Utility {

    @Before
    public void openBrowser() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessFully() {
        clickOnElement(By.xpath("//a[@class='ico-login']"));
        String expectedResult = "Welcome, Please Sign In!";
        String actualResult = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void userShouldLoginSuccessfully() {
        clickOnElement(By.xpath("//a[@class='ico-login']"));
        sendTextToElement(By.id("Email"), "testingteamsss@gmail.com");
        sendTextToElement(By.id("Password"), "xyz123");
        clickOnElement(By.xpath("//input[@class=\"button-1 login-button\"]"));
        String expectedResult = "Welcome to our store";
        String actualResult = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals(expectedResult, actualResult);

    }

    @After
    public void browserClosing() {
        driver.quit();
    }

}


