import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak4 {
    public static void main(String[] args) {

        ////Zadatak 3
        ////Otici na Google
        ////Zatim ukucati "Wikipedia" u polje za pretragu
        ////Odraditi pretragu i otvoriti stranicu
        ////Na stranici Wikipedia pretraziti "Nikola Tesla"

        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get("https://www.google.com/");

        WebElement searchBox  = wd.findElement(By.name("q"));
        searchBox.sendKeys("Wikipedia");
        List<WebElement> searchButton = wd.findElements(By.name("btnK"));
        searchButton.get(0).click();
        WebElement wikipediaLink = wd.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        wikipediaLink.click();
        WebElement wikipediaSearch = wd.findElement(By.id("searchInput"));
        wikipediaSearch.sendKeys("Nikola Tesla");
        WebElement wikiSearchButton = wd.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive"));
        wikiSearchButton.click();

        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";
        Assert.assertEquals(wd.getCurrentUrl(),expectedURL);

        WebElement pageTitle = wd.findElement(By.className("mw-page-title-main"));
        String actualPageTitle = pageTitle.getText();

        String expectedTitle = "Nikola Tesla";
        Assert.assertEquals(actualPageTitle,expectedTitle);

        WebElement pageImagee = wd.findElement(By.className("infobox-image"));
        Assert.assertTrue(pageImagee.isDisplayed());
    }
}
