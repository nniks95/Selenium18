import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DomaciZadatakPonedeljak {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();


        ////Domaci Zadatak 2:
        ////https://demoqa.com/text-box napisati test case za dati text box

        wd.get("https://demoqa.com/text-box/");
        WebElement fullNameField = wd.findElement(By.id("userName"));
        WebElement emailField = wd.findElement(By.id("userEmail"));
        WebElement currentAddressField = wd.findElement(By.id("currentAddress"));
        WebElement permanentAddressField = wd.findElement(By.id("permanentAddress"));
        WebElement submitButton = wd.findElement(By.id("submit"));
        String name = "Nikola Nikolic";
        String email = "nniks95@yahoo.com";
        String currentAdd = "Vojvode Stepe 1a";
        String permanentAdd = "Kralja Petra I 303";
        fullNameField.sendKeys(name);
        emailField.sendKeys(email);
        currentAddressField.sendKeys(currentAdd);
        permanentAddressField.sendKeys(permanentAdd);
        Thread.sleep(3000);
        submitButton.click();

        Assert.assertEquals(wd.getCurrentUrl(),"https://demoqa.com/text-box/");
        WebElement actualName = wd.findElement(By.id("name"));
        Assert.assertEquals(actualName.getText(),"Name:"+name);
        WebElement actualEmail = wd.findElement(By.id("email"));
        Assert.assertEquals(actualEmail.getText(),"Email:"+email);






    }
}
