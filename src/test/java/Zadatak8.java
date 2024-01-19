import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak8 {
    public static void main(String[] args) throws InterruptedException {

        ///*Zadatak 9
        //https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2
        //Testirati dodavanje knjige u korpu i da li se knjiga obrise kada obrisete kolacice*/

        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        wd.get("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");

        Thread.sleep(5000);
        WebElement addToCartButton = wd.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        WebElement proceedToCheckOutButton = wd.findElement(By.className("a-button-input"));
        Assert.assertTrue(proceedToCheckOutButton.isDisplayed());
        Assert.assertNotEquals(wd.getCurrentUrl(),"https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");
        WebElement successfullyAddedToCart = wd.findElement(By.cssSelector(".a-size-medium-plus.a-color-base.sw-atc-text.a-text-bold"));
        Assert.assertEquals(successfullyAddedToCart.getText(),"Added to Cart");


        wd.manage().deleteAllCookies();
        wd.navigate().refresh();

        WebElement messageAfterDeletingCookies = wd.findElement(By.cssSelector(".a-row.sc-your-amazon-cart-is-empty"));
        Assert.assertEquals(messageAfterDeletingCookies.getText(),"Your Amazon Cart is empty");
        WebElement cartAfterDeletingCookies = wd.findElement(By.cssSelector(".nav-cart-count.nav-cart-0.nav-progressive-attribute.nav-progressive-content"));
        Assert.assertTrue(cartAfterDeletingCookies.isDisplayed());









    }
}
