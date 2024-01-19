import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DomaciZadatakUtorak {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));

        //Domaci Zadatak 1:
        //Napisati 5 negativnih log-in test case-eva za dati sajt : https://practicetestautomation.com/ (edited)

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
        passwordField.sendKeys("password");
        submitButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(wd.getCurrentUrl(),"https://practicetestautomation.com/practice-test-login/");
        WebElement errorField = wd.findElement(By.id("error"));
        Assert.assertTrue(errorField.isDisplayed());

        usernameField.sendKeys("student123");
        passwordField.sendKeys(password);
        submitButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(errorField.isDisplayed());
        Assert.assertEquals(wd.getCurrentUrl(),"https://practicetestautomation.com/practice-test-login/");

        usernameField.sendKeys("newStudent");
        passwordField.sendKeys("newPassword");
        submitButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(wd.getCurrentUrl(),"https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(errorField.isDisplayed());


        usernameField.sendKeys("");
        passwordField.sendKeys(password);
        submitButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(wd.getCurrentUrl(),"https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(errorField.isDisplayed());


        usernameField.sendKeys(username);
        passwordField.sendKeys("");
        submitButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(wd.getCurrentUrl(),"https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(errorField.isDisplayed());



    }
}
