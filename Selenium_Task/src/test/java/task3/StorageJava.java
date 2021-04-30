package task3;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

import java.util.concurrent.TimeUnit;
public class StorageJava {
    public static JavascriptExecutor js;

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        js = ((JavascriptExecutor) driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.maxlifeinsurance.com/term-insurance-plans/premium-calculator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        LocalStorage localStorage = webStorage.getLocalStorage();
        SessionStorage sessionStorage = webStorage.getSessionStorage();
        System.out.println(localStorage.getItem("eligibilityData"));
        System.out.println(sessionStorage.getItem("lead"));



    }
}