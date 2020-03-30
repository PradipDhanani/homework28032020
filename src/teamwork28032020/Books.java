package teamwork28032020;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pradip
 */
public class Books extends Utility {

    public String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);


    }

    @Test
    public void VerifyUserShouldNavigateToBooksPage() {

        clickOnElement(By.linkText("Books"));
        String expectedResult = "Books";
        String actualResult = getTextFromElement(By.xpath("//h1[contains(text(),'Books')]"));
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void VerifyUserShouldSortOutProductByAToZ() {

        clickOnElement(By.linkText("Books"));
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));

        ArrayList<String> getList = new ArrayList<>();//creating the array list for obtain the elements from webpage
        List<WebElement> elementList = driver.findElements(By.tagName("h2"));//finding the elements by tag name
        for (WebElement Links : elementList) {
            getList.add(Links.getText());
        }
        System.out.println("Obtained Product List :" + getList);
        ArrayList<String> sortedList = new ArrayList<>();
        sortedList.addAll(getList);
        Collections.sort(sortedList);
        Assert.assertEquals(getList, sortedList);
    }

    @Test
    public void verifyProductAddedToWishList() {

        clickOnElement(By.linkText("Books"));
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]"));
        String expectedResult = "The product has been added to your wishlist";
        String actualResult = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedResult, actualResult);


    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}

