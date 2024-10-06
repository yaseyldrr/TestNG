package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void StartUp() {
        System.out.println("StartUp is executed.");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        driver.get("https://opencart.abstracta.us/");
        driver.manage().window().maximize();

        WebElement myAcc = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[1]"));
        myAcc.click();
        Tools.Wait(2);

        WebElement login = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]/a"));
        login.click();
        Tools.Wait(2);

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("yasetest1@gmail.com");
        Tools.Wait(2);

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("messi");
        Tools.Wait(2);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/form/input"));
        loginButton.click();
        Tools.Wait(2);
    }
     @AfterClass
    public void TearDown() {
        System.out.println("TearDown is executed.");
        //Tools.wait(3);
        driver.quit();
    }
}
