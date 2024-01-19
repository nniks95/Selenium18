import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;


public class DomaciZadatakCetvrtak {


    //Koristeci Anotacije - Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application)
    // preko cookies-a, dodati dve knjige na svoj nalog, zatim se izlogovati brisanjem cookies-a.
    //Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu

    //ItBootCamp23!@#
    //nniks95

    WebDriver wd;
    String username;
    String password;
    WebDriverWait wait;
    WebElement usernameField;
    WebElement passwordField;

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        username = "nniks95";
        password = "ItBootCamp23!@#";


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
    public void test1() throws InterruptedException {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        WebElement loginButton1 = wd.findElement(By.id("login"));
        loginButton1.click();
        WebElement bookGitPocketGuide = wd.findElement(By.linkText("Git Pocket Guide"));
        bookGitPocketGuide.click();
        Thread.sleep(1000);
        WebElement addToYourCollectionButton = wd.findElement(By.cssSelector(".text-right.fullButton"));
        addToYourCollectionButton.click();



    }
}
