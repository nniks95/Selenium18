import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak6 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();

        wd.get("https://practicetestautomation.com/");
        WebElement practiceButton = wd.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement loginButton = wd.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"));
        loginButton.click();
        WebElement usernameField = wd.findElement(By.id("username"));
        usernameField.sendKeys("student");
        WebElement passwordField = wd.findElement(By.id("password"));
        passwordField.sendKeys("Password123");
        WebElement submitButton = wd.findElement(By.id("submit"));
        submitButton.click();

        WebElement logOutButton = wd.findElement(By.linkText("Log out"));
        logOutButton.click();

        String expectedResult = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(wd.getCurrentUrl(),expectedResult);
        WebElement submitButtonAfterLogOut = wd.findElement(By.id("submit"));
        Assert.assertTrue(submitButtonAfterLogOut.isDisplayed());

    }
}
