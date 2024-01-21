import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DomaciZadatakPetak {


    //Domaci Zadatak 2:
    //Otici na sajt Herkouapp(https://the-internet.herokuapp.com/) i napisati sto vise test case-eva (Vas izbor sta cete testirati).

    WebDriver wd;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();

    }
    @BeforeMethod
    public void setUpPage(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get("https://the-internet.herokuapp.com/");
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(wd,Duration.ofSeconds(5));

    }
    @Test
    public void testAddAndRemoveElements() throws InterruptedException {
        WebElement addOrRemoveElementsButton = wd.findElement(By.linkText("Add/Remove Elements"));
        addOrRemoveElementsButton.click();
        WebElement addElementButton = wd.findElement(By.cssSelector("button[onclick='addElement()']"));
        addElementButton.click();
        WebElement deleteButton = wd.findElement(By.className("added-manually"));
        Assert.assertTrue(deleteButton.isDisplayed());
        deleteButton.click();
        boolean deleteIsPresent = false;
        try{
            Assert.assertFalse(deleteButton.isDisplayed());
            deleteIsPresent = true;
        }
        catch(Exception o){
            System.out.println(o);
        }
        Assert.assertFalse(deleteIsPresent);
    }
    @Test
    public void testJavaScriptAllerts(){
        WebElement javaScriptAllertsButton = wd.findElement(By.linkText("JavaScript Alerts"));
        javaScriptAllertsButton.click();
        WebElement clickForJsAllertButton = wd.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        WebElement clickForJsConfirmButton = wd.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        WebElement clickForJsPromptButton = wd.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        clickForJsAllertButton.click();
        Alert alertOK = wd.switchTo().alert();
        alertOK.accept();
        WebElement resultField = wd.findElement(By.id("result"));
        Assert.assertTrue(resultField.isDisplayed());

        clickForJsConfirmButton.click();
        alertOK = wd.switchTo().alert();
        alertOK.accept();
        WebElement resultField1 = wd.findElement(By.id("result"));
        Assert.assertTrue(resultField1.isDisplayed());

        clickForJsPromptButton.click();
        alertOK = wd.switchTo().alert();
        alertOK.accept();
        WebElement resultField2 = wd.findElement(By.id("result"));
        Assert.assertTrue(resultField2.isDisplayed());
    }
    @Test
    public void testRedirectButton(){
        WebElement redirectLinkButton = wd.findElement(By.linkText("Redirect Link"));
        redirectLinkButton.click();
        String urlAfterClickOnRedirectLink = "https://the-internet.herokuapp.com/redirector";
        WebElement clickHereButton = wd.findElement(By.id("redirect"));
        clickHereButton.click();
        Assert.assertNotEquals(wd.getCurrentUrl(),urlAfterClickOnRedirectLink);
    }
    @Test
    public void testHovers(){
        WebElement hoversButton = wd.findElement(By.linkText("Hovers"));
        hoversButton.click();
        Actions action = new Actions(wd);
        WebElement we = wd.findElement(By.className("figure"));
        action.moveToElement(we).build().perform();
        WebElement descriptionField = wd.findElement(By.className("figcaption"));
        Assert.assertTrue(descriptionField.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

}
