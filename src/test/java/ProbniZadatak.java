import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProbniZadatak {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver wd = new ChromeDriver();

        wd.get("https://www.linkedin.com/");
        wd.navigate().refresh();
        wd.get("https://www.joberty.com/");
        wd.navigate().back();
        System.out.println(wd.getCurrentUrl());
        wd.quit();

    }
}
