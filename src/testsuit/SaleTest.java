package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/"; //URL

    @Before
    public void setUp() { //Method for launching the browser
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomenJacketsPage() {
        driver.findElement(By.xpath("//span[starts-with(text(),'Sale')]")).click(); // Clicking on the sale
        driver.findElement(By.xpath("(//a[contains(text(),'Jackets')])[1]")).click(); // click on jacket
        String expectedMessage = "Jackets"; //expect message
        String actualMessage = driver.findElement(By.xpath("//span[@class='base']")).getText(); //capturing message
        Assert.assertEquals(expectedMessage, actualMessage); //comparing the message


        //tag name locator ---> To find multiple elements
        List<WebElement> linksElements = driver.findElements(By.xpath("//li[@class='item product product-item']")); //getting the lsit
        System.out.println("Number of links = " + linksElements.size()); //counting the links

        List<WebElement> linkeditems = driver.findElements(By.tagName("ol"));
        System.out.println("total number of items:" +linkeditems.size());// printing link
        for( WebElement link : linkeditems){
            System.out.println("linked text: "+link.getText());
        }
        //Verify expected and actual number of items displayed per page
        int exptectedNumberOfItems = 12;
        int actualNumberOfItems = linksElements.size();
        Assert.assertEquals("Error", exptectedNumberOfItems,actualNumberOfItems); // comparing the length
    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}