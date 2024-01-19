import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium7 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get("https://imgflip.com/memegenerator");
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10)); // 10 seconds timeout


        String imageLocation = "C:\\Users\\Niks\\Desktop\\memememe.jpg";

        WebElement uploadNewTemplate = wd.findElement(By.id("mm-show-upload"));
        uploadNewTemplate.click();
        Thread.sleep(2000);
        WebElement uploadImage = wd.findElement(By.id("mm-upload-file"));
        uploadImage.sendKeys(imageLocation);
        WebElement uploadButton = wd.findElement(By.id("mm-upload-btn"));
        uploadButton.click();

    }
}
