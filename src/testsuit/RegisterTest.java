package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/"; //URL

    @Before
    public void setUp() { //Method for launching the browser
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay() {
        driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/customer/account/create/'])[1]")).click();
        String expectedText = "Create New Customer Account";
        String actualText = driver.findElement(By.xpath("//h1[@class='page-title']//span[@class='base']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        Random randomGenerator = new Random(); // generating random number
        int randomInt = randomGenerator.nextInt(1000); //storing the random number
        driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/customer/account/create/'])[1]")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Shamsher");
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Jay");
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("username" + randomInt + "@gmail.com"); //generating random email
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Password123@");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Password123@");
        driver.findElement(By.xpath("(//span[text()='Create an Account'])[1]")).click();
        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[contains(text(),'Thank you ')]")).getText();
        Assert.assertEquals(expectedText,actualText);
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/'])[1]")).click();
        String actualSignOutputText = "You are signed out";
        String expectedSignOutText = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedSignOutText, actualSignOutputText);
    }

    @After
    public void tearDown() {
        closeBrowser();

    } // closing the browser
}
