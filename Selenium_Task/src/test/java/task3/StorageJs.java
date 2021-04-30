package task3;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class StorageJs {
    public static JavascriptExecutor js;

    public static String getItemFromLocalStorage(String key) {
        return (String) js.executeScript(String.format(
                "return window.localStorage.getItem('%s');", key));
    }
    public static String getItemFromSessionStorage(String key) {
        return (String) js.executeScript(String.format(
                "return window.sessionStorage.getItem('%s');", key));
    }

    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        js = ((JavascriptExecutor)driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.maxlifeinsurance.com/term-insurance-plans/premium-calculator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        String localItem = getItemFromLocalStorage("eligibilityData");
        System.out.println("Local Storage");
        System.out.println(localItem);
        System.out.println(getItemFromLocalStorage("product"));
        System.out.println("Session Storage");
        String sessionItem = getItemFromSessionStorage("utmCode");
        System.out.println(sessionItem);

    }
}
