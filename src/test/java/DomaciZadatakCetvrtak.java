import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;


public class DomaciZadatakCetvrtak {


    //Ja sam oba slucaja radio preko logina, jer preko cookie-a nisam uspeo da se ulogujem
    //program u sustini radi, samo nisam bio siguran jel za svako dodavanje knjige trebao poseban test

    //ItBootCamp23!@#
    //nniks95

    WebDriver wd;
    String username;
    String password;
    WebDriverWait wait;
    WebElement usernameField;
    WebElement passwordField;
    JavascriptExecutor jse;
    WebElement bookGitPocketGuide;
    WebElement bookLearningJavaScriptDesign;

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        username = "nniks95";
        password = "ItBootCamp23!@#";
        jse = (JavascriptExecutor)wd;


    }
    @BeforeMethod
    public void pageSetUp(){
        wd.get("https://demoqa.com/");
        WebElement bookStoreButton = wd.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[6]/div"));
        bookStoreButton.click();
        WebElement loginButton = wd.findElement(By.id("login"));
        loginButton.click();
        usernameField = wd.findElement(By.id("userName"));
        passwordField = wd.findElement(By.id("password"));
    }
    @Test
    public void addFirstBookToCart() throws InterruptedException {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        WebElement loginButton1 = wd.findElement(By.id("login"));
        loginButton1.click();
        bookGitPocketGuide = wd.findElement(By.id("see-book-Git Pocket Guide"));
        bookGitPocketGuide.click();
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,350)");
        WebElement addToYourCollectionButton = wd.findElement(By.cssSelector(".text-right.fullButton"));
        addToYourCollectionButton.click();
        wd.navigate().refresh();
        Thread.sleep(1000);
        WebElement backToBookStoreButton  = wd.findElement(By.cssSelector(".text-left.fullButton"));
        backToBookStoreButton.click();
        Thread.sleep(1000);
        bookLearningJavaScriptDesign = wd.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        bookLearningJavaScriptDesign.click();

        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,350)");
        WebElement addToYourCollectionButton2 = wd.findElement(By.cssSelector(".text-right.fullButton"));
        addToYourCollectionButton2.click();
        wd.navigate().refresh();
        wd.manage().deleteAllCookies();

    }
    @Test
    public void addSecondBookToCart() throws InterruptedException{
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        WebElement loginButton1 = wd.findElement(By.id("login"));
        loginButton1.click();
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,600)");
        WebElement profilPage = wd.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        profilPage.click();
        Thread.sleep(1000);
        Assert.assertTrue(wd.findElement(By.id("see-book-Learning JavaScript Design Patterns")).isDisplayed());
        Assert.assertTrue(wd.findElement(By.id("see-book-Git Pocket Guide")).isDisplayed());


    }
    @AfterClass
    public void tearDown(){
        wd.quit();
    }
}
