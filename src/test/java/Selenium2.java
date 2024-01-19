import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();

        wd.get("https://www.google.com/");
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(listaTabova.get(1));
        wd.get("https://linkedin.com/");
        wd.switchTo().window(listaTabova.get(2));
        wd.get("https://www.joberty.com/");
        wd.switchTo().window(listaTabova.get(3));
        wd.get("https://youtube.com/");

        wd.close();
        wd.switchTo().window(listaTabova.get(2));
        wd.close();
        wd.switchTo().window(listaTabova.get(1));
        wd.close();
    }
}
