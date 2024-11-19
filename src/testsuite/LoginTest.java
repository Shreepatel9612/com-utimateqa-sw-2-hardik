package testsuite;
/**
 * Write down the following test in the ‘LoginTest’ class

 * 1. userShouldNavigateToLoginPageSuccessfully()

 *  click on the ‘Sign In’ link
 * *Verify the text ‘Welcome Back!’

 * 2. verifyTheErrorMessage()

 * * click on the ‘Sign In’ link
 * * Enter the invalid username
 * * Enter the invalid password
 * * Click on the ‘Sign in’ button
 * * Verify the error message ‘Invalid email
 * or password.’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a")).click();

        WebElement welcomeText = driver.findElement(By.tagName("h2"));
        Assert.assertEquals("Welcome Back!", welcomeText.getText());
    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a")).click();
        driver.findElement(By.id("user[email]")).sendKeys("shree_patel");
        driver.findElement(By.id("user[password]")).sendKeys("123456");
        driver.findElement(By.className("button-primary")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement errorMessage = driver.findElement(By.className("form-error__list-item"));
        Assert.assertEquals("Invalid email or password.", errorMessage.getText().trim());


    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}
