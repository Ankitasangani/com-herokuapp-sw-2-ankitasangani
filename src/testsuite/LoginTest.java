package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * <p>
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * <p>
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username
 * is invalid!”
 * <p>
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password
 * is invalid!”
 */

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        // Enter Username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
        // Enter password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");
        // Click on Login button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        // Verify the text “Secure Area”
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText();
        Assert.assertEquals("Text didn't Match!", expectedText, actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        // Enter Username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith1");
        // Enter password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");
        // Click on Login button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        // Verify the text “Your username is invalid!”
        String expectedText = "Your username is invalid!";
        String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText().substring(0, 25);
        Assert.assertEquals("Text didn't Match!", expectedText, actualText);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        // Enter Username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
        // Enter password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword");
        // Click on Login button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        // Verify the text “Your password is invalid!”
        String expectedText = "Your password is invalid!";
        String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText().substring(0, 25);
        Assert.assertEquals("Text didn't Match!", expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}























