import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Zadatak10 {

//"https://practicetestautomation.com/"

    //Za pocetak nastavite pisanje testova za login sto smo poceli juce. Ideja je da u jednoj klasi imate sve
    // metode (test kejseve) za testiranje ove funkcionalnosti. To bi bio log in, log out i neuspeli pokusaji
    //Mozete da radite sve testove u jednom browseru ili svaki test u posebnom

    WebDriver wd;
    WebDriverWait wait;
    String validUsername;
    String validPassword;
    String invalidUsername;
    String invalidPassword;
    String loggedInUrl;
    WebElement usernameField;
    WebElement passwordField;
    WebElement submitButton;
    WebElement logOutButton;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        validUsername = "student";
        validPassword = "Password123";
        loggedInUrl = "https://practicetestautomation.com/logged-in-successfully/";
        invalidUsername = "student123";


    }
    @BeforeMethod
    public void setUpPage(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(wd,Duration.ofSeconds(5));
        wd.get("https://practicetestautomation.com/");
        WebElement practiceButton = wd.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPageButton = wd.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();

        usernameField = wd.findElement(By.id("username"));
        passwordField = wd.findElement(By.id("password"));
        submitButton = wd.findElement(By.id("submit"));
    }
    @Test(priority = 10)
    public void UserCanLogIn(){
        usernameField.sendKeys(validUsername);
        passwordField.sendKeys(validPassword);
        submitButton.click();

        logOutButton = wd.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());
        Assert.assertEquals(wd.getCurrentUrl(),loggedInUrl);
    }
    @Test(priority = 20)
    public void UserCannotLoginWithInvalidUsername(){
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(invalidUsername);
        passwordField.sendKeys(validPassword);
        submitButton.click();

        Assert.assertNotEquals(wd.getCurrentUrl(),loggedInUrl);
        WebElement errorMessage = wd.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }
    @Test(priority = 30)
    public void UserCannotLoginWithInvalidPassword(){
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(validUsername);
        passwordField.sendKeys(invalidPassword);
        submitButton.click();

        Assert.assertNotEquals(wd.getCurrentUrl(),loggedInUrl);
        WebElement errorMessage = wd.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }
    @Test(priority = 40)
    public void UserCannotLoginWithInvalidPasswordAndInvalidUsername(){
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(invalidUsername);
        passwordField.sendKeys(invalidPassword);
        submitButton.click();

        Assert.assertNotEquals(wd.getCurrentUrl(),loggedInUrl);
        WebElement errorMessage = wd.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }
    @Test(priority = 50)
    public void UserCannotLoginWithEmptyFields(){
        usernameField.sendKeys("");
        passwordField.sendKeys("");
        usernameField.clear();
        passwordField.clear();
        submitButton.click();

        Assert.assertNotEquals(wd.getCurrentUrl(),loggedInUrl);
        WebElement errorMessage = wd.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }

    @AfterMethod
    public void teardown(){
        wd.quit();
    }

}
