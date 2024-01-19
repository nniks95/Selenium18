import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.ENTER;

public class DomaciZadatak {


    public static void main(String[] args) {
        //Domaci Zadatak:
        //Otici na Google, zatim preko browser-a otici na YouTube i pustiti neku pesmu po Vasem izboru.

        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();

        wd.get("https://www.google.com/");
        wd.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea")).sendKeys("Youtube");
        wd.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea")).sendKeys(ENTER);
        wd.navigate().refresh();
        wd.findElement(By.xpath("/html/body/div[5]/div/div[10]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/div/span/a")).click();
        wd.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/form/div[1]/div[1]/input")).sendKeys("Plitak Potok");
        wd.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/form/div[1]/div[1]/input")).sendKeys(ENTER);
        wd.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[2]/div[1]/ytd-thumbnail/a/yt-image/img")).click();

        wd.quit();
        //Kod cas radi cas ne radi
    }
}
