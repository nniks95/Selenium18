import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DomaciZadatakUtorak_TC5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        wd.get("https://practicetestautomation.com/");
        WebElement practiceButton = wd.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPageButton = wd.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
        String username = "student";
        String password = "Password123";
        WebElement usernameField = wd.findElement(By.id("username"));
        WebElement passwordField = wd.findElement(By.id("password"));
        WebElement submitButton = wd.findElement(By.id("submit"));


        usernameField.sendKeys(username);
        passwordField.sendKeys("");
        submitButton.click();
        Thread.sleep(2000);
        WebElement errorField = wd.findElement(By.id("error"));
        Assert.assertTrue(errorField.isDisplayed());
        Assert.assertEquals(wd.getCurrentUrl(),"https://practicetestautomation.com/practice-test-login/");
    }
}

