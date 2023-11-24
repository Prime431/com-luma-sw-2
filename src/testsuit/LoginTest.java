package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class LoginTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/"; //URL

    @Before
    public void setUp() { //Method for launching the browser

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        openBrowser(baseUrl);
        driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/'])[1]")).click();
        driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("vishalpat@gmail.com");
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("Password123@");
        driver.findElement(By.xpath("(//button[contains(normalize-space(),'Sign In')])[1]")).click();
        String expectedMessage = "Welcome, vishal fdskfml!";
        String actualMessage = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, vishal fdskfml!']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        openBrowser(baseUrl);
        driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/'])[1]")).click();
        driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("vishalpat@gmail.com");
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("Pword123@");
        driver.findElement(By.xpath("(//button[@type='submit' and @name='send'])[1]")).click();
        String expectedMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualMessage = driver.findElement(By.xpath("//div[@data-ui-id='message-error']//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)'][contains(text(),'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.')]")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        openBrowser(baseUrl);
        driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/'])[1]")).click();
        driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("vishalpat@gmail.com");
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("Password123@");
        driver.findElement(By.xpath("(//button[@type='submit' and @name='send'])[1]")).click();
        String expectedMessage = "Welcome, vishal fdskfml!";
        String actualMessage = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, vishal fdskfml!']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/'])[1]")).click();
        String actualSignOutputText = "You are signed out";
        String expectedSignOutText = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedSignOutText, actualSignOutputText);

    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}
