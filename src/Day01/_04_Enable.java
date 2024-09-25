package Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class _04_Enable {
    @Test
    public void Test1() {
        System.out.println("Test-1 is executed.");
        driver.get("https://www.facebook.com/");
    }
    @Test(enabled = false) // şimdilik çalışma
    public void Test2() {
        System.out.println("Test-2 is executed.");
    }
    @Test
    public void Test3() {
        System.out.println("Test-3 is executed.");
        driver.get("https://www.google.com/");
    }
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    public void StartUp() {
        System.out.println("StartUp is executed.");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }
    @AfterClass
    public void TearDown() {
        System.out.println("TearDown is executed.");
        //Tools.wait(3);
        driver.quit();

    }
}
