package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage(){
        //click on Sale Menu tab
        driver.findElement(By.xpath("//span[.='Sale']")).click();
        //click on jackets link on left side under women's deal category
        driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
        //verify the text 'jackets' is displayed
        String expectedText = "Jackets";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='base']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText,actualText);
        //count the Total item Displayed on Page and Print the name of all items into console
        List<WebElement> totalItemDisplayed = driver.findElements(By.className("product-image-photo"));
        System.out.println("Total Item  displayed: " + totalItemDisplayed.size());
        List<WebElement> listElements = driver.findElements(By.xpath("(//strong[@class='product name product-item-name'])"));
        for (WebElement link : listElements){
            System.out.println(link.getText());
        }
        //verify total 12 items displayed on page
        String text = "12 Items";
                driver.findElement(By.xpath("(//p[@id='toolbar-amount'])[1]"));
                Assert.assertEquals(expectedText,actualText);
    }
    public void teardown(){
        closeBrowser();
    }
}