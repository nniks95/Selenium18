import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get("https://www.google.com/");

        //lokatori
        //id
        WebElement searchBoxID = wd.findElement(By.id("APjFqb"));
        //name
        WebElement searchBoxByName = wd.findElement(By.name("q"));
        //class
        WebElement searchBoxByClass = wd.findElement(By.className("gLFyf"));
        //css selector
        WebElement searchBoxByCSS = wd.findElement(By.cssSelector("textarea[type='search]"));
        //relative xpath
        WebElement searchBoxRelativeXpath = wd.findElement(By.xpath(""));
        //absolute xpath
        WebElement searchBoxAbsoluteXpath = wd.findElement(By.xpath(""));



    }
}
