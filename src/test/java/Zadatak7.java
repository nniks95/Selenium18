import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak7 {
    public static void main(String[] args) {
        //// Zadatak 6
        //// Testirati log out funkcionalnost

        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();

        wd.get("https://practicetestautomation.com/");
        WebElement practiceButton = wd.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement loginButton = wd.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"));
        loginButton.click();
        WebElement usernameField = wd.findElement(By.id("username"));
        WebElement passwordField = wd.findElement(By.id("password"));
        WebElement submitButton = wd.findElement(By.id("submit"));

        usernameField.sendKeys("studenti");
        passwordField.sendKeys("Password123");
        submitButton.click();

        WebElement wrongUsername = wd.findElement(By.className("show"));
        Assert.assertEquals(wrongUsername.getText(),"Your username is invalid!");
        Assert.assertTrue(usernameField.isEnabled());
        Assert.assertEquals(wd.getCurrentUrl(),"https://practicetestautomation.com/practice-test-login/");


        usernameField.sendKeys("student");
        passwordField.sendKeys("Password123456");
        submitButton.click();

        WebElement wrongPassword = wd.findElement(By.className("show"));
        Assert.assertEquals(wrongPassword.getText(),"Your password is invalid!");
        Assert.assertNotEquals(wd.getCurrentUrl(),"https://practicetestautomation.com/logged-in-successfully/");

    }
}
