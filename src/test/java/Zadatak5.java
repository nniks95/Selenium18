import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5 {
    public static void main(String[] args) {
        //// Zadatak 5
        //// Testirati log in stranice https://practicetestautomation.com/

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

        String expectedResult = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(wd.getCurrentUrl(),expectedResult);

        String logOut = "Log out";
        WebElement logOutButton = wd.findElement(By.linkText("Log out"));
        String actualResultOnLogOutButton = logOutButton.getText();
        Assert.assertEquals(logOut,actualResultOnLogOutButton);

        String logInText = "Logged In Successfully";
        WebElement textAfterLogIn = wd.findElement(By.className("post-title"));
        String actualTextAfterLogIn = textAfterLogIn.getText();
        Assert.assertEquals(logInText,actualTextAfterLogIn);







    }
}
