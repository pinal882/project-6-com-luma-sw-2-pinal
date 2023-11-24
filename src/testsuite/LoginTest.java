package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Click on 'Sign In' link
        driver.findElement(By.xpath("(//a[contains(text(),'Sign In ')])[1]")).click();
        //Enter valid Email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("a2b3cde@gmail.com");
        //Enter valid Password
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("Prime123");
        //click on 'sign in ' button
        driver.findElement(By.xpath("(//span[text()='Sign In'])[1]")).click();
        //Verify the 'Welcome' text is display
        String expectedText = "Welcome, xyz sh!";
        WebElement actualTextElement = driver.findElement(By.xpath("(//span[text()='Welcome, xyz sh!'])[1]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        //click on 'Sign in ' link
        driver.findElement(By.xpath("(//a[contains(text(),'Sign In ')])[1]")).click();
        //Enter invalid email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("a2bce@gmail.com");
        //Enter invalid password
        driver.findElement(By.xpath("(//input[@id='pass'])[1]")).sendKeys("prime123");
        //click on sign in button
        driver.findElement(By.xpath("(//span[text()='Sign In'])[1]")).click();
        //verify the error message'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.'
        String expectedText = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //click on Sign in link
        driver.findElement(By.xpath("(//a[contains(text(),'Sign In ')])[1]")).click();
        //Enter valid Email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("a2b3cde@gmail.com");
//Enter valid password
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Prime123");
        //click on sign in buttton
        driver.findElement(By.xpath("(//span[text()='Sign In'])[1]")).click();
        //verify the 'Welcome' sign in displayed
        String expectedText = "Welcome, xyz sh!";
        WebElement actualTextElement = driver.findElement(By.xpath("(//span[text()='Welcome, xyz sh!'])[1]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);
        //click on down arrow near welcome
        driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();
        //click on Sign Out link
        driver.findElement(By.xpath("(//a[contains(text(),'Sign Out ')])[1]")).click();
        //verify the text 'You are signed out
        String expectedText1 = "You are signed out";
        driver.findElement(By.xpath("//h1[@class='page-title']")).click();
        Assert.assertEquals(expectedText,actualText);

    }
    public void tearDown(){
        closeBrowser();
    }
}