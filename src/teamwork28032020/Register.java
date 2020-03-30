package teamwork28032020;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.Random;

/**
 * Created by Pradip
 */
public class Register extends Utility {
    @Before
    public void openBrowser() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessFully() {

        clickOnElement(By.xpath("//a[@class=\"ico-register\"]"));
    }

    @Test
    public void userShouldRegisterSuccessfully() throws InterruptedException {

        clickOnElement(By.xpath("//a[@class=\"ico-register\"]"));
        clickOnElement(By.xpath("//span[@class=\"male\"]//input[@type='radio']"));
        sendTextToElement(By.xpath("//input[@id=\"FirstName\"]"), "prad");
        sendTextToElement(By.xpath("//input[@id=\"LastName\"]"), "Patel");
        sendTextToElement(By.xpath("//select[@name=\"DateOfBirthDay\"]"), "4");
        sendTextToElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"), "July");
        sendTextToElement(By.xpath("//select[@name=\"DateOfBirthYear\"]"), "1986");

        Thread.sleep(2000);
        Random anyEmail = new Random();
        int randomInt = anyEmail.nextInt(1000);
        sendTextToElement(By.xpath("//input[@id=\"Email\"]"), +randomInt + "@gmail.com");
        sendTextToElement(By.xpath("//input[@id=\"Company\"]"), "Testing Team");
        sendTextToElement(By.xpath("//input[@id=\"Password\"]"), "xyz123");
        sendTextToElement(By.xpath("//input[@id=\"ConfirmPassword\"]"), "xyz123");
        clickOnElement(By.xpath("//input[@id=\"register-button\"]"));
        String expectedResult = "Your registration completed";
        String actualResult = getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals(expectedResult, actualResult);


    }

    @After
    public void browserClosing() {
        driver.quit();
    }

}
