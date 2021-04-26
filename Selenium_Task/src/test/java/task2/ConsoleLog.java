package task2;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConsoleLog{

    WebDriver driver;

    @BeforeTest
    public void setDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void readConsoleLogs()
    {
        driver.manage().window().maximize();
        driver.get("https://www.tothenew.com/");
        // Mentioning type of Log
        LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
        // Retrieving all log
        List<LogEntry> logs= entry.getAll();
        // Print one by one
        for(LogEntry e: logs)
        {
            System.out.println(e);
        }

        // Printing details separately
        for(LogEntry e: logs)
        {
            System.out.println("Message is: " +e.getMessage());
            System.out.println("Level is: " +e.getLevel());
        }

    }
    @AfterTest
    public void TestsDone(){
        driver.close();
        System.out.println("Done");
    }
}

