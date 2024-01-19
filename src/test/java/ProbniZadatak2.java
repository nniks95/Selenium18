import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class ProbniZadatak2 {
    public static void main(String[] args) {

        ////Zadatak 2
        ////Otvoriti browser i jos 5 tabova
        ////Na svakom tabu otvoriti URL po zelji
        ////Zatvoriti sve tabove osim onog gde je otvoren Google

        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();

        wd.get("https://www.google.com/");

        JavascriptExecutor js = (JavascriptExecutor) wd;
        for(int i = 0;i<5;i++){
            js.executeScript("window.open()");
        }

        ArrayList<String> lista = new ArrayList<>(wd.getWindowHandles());

        wd.switchTo().window(lista.get(1));
        wd.get("https://youtube.com/");
        wd.switchTo().window(lista.get(2));
        wd.get("https://facebook.com/");
        wd.switchTo().window(lista.get(3));
        wd.get("https://helloword.com/");
        wd.switchTo().window(lista.get(4));
        wd.get("https://github.com/");
        wd.switchTo().window(lista.get(5));
        wd.get("https://gmail.com/");

        /*for(int i = lista.size()-1; i>0;i--){
            wd.switchTo().window(lista.get(i));
            wd.close();
        }*/
        for(int i = 0;i<lista.size();i++){
            wd.switchTo().window(lista.get(i));
            if(!(wd.getCurrentUrl().equalsIgnoreCase("https://www.google.com/"))){
                wd.close();
            }

        }
    }
}
