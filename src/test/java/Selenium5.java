import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Selenium5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wd.get("https://wordpress.com/");


        WebElement loginButton = wd.findElement(By.linkText("Log In"));
        loginButton.click();
        WebElement usernameField = wd.findElement(By.id("usernameOrEmail"));
        usernameField.sendKeys("nikola.nikolic.it@gmail.com");
        WebElement continueButton = wd.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

       wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
       WebElement passwordField = wd.findElement(By.id("password"));
       passwordField.sendKeys("itbootcamp");
       WebElement loginButton2 = wd.findElement(By.cssSelector("button[type='submit']"));
       loginButton2.click();

       wait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/niks95blog.wordpress.com"));
        Assert.assertNotEquals(wd.getCurrentUrl(),"https://wordpress.com/log-in/");
        WebElement profilueButton = wd.findElement(By.className("masterbar__item-content"));
        profilueButton.click();










    }
}
