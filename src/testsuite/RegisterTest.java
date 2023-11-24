package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay() {
        //click on the 'Create an Account' link
        driver.findElement(By.xpath("(//a[text()='Create an Account'])[1]")).click();
        //verify the text 'Create New Customer Account'
        String expectedText = "Create New Customer Account";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='base']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);
    }
    // public static String getRandomEmail(){
    //String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    // StringBuilder random = new StringBuilder();
    //  Random rnd = new Random();
    // while (random.length() < 10){
    //    int index = (int) (rnd.nextFloat() * chars.length());
    //    random.append(chars.charAt(index));
//}
      //  String  email = random.toString() + "@gmail.com";
      //  return email;
   // }
    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //click on the 'Create an Account' link
        driver.findElement(By.xpath("(//a[text()='Create an Account'])[1]")).click();
        //Enter First name
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("xyz");
        //Enter Last name
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("sh");
        //Click on checkbox Sign up for Newsletter
        // driver.findElement(By.xpath("//a[text()='Subscribe to our mailing list']")).click();
        //Enter email
        //driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("getRandomEmail()");
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("a2bcdef@gmail.com");
        //Enter password
        driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("Prime123");
        //Enter confirm password
        driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys("Prime123");
        //Click on create an Account button
        driver.findElement(By.xpath("(//span[text()='Create an Account'])[1]")).click();
        //Verify the text Thank you for registering with Main Website Store.
        String expectedText = "Thank you for registering with Main Website Store.";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[text()='Thank you for registering with Main Website Store.']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);
//Click on down arrow near Welcome
        driver.findElement(By.xpath("(//button[@data-action='customer-menu-toggle'])[1]")).click();
        //Click on Sign Out link
        driver.findElement(By.xpath("(//a[contains(text(),'Sign Out ')])[1]")).click();
        //verify the text '
        String text = "You are signed out";
        driver.findElement(By.xpath("//h1[@class=\"page-title\"]"));

}
}
